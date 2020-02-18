package com.auth;

/**
 * Created by jin wei on 2016/7/27.
 */
public class Authorization {
    public static String auth = null;

    public Authorization(){
        super();
    }

    public Authorization(String auth){
        super();
        this.auth=auth;
    }

    public String getAuth(){
        return auth;
    }
    public void setAuth(String auth){
        this.auth=auth;
    }
}
