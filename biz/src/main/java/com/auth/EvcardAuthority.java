package com.auth;

import com.core.BaseURL;

/**
 * Created by jin wei on 2016/6/12.
 */
public class EvcardAuthority extends BaseURL {
    private String baseUrl_evwork;
    private String baseUrl = "";

    public EvcardAuthority() {
        this.baseUrl = getBaseUrl();
        this.baseUrl_evwork = getBaseUrl_Evwork();
    }

    public String getBaseUrl() {
        if (this.env.equals("alpha")) {
            return EvcardUrlEnum.ALPHASHOPCENTER.url;
        } else if (this.env.equals("prod")) {
            return EvcardUrlEnum.PRODSHOPCENTER.url;
        } else {
            return EvcardUrlEnum.BETASHOPCENTER.url;
        }
    }

    public String getBaseUrl_Evwork() {
        if (this.env.equals("alpha")) {
            return EvcardUrlEnum.ALPHASHOPCENTER.url;
        } else if (this.env.equals("prod")) {
            return EvcardUrlEnum.PRODSHOPCENTER.url;
        } else {
            return EvcardUrlEnum.BETASHOPCENTER_EVWORK.url;
        }
    }
}
