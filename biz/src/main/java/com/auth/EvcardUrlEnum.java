package com.auth;

/**
 * Created by jin wei on 2016/6/12.
 */
public enum EvcardUrlEnum {
    // Evcard 对应不同环境的URL
    ALPHASHOPCENTER(""), BETASHOPCENTER(
            "http://csms-st.evcard.vip:180/")
    ,BETASHOPCENTER_EVWORK(
            "http://csms-app-st.evcard.vip:180/"), PRODSHOPCENTER("");
            //"http://192.168.1.116:8080/"), PRODSHOPCENTER("");
            //"http://139.224.37.24:8080/"), PRODSHOPCENTER("");

    //测试环境 http://139.224.37.24:8080/
    //开发环境 192.168.1.117   "http://192.168.1.116:8080/"
    public final String url;

    EvcardUrlEnum(String url) {
        this.url = url;
    }
}
