package com.main;

import com.asserts.Evcard_Ids_Assert;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String args[]) throws Exception {
        String JSESSIONID = System.getProperty("JSESSIONID");
        String acw_tc = System.getProperty("acw_tc");
        String accessToken = System.getProperty("accessToken");
        String csvpath = System.getProperty("csvpath");
        String startdate = System.getProperty("startdate");
        String enddate = System.getProperty("enddate");

//        String JSESSIONID = "dad695a0-51c6-4e90-be1c-982ee55cf4a5";
//        String acw_tc = "";
//        //String jsluid_s = "";
//        String accessToken = "l0pobvfI2rkArU2WwdIc/N93NQAEZDGCo5CKTxbcbPmrbc1BOY/vA++a1u4n42+5k7hCenpA3YlRrJllp9I4vdcp+bRec8eWDMBRUOub00EYR69vyAhotQstcj1jiLMjE1901bbYBRnEopGuChiuvYo1EkxjiF+aPX1b5MTpmDhFbU7wlC1wy1bP7gOHIEwy";
//        String csvpath = "/Users/weijin/Downloads/IDS_APIAutomation_OLD/Evcard/test.csv";
//        String startdate ="20170101";
//        String enddate ="20200806";
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
