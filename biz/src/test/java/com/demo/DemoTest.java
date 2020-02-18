/*
package com.demo;


import com.datadriver.AutoDataDriverBase;
import com.json.JSONParser;
import com.sql.EvcardDataBase;
import com.tools.Time;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;


*/
/**
 * @author jin wei
 *
 *//*

public class DemoTest extends AutoDataDriverBase {
	CloseableHttpResponse response;

	//测试数据驱动
	@Test(dataProvider = "CsvDataProvider")
	public void testDataProvider(String link,int num) throws ClientProtocolException, IOException {
		System.out.println("Link32: "+link+"\r\nnum: "+num);

	}

	//测试数据库调用
	@Test
	public void testMySQLQuery(){
		Object sourceValue = EvcardDataBase.getInfo();
		System.out.println(sourceValue.toString());
	}

	//获取时间戳
	@Test
	public void testNr_force(){
		System.out.println("_nr_force="+ Time.getUnixTimestamp());
	}

	//测试json格式解析
	@Test
	public void testJSON_phase() throws UnsupportedOperationException, IOException{
//		String json = "{\"code\":200,\"msg\":{\"list\":[{\"id\":1042064,\"name\":\"推广计划11111\"},{\"id\":1042006,\"name\":\"酒店推广计划201508171117\"},{\"id\":1042005,\"name\":\"酒店推广计划201508171051\"}]}}";
		String json = "{\"code\":200,\"msg\":{\"tabData\":{\"16\":\"1\",\"1\":\"6\",\"2\":\"0.66\",\"3\":\"9\",\"4\":\"2,421\",\"5\":\"570\",\"6\":\"0\",\"7\":\"1\",\"8\":\"4\",\"9\":\"6\",\"13\":\"39\",\"14\":\"18\"},\"chartData\":{\"line\":{\"datas\":[0.0,0.0,0.0,6.0,0.0],\"labels\":[\"09-18\",\"09-19\",\"09-20\",\"09-21\",\"09-22\"]},\"pie\":{\"datas\":[],\"labels\":[]}},\"chartNumber\":2}}";
		String json2 = "{\"code\":200,\"msg\":{\"tabData\":{\"16\":\"1\",\"1\":\"6\",\"2\":\"0.66\",\"3\":\"9\",\"4\":\"2,421\",\"5\":\"570\",\"6\":\"0\",\"7\":\"1\",\"8\":\"4\",\"9\":\"6\",\"13\":\"39\",\"14\":\"18\"},\"chartData\":{\"line\":{\"datas\":[0.0,0.0,0.0,6.0,0.0],\"labels\":[\"09-18\",\"09-19\",\"09-20\",\"09-21\",\"09-22\"]},\"pie\":{\"datas\":[],\"labels\":[]}},\"chartNumber\":2}}";
		JSONParser p = new JSONParser(json);
		System.out.print(p.object().getObject("msg").getObject("tabData").get("1"));
	}

}

*/
