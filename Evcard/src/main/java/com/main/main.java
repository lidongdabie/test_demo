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

        String JSESSIONID = "647f9da9-a461-4ac1-873e-d95cac2ff9a5";
        String acw_tc = "";
        String jsluid_s = "";
        String accessToken = "RtnUcWAv+tLOgJtiSDC8e6rAGqeygzjfCJgJdSweRQbFBsed4jpdtgWvJRVk13YoQ9s7kJEba/FzG947U7VqQ+AhXmQ5WOA538kcKF9jCpk+2WcC/zbx69s4v4sWZIBQnrvfqHqUDVgx0GoUwyPHtDN9CE2RjARaUXEPS5J8rskRRTDqmMixBDBonlA6jW69";
        String csvpath = "/Users/weijin/Downloads/IDS_APIAutomation_OLD/Evcard/test.csv";
//        String startdate ="20170101";
//        String enddate ="20200803";
//        System.out.println(csvpath);
        Evcard_Ids_Assert evcard_ids_assert = new Evcard_Ids_Assert();
        evcard_ids_assert.asserttest(JSESSIONID,acw_tc,accessToken,csvpath);
    }
}
