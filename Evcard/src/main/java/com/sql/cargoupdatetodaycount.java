package com.sql;

import com.db.EvcardDataBase;

/**
 * Created by jin wei on 2016/7/29.
 */
public class cargoupdatetodaycount {
    //执行具体的SQL
    public static int getInfo(String telephone){
        EvcardDataBase evcardDataBase = getYmmDataBase();
        String querysql=String.format("update accounts set  today_count = 0   where user_id = (select user_id from users where telephone = %s);",telephone);
        int result = evcardDataBase.execute(querysql);
        return result;
    }

    //定义链接的数据库
    public static EvcardDataBase getYmmDataBase() {
        return new EvcardDataBase("logistics");
    }
}
