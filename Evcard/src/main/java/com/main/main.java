package com.main;

import com.asserts.Evcard_Ids_Assert;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String args[]) throws Exception {
//        String JSESSIONID = System.getProperty("JSESSIONID");
//        String acw_tc = System.getProperty("acw_tc");
//        String accessToken = System.getProperty("accessToken");
//        String csvpath = System.getProperty("csvpath");
//        String csvpath_carNo = System.getProperty("csvpath_carNo");
//        String startdate = System.getProperty("startdate");
//        String enddate = System.getProperty("enddate");








        String JSESSIONID = "d3201537-04cd-4b94-af13-8b83117dbb0b";
        String acw_tc = "";
        //String jsluid_s = "";
        String accessToken = "R1a6/UGytzXaY8MT2qhEwdup+ulnTuO0wfUNozrtWzOy+ZB0ekE2ojPatqCoNAcXZzxQ9ATx809iqulV7e/mJx/vl+6VDwJ5GFRNR54nGyJFmtlUrosgJZlmfufuJOBwZ12vuovXjJHUVztL7qHlu0V8B6nld0KhFN4C3iiAYUy2f4LKJGh9c8cZOusnWFRL";
        String csvpath = "/Users/weijin/Downloads/IDS_APIAutomation_OLD/Evcard/test.csv";
        String csvpath_carNo = "/Users/weijin/Downloads/IDS_APIAutomation_OLD/Evcard/test2.csv";
        String csvpath_carNo2 = "/Users/weijin/Downloads/IDS_APIAutomation_OLD/Evcard/test3.csv";
        String startdate ="20170101";
        String enddate ="20200818";
        System.out.println(csvpath);
        Evcard_Ids_Assert evcard_ids_assert = new Evcard_Ids_Assert();
        evcard_ids_assert.asserttest(JSESSIONID,acw_tc,accessToken,csvpath,startdate,enddate,csvpath_carNo,csvpath_carNo2);
//
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//
//        for(int i=0;i<10;i++){
//            int finalI = i;
//            Runnable task = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread()+"当前值："+finalI);
//                }
//            };
//            executor.submit(task);
//        }
//        executor.shutdown();
//        while (true){
//            if(executor.isTerminated()){
//                System.out.println("所有子线程结束!");
//                break;
//            }
//        }



    }
}
