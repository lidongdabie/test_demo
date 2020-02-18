package com.tools;

import com.google.gson.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LTT on 15/12/24.
 */
public class SwallowUtil {

    //swallow消息发送
    public void swallowSend(){

    }

    //swallow消息获取-------只获取最新的有内容的swallow消息
    public JsonObject swallowReceive(String topic) throws IOException {
        String url="http://beta.swallow.dp/console/message/auth/list";
        //post的jsonStr获取，因为直接使用jsonstr有问题，改用map获取
        Map map=new HashMap();
        map.put("offset",0);
        map.put("limit",10);//设置一次取多少
        map.put("topic",topic);
        map.put("messageId", "");
        map.put("basemid","");
        map.put("sort",false);
        Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
        String jsonStr = gson.toJson(map);
        //httppost请求执行
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost(url);
        StringEntity input = new StringEntity(jsonStr);
        input.setContentType("application/json;charset=UTF-8");
        postRequest.setEntity(input);
        input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
        postRequest.setHeader("Accept", "application/json");
        postRequest.setEntity(input);
        HttpResponse response = httpClient.execute(postRequest);
        //解析json对象
        String s= EntityUtils.toString(response.getEntity());
//        System.out.println("s="+s+"\n");
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(s);
        JsonObject jsonobj = element.getAsJsonObject();
        JsonArray jsonArray=jsonobj.get("message").getAsJsonArray();

        JsonObject result = new JsonObject();

        for(int i=0;i<jsonArray.size();i++){
            String midStr=jsonobj.get("message").getAsJsonArray().get(i).getAsJsonObject().get("mid").toString().replace("\"","");
            Long longStr=Long.parseLong(midStr);
            String contentStr="http://beta.swallow.dp/console/message/auth/content?mid="+longStr+"&topic=dp_account_change";
            HttpGet getRequest=new HttpGet(contentStr);
            HttpResponse contentResponse = httpClient.execute(getRequest);
            //解析json对象
            JsonElement jsonElement = parser.parse(EntityUtils.toString(contentResponse.getEntity()));
            JsonObject contentJsonobj = jsonElement.getAsJsonObject();
            String c=contentJsonobj.get("c").toString().replace("\\\"","\"");
            //去除“” 双引号
            c = c.substring(1, c.length() - 1);
//            System.out.println("c:="+c+"\n");
            if(!c.contains("4|")) {
                //解析json对象
                jsonElement=parser.parse(c);
                result= jsonElement.getAsJsonObject();
                break;
            }
        }
        return result;
    }

    //swallow消息转换
    public int swallow2Int(JsonObject jsonObject, String key){
        return Integer.parseInt(jsonObject.get(key).toString());
    }
    public double swallow2Double(JsonObject jsonObject, String key){
        return Double.parseDouble(jsonObject.get(key).toString());
    }
    public String swallow2String(JsonObject jsonObject, String key) {
        return jsonObject.get(key).toString();
    }

}
