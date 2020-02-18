package com.sql;

import com.db.EvcardDataBase;

import java.util.Map;

/**
 * Created by jin wei on 2016/8/4.
 */
public class Ymmgetuserid {
    //执行具体的SQL
    public static String getuserid(String telephone){
        EvcardDataBase evcardDataBase = getYmmDataBase();
        Map userinfo= evcardDataBase.query(String.format("select user_id from users where telephone=%s", telephone));
        String userid=userinfo.get("user_id").toString();
        return userid;
    }

    //定义链接的数据库
    public static EvcardDataBase getYmmDataBase() {
        return new EvcardDataBase("logistics");
    }
}
