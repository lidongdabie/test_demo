package com.tools;

import java.util.UUID;

public class GetSignInfo {
    public static String getsign() throws Exception {
        String appkey="evcardapp";
        String secret="7f634bf3-6b25-4a8c-92ac-bd4a1e116660";
        String timestamp= String.valueOf(System.currentTimeMillis());
        String random= UUID.randomUUID().toString().substring(0, 6);
        StringBuilder sb=new StringBuilder();
        sb.append("appkey").append(appkey).append("secret").append(secret).append("timestamp").append(timestamp).append("random").append(random);
        String sign = MD5Utils.md5Encode(sb.toString()).toUpperCase();
        StringBuilder url =new StringBuilder();
        url.append("&appkey=").append(appkey).append("&timestamp=").append(timestamp).append("&random=").append(random).append("&sign=").append(sign);
        return url.toString();
    }
}
