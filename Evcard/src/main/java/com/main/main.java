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

    public static void main(String args[]) throws Exception {
//        String JSESSIONID = System.getProperty("JSESSIONID");
//        String acw_tc = System.getProperty("acw_tc");
//        String accessToken = System.getProperty("accessToken");
//        String csvpath = System.getProperty("csvpath");
//        String csvpath_carNo = System.getProperty("csvpath_carNo");
//        String startdate = System.getProperty("startdate");
//        String enddate = System.getProperty("enddate");
        //入参
//        String Cookie = System.getProperty("cookie");   //登录后cookie
//        String host = System.getProperty("host");       //cookie域名
//        String usbkey = System.getProperty("usbkey");   //是否要usbkey
//        String startdate = System.getProperty("startdate"); //开始时间
//        String enddate = System.getProperty("enddate");    //结束时间
        String Cookie = "_uab_collina=159781708680846136870407; JSESSIONID-L=148a3ceb-eaa5-4e22-b641-bbe3eff61b5a; accessToken=svDBA6R1UsXsMEFLDe4gOB1QDCoeqnMFPyky8p2zZfDPmNeHVnatL8SR5l6KhI3y0ot5AZB1PJiwTFxOP7NT1RDmpe7K633K2o3ck4vF1TGsnwtuDmMOOCuJnwo7Rk8Nd+v9ViXF/GbjpctB/oS69+TBSU9A49HNUjRH81FyVuFMVZt9lTwW+6vSZ0ktSrxi; tmri_csfr_token=DA3EE0910E976C56ECE18947207C54F2; acw_tc=781bad2315985806942461894e33249feb711b57d3133ba309e5f005e0aa63";   //登录后cookie
        String host = "hb";       //cookie域名
        String usbkey = "0";   //是否要usbkey 0 不要 1 要
        String startdate = "20170101"; //开始时间
        String enddate = "20200828";    //结束时间


        final String[] JSESSIONID = {null};
        String acw_tc = null;
        final String[] accessToken = {null};
        List<String> a = Arrays.stream(Cookie.split(";")).filter(e->e.contains("JSESSIONID")||e.contains("accessToken")).collect(Collectors.toList());
        a.forEach(e->{
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
