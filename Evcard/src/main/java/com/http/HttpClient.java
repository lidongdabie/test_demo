package com.http;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLInitializationException;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * httpclient操作类
 *
 * @author jin wei
 */
public class HttpClient {
	private static final Logger LOG = LogManager.getLogger(HttpClient.class);
	public static CloseableHttpClient httpClient = null;
	public static CloseableHttpClient httpClientWithoutRedirect = null;
	public static HttpClientContext context = null;
	public static CookieStore cookieStore = null;
	public static RequestConfig requestConfig = null;
	public static PoolingHttpClientConnectionManager phccm;

	static {
		init();
	}

	//初始化http请求
	@SuppressWarnings("deprecation")
	private static void init() {
		context = HttpClientContext.create();
		cookieStore = new BasicCookieStore();
		LayeredConnectionSocketFactory ssl = null;
		try {
			ssl = SSLConnectionSocketFactory.getSystemSocketFactory();
		} catch (final SSLInitializationException ex) {
			final SSLContext sslcontext;
			try {
				sslcontext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
				sslcontext.init(null, null, null);
				ssl = new SSLConnectionSocketFactory(sslcontext);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// ssl registry
		SSLContext sslContext = getSSLContext();
		final Registry<ConnectionSocketFactory> sfr = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(sslContext)).build();

		// 配置HTTPmanager里面路由跳转和激活时间
		phccm = new PoolingHttpClientConnectionManager(sfr);
		phccm.setDefaultMaxPerRoute(100);
		phccm.setMaxTotal(200);
		phccm.setValidateAfterInactivity(10000);
		// 配置超时时间（连接服务端超时1秒，请求数据返回超时2秒）
		requestConfig = RequestConfig.custom().setConnectTimeout(12000000).setSocketTimeout(6000000)
				.setConnectionRequestTimeout(60000000).setStaleConnectionCheckEnabled(true).build();
		// 设置默认跳转以及存储cookie
		httpClient = HttpClientBuilder.create().setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
				.setRedirectStrategy(new DefaultRedirectStrategy()).setConnectionManager(phccm)
				.setDefaultRequestConfig(requestConfig).setDefaultCookieStore(cookieStore).build();
		// 设置默认跳转以及存储cookie
		httpClientWithoutRedirect = HttpClientBuilder.create().setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
				.setRedirectStrategy(new RedirectStrategy(){
					@Override
					public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context) throws ProtocolException {
						return false;
					}
					@Override
					public HttpUriRequest getRedirect(HttpRequest request, HttpResponse response, HttpContext context) throws ProtocolException {
						return null;
					}
				}).setConnectionManager(phccm)
				.setDefaultRequestConfig(requestConfig).setDefaultCookieStore(cookieStore).build();
	}

	private static SSLContext getSSLContext() {
		try {
			// 这里可以填两种值 TLS和LLS , 具体差别可以自行搜索
			SSLContext sc = SSLContext.getInstance("TLS");
			// 构建新对象
			X509TrustManager manager = new X509TrustManager() {
				@Override
				public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
				}

				// 这里返回Null
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			sc.init(null, new TrustManager[]{manager}, null);
			return sc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * http get
	 *
	 * @param url
	 * @return response
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static CloseableHttpResponse get(String url,String token) throws ClientProtocolException, IOException {
		return get(url, true,token);
	}

	public static CloseableHttpResponse get(String url, boolean withRedirect,String token) throws ClientProtocolException, IOException {
		HttpGet httpget = new HttpGet(url);
		httpget.addHeader("token",token);
		httpget.addHeader("appType", "0");
		CloseableHttpResponse response;
		if (withRedirect) {
			response = httpClient.execute(httpget, context);
		} else {
			response = httpClientWithoutRedirect.execute(httpget, context);
		}
		try {
			cookieStore = context.getCookieStore();
			List<Cookie> cookies = cookieStore.getCookies();
			for (Cookie cookie : cookies) {
				System.out.println("key:" + cookie.getName() + "  value:" + cookie.getValue());
			}
		} finally {
//			if (response != null) {
//				response.close();
//			}
		}
		return response;
	}

	/**
	 * http post(使用form表单)
	 *
	 * @param url
	 * @param parameters
	 *            form表单
	 * @return response
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static CloseableHttpResponse post(String url, String parameters,String token)
			throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE,"application/x-www-form-urlencoded");
        httpPost.addHeader("token",token);
		List<NameValuePair> nvps = toNameValuePairList(parameters);
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
		CloseableHttpResponse response = httpClient.execute(httpPost, context);
		//兼容登录接口返回302重定向的逻辑
		if(response.getStatusLine().getStatusCode()==302){
			String Location=response.getFirstHeader("Location").getValue();
			return post(Location,parameters,token);
		}
		return response;
	}

	@SuppressWarnings("unused")
	public static List<NameValuePair> toNameValuePairList(String parameters) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		String[] paramList = parameters.split("&");
		for (String parm : paramList) {
			int index = -1;
			for (int i = 0; i < parm.length(); i++) {
				index = parm.indexOf("=");
				break;
			}
			String key = parm.substring(0, index);
			String value = parm.substring(++index, parm.length());
			nvps.add(new BasicNameValuePair(key, value));
		}
		return nvps;
	}

	/**
	 * 手动增加cookie
	 *
	 * @param name
	 * @param value
	 * @param domain
	 * @param path
	 */
	public static void addCookie(String name, String value, String domain, String path) {
		BasicClientCookie cookie = new BasicClientCookie(name, value);
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookieStore.addCookie(cookie);
	}

	/**
	 * 把结果console出来
	 *
	 * @param httpResponse
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void printResponse(HttpResponse httpResponse) throws ParseException, IOException {
		// 获取响应消息实体
		HttpEntity entity = httpResponse.getEntity();
		// 响应状态
		System.out.println("status:" + httpResponse.getStatusLine());
		System.out.println("headers:");
		HeaderIterator iterator = httpResponse.headerIterator();
		while (iterator.hasNext()) {
			System.out.println("\t" + iterator.next());
		}
		// 判断响应实体是否为空
		if (entity != null) {
			String responseString = EntityUtils.toString(entity);
			System.out.println("response length:" + responseString.length());
			System.out.println("response content:" + responseString.replace("\r\n", ""));
		}
		System.out.println(
				"------------------------------------------------------------------------------------------\r\n");
	}

	/**
	 * 把当前cookie从控制台输出出来
	 *
	 */
	public static String printCookies(String key) {
		String result = null;
		cookieStore = context.getCookieStore();
		List<Cookie> cookies = cookieStore.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().contentEquals(key)){
				result = cookie.getValue();
			}
		}
		return result;
	}

	/**
	 * 检查cookie的键值是否包含传参
	 *
	 * @param key
	 * @return
	 */
	public static boolean checkCookie(String key) {
		cookieStore = context.getCookieStore();
		List<Cookie> cookies = cookieStore.getCookies();
		boolean res = false;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				res = true;
				break;
			}
		}
		return res;
	}

	/**
	 * 直接把Response内的Entity内容转换成String
	 *
	 * @param httpResponse
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String toString(CloseableHttpResponse httpResponse) throws ParseException, IOException {
		// 获取响应消息实体
		HttpEntity entity = httpResponse.getEntity();
		if (entity != null)
			return EntityUtils.toString(entity);
		else
			return null;
	}


	//post方法无表单
	public static CloseableHttpResponse post0Parameter(String url,String appType)
			throws ClientProtocolException, IOException {
		System.out.println(url);
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("appType", appType);
//		List<NameValuePair> nvps = toNameValuePairList(parameters);
//		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
		CloseableHttpResponse response = httpClient.execute(httpPost, context);
		try {
			cookieStore = context.getCookieStore();
			List<Cookie> cookies = cookieStore.getCookies();
			for (Cookie cookie : cookies) {
				LOG.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
			}
		} finally {
//			if (response != null) {
//				response.close();
//			}
		}
		return response;
	}

	//post json参数的
	public static CloseableHttpResponse postJson(String url, String parameters,String token)
			throws ClientProtocolException, IOException {

		System.out.println(url);
		HttpPost httpPost = new HttpPost(url);
//\\		String encoderJson = URLEncoder.encode(parameters, "UTF-8");
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
		httpPost.addHeader("appType", String.valueOf(0));
		//httpPost.addHeader("token",token);
		//添加凭证
		/*if(Authorization.auth!=null){
			httpPost.addHeader(HttpHeaders.AUTHORIZATION,Authorization.auth);
			//System.out.println(Authorization.auth);
		}*/
		//httpPost.addHeader(HttpHeaders.USER_AGENT,null);
		StringEntity se = new StringEntity(parameters, Charset.forName("UTF-8"));
		se.setContentType("application/json");
		httpPost.setEntity(se);
		CloseableHttpResponse response = httpClient.execute(httpPost, context);
		//InputStream is = response.getEntity().getContent();
		//String result = org.apache.commons.io.IOUtils.toString(is, "utf-8");
		try {
			cookieStore = context.getCookieStore();
			List<Cookie> cookies = cookieStore.getCookies();
			for (Cookie cookie : cookies) {
				LOG.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
			}
		} finally {

		}
		return response;
	}

	//post json参数的
	public static CloseableHttpResponse postJson2(String url, String parameters)
			throws ClientProtocolException, IOException {

		HttpPost httpPost = new HttpPost(url);
//\\		String encoderJson = URLEncoder.encode(parameters, "UTF-8");
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");
		//添加凭证
		/*if(Authorization.auth!=null){
			httpPost.addHeader(HttpHeaders.AUTHORIZATION,Authorization.auth);
			//System.out.println(Authorization.auth);
		}*/
		//httpPost.addHeader(HttpHeaders.USER_AGENT,null);
		StringEntity se = new StringEntity(parameters, Charset.forName("UTF-8"));
		se.setContentType("application/x-www-form-urlencoded");
		httpPost.setEntity(se);
		CloseableHttpResponse response = httpClient.execute(httpPost, context);
		//InputStream is = response.getEntity().getContent();
		//String result = org.apache.commons.io.IOUtils.toString(is, "utf-8");
		try {
			cookieStore = context.getCookieStore();
			List<Cookie> cookies = cookieStore.getCookies();
			for (Cookie cookie : cookies) {
				LOG.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
			}
		} finally {

		}
		return response;
	}

	public static CloseableHttpResponse put(String url, boolean withRedirect) throws ClientProtocolException, IOException {
		HttpPut httpput = new HttpPut(url);
		CloseableHttpResponse response;
		if (withRedirect) {
			response = httpClient.execute(httpput, context);
		} else {
			response = httpClientWithoutRedirect.execute(httpput, context);
		}
		try {
			cookieStore = context.getCookieStore();
			List<Cookie> cookies = cookieStore.getCookies();
			for (Cookie cookie : cookies) {
				LOG.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
			}
		} finally {
//			if (response != null) {
//				response.close();
//			}
		}
		return response;
	}

	public static CloseableHttpResponse putJson(String url, String parameters)
			throws ClientProtocolException, IOException {

		HttpPut httpPut = new HttpPut(url);
//\\		String encoderJson = URLEncoder.encode(parameters, "UTF-8");
		httpPut.addHeader(HTTP.CONTENT_TYPE, "application/json");
		//添加凭证
		/*if(Authorization.auth!=null){
			httpPost.addHeader(HttpHeaders.AUTHORIZATION,Authorization.auth);
			//System.out.println(Authorization.auth);
		}*/
		//httpPost.addHeader(HttpHeaders.USER_AGENT,null);
		StringEntity se = new StringEntity(parameters, Charset.forName("UTF-8"));
		se.setContentType("application/json");
		httpPut.setEntity(se);
		CloseableHttpResponse response = httpClient.execute(httpPut, context);
		//InputStream is = response.getEntity().getContent();
		//String result = org.apache.commons.io.IOUtils.toString(is, "utf-8");
		try {
			cookieStore = context.getCookieStore();
			List<Cookie> cookies = cookieStore.getCookies();
			for (Cookie cookie : cookies) {
				LOG.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
			}
		} finally {

		}
		return response;
	}

	//post json参数的
	public static CloseableHttpResponse postform(String url, String parameters ,String a,String b,String d)
			throws Exception {
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");
		StringEntity se = new StringEntity(parameters, Charset.forName("UTF-8"));
		se.setContentType("form-data");
		httpPost.setEntity(se);
		httpPost.addHeader(HTTP.USER_AGENT,"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36");
		//httpPost.addHeader("Accept","application/json");
		addCookie("JSESSIONID-L",a,".zj.122.gov.cn","/");
		//addCookie("acw_tc",b,".hb.122.gov.cn","/");
		//addCookie("__jsluid_s",c,".sh.122.gov.cn","/");
		addCookie("accessToken",d,".zj.122.gov.cn","/");
		context.setCookieStore(cookieStore);
		CloseableHttpResponse response = httpClient.execute(httpPost, context);
		return response;
	}
}
