package com.pages;

import com.http.HttpClient;
import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.internal.thread.ThreadTimeoutException;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


/**
 * Created by Velocity on 2017年-06月29日-15时03分11秒.
 */
public class Evcard_Ids_Page{

//    public String test(String JSESSIONID,String acw_tc,String accessToken,String csvpath) throws Exception {
//        String s = "https://fj.122.gov.cn/user/m/userinfo/vehs";
//        String param = "page=1&size=5080";
//        String result = HttpClient.toString(HttpClient.postform(s,param,JSESSIONID,acw_tc,accessToken));
//        return result;
//    }

    public String test5(String hphm,String hpzl,String xh,String cjjg,String JSESSIONID,String acw_tc,String accessToken) throws Exception {
        String s = "https://zj.122.gov.cn/user/m/tsc/vio/querySurvielDetail";
        String param = String.format("hphm=%s&hpzl=%s&xh=%s&cjjg=%s",hphm,hpzl,xh,cjjg);
        String result = HttpClient.toString(HttpClient.postform(s,param,JSESSIONID,acw_tc,accessToken));
        return result;
    }

    public List<HashMap> test3(String JSESSIONID,String acw_tc,String accessToken,String csvpath) throws Exception {
        String s = "https://zj.122.gov.cn/user/m/userinfo/vehs";
        String s2 = "https://zj.122.gov.cn/user/m/tsc/veh/vehlist";
        String param = "page=1&size=100000";
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<HashMap> authors = new ArrayList<>();
        String result = HttpClient.toString(HttpClient.postform(s,param,JSESSIONID,acw_tc,accessToken));
        String result3 = HttpClient.toString(HttpClient.postform(s2,param,JSESSIONID,acw_tc,accessToken));
        Integer j = JsonPath.read(result, "$.data.totalPages");
        List<HashMap> author_10 = JsonPath.read(result, "$.data.content[*]['hphm','hpzlStr']");
        System.out.println("查询非运营车牌数据第1页");
        authors.addAll(author_10);

        for(int i =2;i<=j;i++){
            int finalI = i;
            Runnable task = new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    String param2 = String.format("page=%s&size=100", finalI);
                    String result2 = HttpClient.toString(HttpClient.postform(s,param2,JSESSIONID,acw_tc,accessToken));
                    List<HashMap> author = JsonPath.read(result2, "$.data.content[*]['hphm','hpzlStr']");
                    System.out.println("查询非运营车牌数据第"+ finalI +"页");
                    authors.addAll(author);
                }
            };
            executor.submit(task);
        }
        executor.shutdown();
        while (true){
            if(executor.isTerminated()){
                System.out.println("所有子线程结束!");
                break;
            }
        }

        System.out.println("查询运营车辆");
        List<HashMap> author_3=JsonPath.read(result3, "$.data.content[*]['xh','hphm','hpzlStr']");
        authors.addAll(author_3);
        System.out.println("查询完毕,一共"+authors.size()+"辆车");
        return authors;
    }

    public List<String> test2(HashMap xh,String a,String b,String d,String startdate,String enddate) throws Exception {
        String s = "https://zj.122.gov.cn/user/m/uservio/suriquery";
        String s2 = "https://zj.122.gov.cn/user/m/tsc/vio/querySurveilVeh";
        String usbkey = "https://zj.122.gov.cn/user/m/rentveh/querySurveilList";
        final String[] result = {""};
        final String[] param = {""};
        List<String> resultlist = new ArrayList();
        ExecutorService executor = Executors.newFixedThreadPool(9);
        int i = 1;
        do{
            try {
                if(i<4){
                    if(xh.size()!=3){
                        for(int j=1;j<10;j++){
                            if(xh.get("hpzlStr").equals("小型新能源汽车")){
                                param[0] = String.format("startDate=%s&endDate=%s&hpzl=52&hphm=%s&type=0&page=%s",startdate,enddate,xh.get("hphm"), j);
                            }else {
                                param[0] = String.format("startDate=%s&endDate=%s&hpzl=02&hphm=%s&page=%s&type=0",startdate,enddate,xh.get("hphm"), j);
                            }
                            result[0] = HttpClient.toString(HttpClient.postform(s, param[0],a,b,d));
                            if(!result[0].isEmpty()){
                                List<HashMap> authors = JsonPath.read(result[0], "$.data.content[*]['wfms','fkje','wfjfs','hphm','wfdz','wfsj','clbjStr','jkbjStr','hpzlStr']");
                                if(authors.size()!=0){
                                    resultlist.add(result[0]);
                                }
                            }
                        };
//                        Thread.sleep(3000);
                    }else {
                       String param2 = String.format("xh=%s&size=10",xh.get("xh"));
                        result[0] = HttpClient.toString(HttpClient.postform(s2, param2,a,b,d));
                        if(!result[0].isEmpty()){
                            List<HashMap> authors = JsonPath.read(result[0], "$.data.content[*]['wfms','fkje','wfjfs','hphm','wfdz','wfsj','clbjStr','jkbjStr','hpzlStr']");
                            if(authors.size()!=0){
                                resultlist.add(result[0]);
                            }
                        }
//                        Thread.sleep(3000);
                    }
                    }
            }
        catch (Exception e){
            System.out.println("出错信息"+e.toString()+"   车辆牌照:"+xh.get("hphm"));
            System.out.println("请求数据result:"+ result[0].toString()+"，重试"+i+"次");
            i++;
        }
        }while (result[0].equals("")&&(i<4));
        return resultlist;
    }

    public static void contentToTxt(String filePath, String content) {
        String str = new String(); //原有txt内容
        String s1 = new String();//内容更新
        try {
            File f = new File(filePath);
            if (f.exists()) {
                System.out.print("文件存在");
            } else {
                System.out.print("文件不存在");
                f.createNewFile();// 不存在则创建
            }
            BufferedReader input = new BufferedReader(new FileReader(f));

            while ((str = input.readLine()) != null) {
                s1 += str + "\n";
            }
            System.out.println(s1);
            input.close();
            s1 += content;

            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(s1);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public String test4(String telephone) throws IOException {
        ThreadLocal<String> result = new ThreadLocal<>();
        ThreadLocal<String> result2 = new ThreadLocal<>();
        ThreadLocal<List<String>> token = new ThreadLocal<>();
        try {
            String s = "http://sgm-test.evcard.vip/sgm-mas/api/login";
            String parm = String.format("{\"password\":\"123456\",\"appType\":0,\"loginName\":\"%s\",\"imei\":\"afdd7455-8f78-39f3-b2e4-8081736f5e1d\",\"memberType\":0,\"channelId\":\"13065ffa4e1a6968f78\"}",telephone);
            System.out.println(Thread.currentThread()+"线程"+"执行登录接口");
            result.set(HttpClient.toString(HttpClient.postJson(s, parm,"")));
            System.out.println(result.get());
            Assert.assertEquals("登录成功",JsonPath.read(result.get(),"$.message"));
            token.set(JsonPath.read(result.get(),"$.resultData..token"));
            String s2 = "http://sgm-test.evcard.vip/sgm-mas/api/v2/getUserInfo";
            System.out.println(Thread.currentThread()+"线程"+"执行getUserInfo接口");
            result2.set(HttpClient.toString(HttpClient.get(s2,token.get().get(0))));
            Assert.assertEquals("查询成功",JsonPath.read(result2.get(),"$.message"));
            System.out.println(result2.get());
            System.out.println("执行完毕");
        }catch (Exception e){
            System.out.println(e);
        }

        return result.get();
    }

//    public void test3(String url) throws IOException {
//        String  result = HttpClient.toString(HttpClient.get(url));
//
//    }
}
