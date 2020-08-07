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
//        String startdate = System.getProperty("startdate");
//        String enddate = System.getProperty("enddate");

        String JSESSIONID = "663a1bb5-2d2f-4ec1-bfb1-fb4640df6beb";
        String acw_tc = "7b39758315967853760115284e70370c838003c8571db6dae98fea1f1f1eec";
        //String jsluid_s = "";
        String accessToken = "0mU5DpkrJD7BlnAOpIm8MV2es0IrfKm+A2cRu7AQwb8Q+l5qVsCi6nBOPfMKVBpeZWWMtD3D6LmJnf863/0lrvZ3TD5I5yrJIo+kkZoLrCxkJlmMwmwSmKcY1ciyyQX63eITXXuZ/Q+03/ocgYqAB+/W7mwE11aMDl3NsOFZuslPa/WSpiEujs0avMiTagHC";
        String csvpath = "/Users/weijin/Downloads/IDS_APIAutomation_OLD/Evcard/test.csv";
        String startdate ="20170101";
        String enddate ="20200806";
        System.out.println(csvpath);
        Evcard_Ids_Assert evcard_ids_assert = new Evcard_Ids_Assert();
        evcard_ids_assert.asserttest(JSESSIONID,acw_tc,accessToken,csvpath,startdate,enddate);
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
