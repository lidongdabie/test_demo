package com.tools;

/**
 * Created by mia on 2017/8/3.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpProxy {
    private static class SingletonHolder {
        static final HttpProxy instance = new HttpProxy();
    }

    public static HttpProxy getInstance() {
        return SingletonHolder.instance;
    }

    private static CloseableHttpClient httpClient;

    private static final String CONTENT_TYPE_JSON = "application/json";

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(HttpProxyConfig.MAX_TOTAL_CONNECTIONS);
        cm.setDefaultMaxPerRoute(HttpProxyConfig.MAX_ROUTE_CONNECTIONS);


        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(HttpProxyConfig.CONNECT_TIMEOUT)
                .setConnectTimeout(HttpProxyConfig.CONNECT_TIMEOUT)
                .build();
        //缓存
        /*
         CacheConfig cacheConfig = CacheConfig.custom()
                .setMaxCacheEntries(1000)
                .setMaxObjectSize(8192)
                .build();
        */
        httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(cm)
                .build();
    }

    public static HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * <B>方法名称：</B>普通请求<BR>
     * <B>概要说明：</B>普通请求<BR>
     * @param requestUrl 请求路径
     * @param requestContent 请求内容
     * @return 返回响应结果
     * @throws IOException
     */
    public static String post(String requestUrl, String requestContent) throws IOException {
        StringEntity requestEntity = new StringEntity(requestContent, Consts.UTF_8);
        return execute(requestUrl,requestEntity);
    }

    /**
     * 功能:发送json请求
     * @param requestUrl   请求路径url
     * @param jsonContent  json字符串
     * @return 返回json字符串
     * @throws IOException
     */
    public static String postJson(String requestUrl, String jsonContent) throws IOException {
        StringEntity requestEntity = new StringEntity(jsonContent, Consts.UTF_8);
        requestEntity.setContentEncoding("UTF-8");
        requestEntity.setContentType(CONTENT_TYPE_JSON);
        return execute(requestUrl,requestEntity);
    }

    /**
     * <B>方法名称：</B>模拟表单上传<BR>
     * <B>概要说明：</B>模拟表单上传<BR>
     * @param requestUrl 请求路径
     * @param params 属性参数
     * @return 返回响应结果
     * @throws IOException
     */
    public static String post(String requestUrl, Map<String, String> params) throws IOException {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        EntityBuilder builder = EntityBuilder.create();
        builder.setParameters(nvps);
        HttpEntity httpEntity = builder.build();
        return execute(requestUrl,httpEntity);
    }

    /**
     * <B>方法名称：</B>上传文件<BR>
     * <B>概要说明：</B>上传文件<BR>
     * @param requestUrl 请求路径
     * @param localFile  文件位置
     * @param username       用户名
     * @param password       密码
     * @return 响应信息
     * @throws IOException
     */
    public static String upload(String requestUrl, String localFile, String username, String password) throws IOException {
        HttpPost httpPost = new HttpPost(requestUrl);
        // 把文件转换成流对象FileBody
        FileBody fileBody = new FileBody(new File(localFile));
        StringBody usernameInp = new StringBody(username, ContentType.create("text/plain", Consts.UTF_8));
        StringBody passwordInp = new StringBody(password, ContentType.create("text/plain", Consts.UTF_8));
        HttpEntity httpEntity = MultipartEntityBuilder.create()
                // 相当于<input type="file" name="file"/>
                .addPart("file", fileBody)
                // 相当于<input type="text" name="userName" value=userName>
                .addPart("username", usernameInp)
                .addPart("password", passwordInp)
                .build();
        return execute(requestUrl,httpEntity);
    }

    /**
     * 功能:执行请求方法
     * @param requestUrl 请求路径Url
     * @param httpEntity  封装好的http实体
     * @return json字符串
     * @throws IOException
     */
    private static String execute(String requestUrl, HttpEntity httpEntity) throws IOException {
        String result = null;
        HttpPost httpPost = new HttpPost(requestUrl);
        httpPost.setEntity(httpEntity);
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            try {
                HttpEntity entity = httpResponse.getEntity();
                if (httpResponse.getStatusLine().getReasonPhrase().equals("OK") && httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result = EntityUtils.toString(entity, "UTF-8");
                }
                //进行销毁
                EntityUtils.consume(entity);
            } finally {
                if (null != httpResponse) {
                    httpResponse.close();
                }
            }
        } finally {
            if (null != httpPost) {
                httpPost.releaseConnection();
            }
        }
        return result;
    }
    /**
     * 功能:发送http的get请求
     * @param requestUrl   请求url
     * @return 字符串
     */
    public static String get(String requestUrl){
        HttpGet httpGet = new HttpGet(requestUrl);
        // 执行get请求.
        CloseableHttpResponse response =null;
        HttpEntity entity =null;
        String result =null;
        try {
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            // 打印响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                // 打印响应内容长度
                System.out.println("Response content length: " + entity.getContentLength());
                // 打印响应内容
                result = EntityUtils.toString(entity);
                System.out.println("Response content: " + result);
            }
            System.out.println("------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }



}