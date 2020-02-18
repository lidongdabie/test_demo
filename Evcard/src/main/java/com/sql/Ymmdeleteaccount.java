package com.sql;

import com.db.EvcardDataBase;

/**
 * Created by jin wei on 2016/7/27.
 */
public class Ymmdeleteaccount {
    //执行具体的SQL
    public static void getInfo(String telephone){
        EvcardDataBase evcardDataBase = getYmmDataBase();
        evcardDataBase.execute(String.format("delete from profiles where user_id=(select user_id from users where telephone=%s)",telephone));
        evcardDataBase.execute(String.format("delete from users where telephone=%s",telephone));
    }

    //定义链接的数据库
    public static EvcardDataBase getYmmDataBase() {
        return new EvcardDataBase("logistics");
    }
}
