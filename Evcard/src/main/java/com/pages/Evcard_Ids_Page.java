package com.pages;

import com.http.HttpClient;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Velocity on 2017年-06月29日-15时03分11秒.
 */
public class Evcard_Ids_Page{

    public String test(String JSESSIONID,String acw_tc,String accessToken,String csvpath) throws Exception {
        String s = "https://gd.122.gov.cn/user/m/tsc/veh/vehlist";
        String param = "page=1&size=5080";
        String result = HttpClient.toString(HttpClient.postform(s,param,JSESSIONID,acw_tc,accessToken));
        return result;
    }

    public List<HashMap> test3(String JSESSIONID,String acw_tc,String accessToken,String csvpath) throws Exception {
        String s = "https://hi.122.gov.cn/user/m/userinfo/vehs";
        String param = "page=1&size=100";
        List<HashMap> authors = new ArrayList<>();
        String result = HttpClient.toString(HttpClient.postform(s,param,JSESSIONID,acw_tc,accessToken));
        Integer j = JsonPath.read(result, "$.data.totalPages");
        List<HashMap> author_10 = JsonPath.read(result, "$.data.content[*]['hphm','hpzlStr']");
        System.out.println("查询车牌数据第1页");

        authors.addAll(author_10);

        for(int i =2;i<=j;i++){
            String param2 = String.format("page=%s&size=100",i);
            String result2 = HttpClient.toString(HttpClient.postform(s,param2,JSESSIONID,acw_tc,accessToken));
            List<HashMap> author = JsonPath.read(result2, "$.data.content[*]['hphm','hpzlStr']");
            System.out.println("查询车牌数据第"+i+"页");
            authors.addAll(author);
        }
        System.out.println("查询完毕,一共"+authors.size()+"辆车");
        return authors;
    }

    public List<String> test2(String xh,String a,String b,String d) throws IOException {
        String s = "https://gd.122.gov.cn/user/m/tsc/vio/querySurveilVeh";
        String result = "";
        String param = String.format("xh=%s&size=1000",xh);
        List<String> resultlist = new ArrayList();
        int i = 1;
        do{
            try {
                if(i<4){
                    for(int j=1;j<10;j++){
                        result = HttpClient.toString(HttpClient.postform(s,param,a,b,d));
                        List<HashMap> authors = JsonPath.read(result, "$.data.content[*]['wfms','fkje','wfjfs','hphm','wfdz','wfsj','clbjStr','jkbjStr','hpzlStr']");
                       if(authors.size()!=0){
                           resultlist.add(result);
                       }
                      // Thread.sleep(8000);
                    }
                }
            }catch (Exception e){
                System.out.println(e.toString());
                System.out.println("请求无数据返回，重试"+i+"次");
                i++;
            }
        } while (result.equals(""));
        return resultlist;
    }






//    public void test3(String url) throws IOException {
//        String  result = HttpClient.toString(HttpClient.get(url));
//
//    }
}
