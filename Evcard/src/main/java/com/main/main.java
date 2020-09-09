package com.main;

import com.asserts.Evcard_Ids_Assert;
import net.minidev.json.JSONUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    //static String csvpath = null;
    static String csvpath_carNo =null;
    public static String csvpath_carNo2 =null;
    public static String exportFilePath = null;
//    public static String business = "1";  //是否有运营车辆 0 无  1 有
//    public static String download = "0"; //是否需要断点续传 0 不需要 1 需要
    //入参
    public static String business = System.getProperty("business");  //是否有运营车辆 0 无  1 有
    public static String download = System.getProperty("download") ; //是否需要断点续传 0 不需要 1 需要
    //public static String Cookie = System.getProperty("cookie");   //登录后cookie
    public static String host = System.getProperty("host");       //cookie域名
    public static String usbkey = System.getProperty("usbkey");   //是否要usbkey
    public static String startdate = System.getProperty("startdate"); //开始时间
    public static String enddate = System.getProperty("enddate");    //结束时间


    public static void main(String args[]) throws Exception {


        String Cookie = "BIGipServerg-jg6h1-9000=1829349568.10275.0000; _uab_collina=159909719320326222232483; JSESSIONID-L=a5268492-7d80-49ea-862a-d38b2d3d9a1a; accessToken=DKW39m4DcjflYHnU+Y0uGzXm1yfANYlO8wL3wOYOI+xkwbA/uwq5mdlNLI35h5AcSvfyfvNCkWpkTJ9e8xV8E8JdZ/JvzPdYSb5zoHWqT0iuQVQE8gfv7MxuEVVadTSsOiONcn84geRa5Od5iI/gt2WDQUKeZBtk6f+Qnk5W9y2BmAnOOYT5368R2rNzysYN; tmri_csfr_token=50565DCC1FEB42FCA8F936EDF6E9ABB7";   //登录后cookie
//        String host = "zj";       //cookie域名
//        String usbkey = "1";   //是否要usbkey 0 不要 1 要
//        String startdate = "20170101"; //开始时间
//        String enddate = "20200828";    //结束时间

        //List<String> tokenlist = Arrays.stream(Cookie.split(";")).filter(e->e.contains("JSESSIONID")||e.contains("accessToken")).collect(Collectors.toList());
        Map<String,String> params = Stream.of(Cookie.split(";")).filter(e->e.contains("JSESSIONID")||e.contains("accessToken")).map(str -> str.split("=")).collect(Collectors.toMap(s-> s[0].trim(),s->s[1].trim()));
        String JSESSIONID = params.get("JSESSIONID-L");
        String accessToken = params.get("accessToken");
        String acw_tc = null;


//        tokenlist.forEach(e->{
//            if(e.split("=")[0].equals(" JSESSIONID-L")){
//                JSESSIONID[0] = e.split("=")[1];
//            } if(e.split("=")[0].equals(" accessToken")){
//                accessToken[0] = e.split("=")[1];
//            }
//        });

        if(JudgeSystem().equals("linux")||JudgeSystem().equals("mac")){
           // csvpath = System.getProperty("user.dir")+"/违章查询报告.csv";
            csvpath_carNo = System.getProperty("user.dir")+"/车牌号.csv";
            csvpath_carNo2 = System.getProperty("user.dir")+"/已爬车牌号.csv";
            exportFilePath = System.getProperty("user.dir")+"/违章查询报告.xlsx";
        }else{
            //csvpath = System.getProperty("user.dir")+"\\违章查询报告.csv";
            csvpath_carNo = System.getProperty("user.dir")+"\\车牌号.xlsx";
            csvpath_carNo2 = System.getProperty("user.dir")+"\\已爬车牌号.csv";
            exportFilePath = System.getProperty("user.dir")+"\\违章查询报告.xlsx";

        }

//        String startdate ="20170101";
//        String enddate ="20200818";
        System.out.println(exportFilePath);
        Evcard_Ids_Assert evcard_ids_assert = new Evcard_Ids_Assert();
        evcard_ids_assert.asserttest(JSESSIONID,acw_tc, accessToken,startdate,enddate,csvpath_carNo,csvpath_carNo2,host,usbkey,exportFilePath);
    }

    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().contains("linux");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }

    public static String JudgeSystem() {
        if (isLinux()) {
            return "linux";
        } else if (isWindows()) {
            return "windows";
        } else {
            return "mac";
        }
    }

}
