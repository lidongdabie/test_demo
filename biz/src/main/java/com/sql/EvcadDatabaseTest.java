package com.sql;

import com.db.EvcardDataBase;

import java.util.List;
import java.util.Map;

/**
 * Created by mia on 2017/5/26.
 */
public class EvcadDatabaseTest {
    //执行具体的SQL
    public static List<Map<String, Object>> getInfo(){
        EvcardDataBase evcardDataBase = getEvacardDataBase();
        List<Map<String, Object>> queryList = evcardDataBase.queryList("select * from xieenze;");
        return  queryList;
    }

    //定义链接的数据库 test
    public static EvcardDataBase getEvacardDataBase() {
        return new EvcardDataBase("test");
    }
}
