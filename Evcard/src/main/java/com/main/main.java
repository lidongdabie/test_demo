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

        String JSESSIONID = "1112d37e-24cc-4dea-8c28-725da7d9e186";
        String acw_tc = "";
        //String jsluid_s = "";
        String accessToken = "oiGrSlL+niB0xYHRs+MIFR05tUhW8XcBeu84gIqfAIIW6xfe9Aa8C3UZzNumVqqC4H8ctKed+Eb1WQQE8i994wpkTeztvqEyzpflOtS4FaSoQDhRWvhSZIvAUAa2FX2DyTp9xR3bF+hzf5Zv9ZDR3Fm3VvEh3nQvMPANh+lr6zrMKkno7yOUS73jnIyCSImn";
        String csvpath = "/Users/weijin/Downloads/IDS_APIAutomation_OLD/Evcard/test.csv";
        String startdate ="20170101";
        String enddate ="20200818";
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
