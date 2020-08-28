package com.main;

import com.asserts.Evcard_Ids_Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    static String csvpath = null;
    static String csvpath_carNo =null;
    public static String csvpath_carNo2 =null;
    //入参
    public static String business = System.getProperty("business");  //是否有运营车辆 0 无  1 有
    public static String download = System.getProperty("download") ; //是否需要断点续传 0 不需要 1 需要
    public static String Cookie = System.getProperty("cookie");   //登录后cookie
    public static String host = System.getProperty("host");       //cookie域名
    public static String usbkey = System.getProperty("usbkey");   //是否要usbkey
    public static String startdate = System.getProperty("startdate"); //开始时间
    public static String enddate = System.getProperty("enddate");    //结束时间

    public static void main(String args[]) throws Exception {


//        String Cookie = "_uab_collina=159773312934539260434706; JSESSIONID-L=589123d5-4af3-494a-8516-4100e55281a1; accessToken=Kba1CyzroKBK5tEAaVCTInF8Vf3TEnGJNQywf5oY8piL9NVWGYpd0hnIETKROcbOBN6G3SiVxCf84xNPYodVyOdyXAMFpXYvViI6FC9i8UE1piLADtRwc+uNp0+WbSyPlQuAHMsgSIOfWCsZP8aQKnsj2gMNR3j/UE11wLDr+2gWcFUrzRxLJWWmI0kjYaPQ; tmri_csfr_token=BC9FD4068A9F123172747A7D48B22B68";   //登录后cookie
//        String host = "sd";       //cookie域名
//        String usbkey = "0";   //是否要usbkey 0 不要 1 要
//        String startdate = "20170101"; //开始时间
//        String enddate = "20200828";    //结束时间

        final String[] JSESSIONID = {null};
        String acw_tc = null;
        final String[] accessToken = {null};
        List<String> tokenlist = Arrays.stream(Cookie.split(";")).filter(e->e.contains("JSESSIONID")||e.contains("accessToken")).collect(Collectors.toList());
        tokenlist.forEach(e->{
            if(e.split("=")[0].equals(" JSESSIONID-L")){
                JSESSIONID[0] = e.split("=")[1];
            } if(e.split("=")[0].equals(" accessToken")){
                accessToken[0] = e.split("=")[1];
            }
        });



        if(JudgeSystem().equals("linux")||JudgeSystem().equals("mac")){
            csvpath = System.getProperty("user.dir")+"/违章查询报告.csv";
            csvpath_carNo = System.getProperty("user.dir")+"/车牌号.csv";
            csvpath_carNo2 = System.getProperty("user.dir")+"/已爬车牌号.csv";
        }else{
            csvpath = System.getProperty("user.dir")+"\\违章查询报告.csv";
            csvpath_carNo = System.getProperty("user.dir")+"\\车牌号.csv";
            csvpath_carNo2 = System.getProperty("user.dir")+"\\已爬车牌号.csv";
        }

//        String startdate ="20170101";
//        String enddate ="20200818";
        System.out.println(csvpath);
        Evcard_Ids_Assert evcard_ids_assert = new Evcard_Ids_Assert();
        evcard_ids_assert.asserttest(JSESSIONID[0],acw_tc, accessToken[0],csvpath,startdate,enddate,csvpath_carNo,csvpath_carNo2,host,usbkey);
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
