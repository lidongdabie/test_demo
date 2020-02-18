package com.sql;

import com.db.EvcardDataBase;

/**
 * Created by jin wei on 2016/7/29.
 */
public class ResetCarInfo {
    //执行具体的SQL
    public static void resetInfo(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("update ORDER_INFO set PAYMENT_STATUS=0 WHERE vin = 'LVVDC671289624' and PAYMENT_STATUS >=1 and PAYMENT_STATUS <=4");
        String querysql2=String.format("update isv.VEHICLE_INFO set service_status=0 WHERE SYS_TERM_ID = '30155'");
        String qiiearsql3=String.format("UPDATE SIAC.ORDER_INFO SET PAYMENT_STATUS=0 WHERE vin = 'LVVDC671289624'");
        String querysql4=String.format("delete from membership_info where mobile_phone=11122255500");
        siacDataBase.execute(querysql1);
        isvDataBase.execute(querysql2);
        siacDataBase.execute(qiiearsql3);
        siacDataBase.execute(querysql4);
    }

    //定义链接的数据库
    public static EvcardDataBase getsiacDataBase() {
        return new EvcardDataBase("siac");
    }

    public static EvcardDataBase getisvDataBase() {
        return new EvcardDataBase("isv");
    }
}
