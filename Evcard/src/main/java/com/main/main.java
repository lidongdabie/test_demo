package com.main;

import com.asserts.Evcard_Ids_Assert;

import java.io.IOException;

public class main {
    public static void main(String args[]) throws Exception {
//        String JSESSIONID = System.getProperty("JSESSIONID");
//        String acw_tc = System.getProperty("acw_tc");
//        String accessToken = System.getProperty("accessToken");
//        String csvpath = System.getProperty("csvpath");
//        String startdate = System.getProperty("startdate");
//        String enddate = System.getProperty("enddate");

        String JSESSIONID = "177f7f07-75a1-4969-b389-6fb0b772bed2";
        String acw_tc = "";
        String jsluid_s = "";
        String accessToken = "Uv2CdDwO+6qTwW/fO4SNv/jl8CojXnNYgc4RSzkSeTdqvjI/WNrLoPBngpSG7bCeYCCwVhXV4yE9Um2au1D62bexGNXq7GQPO8njZlkxBsZgKV2AiGwkTzn/jJ5v0RuatMHuJ+UQHFLz3jGrqB4zP19nmxaDKX7hoQzT7WKYzN9limPCKO4XngmgCNE+bNbw";
        String csvpath = "/Users/weijin/Downloads/IDS_APIAutomation_OLD/Evcard/test.csv";
        String startdate ="20170101";
        String enddate ="20200803";
//        System.out.println(csvpath);
        Evcard_Ids_Assert evcard_ids_assert = new Evcard_Ids_Assert();
        evcard_ids_assert.asserttest(JSESSIONID,acw_tc,accessToken,csvpath,startdate,enddate);
    }
}
