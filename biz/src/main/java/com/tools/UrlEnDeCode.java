package com.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by LTT on 16/1/11.
 */
public class UrlEnDeCode {

    public String urlEncode(String Source) throws UnsupportedEncodingException {
        String result= URLEncoder.encode(Source, "UTF-8");
        return  result;
    }
}
