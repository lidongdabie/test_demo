package com.sql;

import com.db.EvcardDataBase;

import java.util.Map;

public class SetReviewstatus {
    public static void setreviewstatus(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("update membership_info set REVIEW_STATUS=2 where mobile_phone=15800477857");
        siacDataBase.execute(querysql1);
    }

    public static void resetreviewstatus(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("update membership_info set REVIEW_STATUS=1 where mobile_phone=15800477857");
        siacDataBase.execute(querysql1);
    }

    public static void authenticationstatus(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("update membership_info set authentication_status=1 where mobile_phone=15800477857");
        siacDataBase.execute(querysql1);
    }

    public static void resetlicenseexpiratiomtime(String datatime){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("update membership_info set LICENSE_EXPIRATION_TIME='%s' where auth_id='15800477857'",datatime);
        siacDataBase.execute(querysql1);
    }

    public static void ModifyMemberinfoExemptDeposit(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("update MEMBERSHIP_INFO set EXEMPT_DEPOSIT='1' where auth_id='15800477857'");
        siacDataBase.execute(querysql1);
    }

    public static void ModifyMemberinfoExemptDeposit2(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("update MEMBERSHIP_INFO set EXEMPT_DEPOSIT='0' where auth_id='15800477857'");
        siacDataBase.execute(querysql1);
    }

    public static void ModifyAgencyInfo(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("update agency_info set EXEMPT_DEPOSIT=2 where AGENCY_ID='00'");
        siacDataBase.execute(querysql1);
    }

    public static void ModifyAgencyInfo2(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("update agency_info set EXEMPT_DEPOSIT=0 where AGENCY_ID='00'");
        siacDataBase.execute(querysql1);
    }

    public static void ModyfyAmountChargeHistory(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("UPDATE `siac`.`amount_charge_history` SET `TRADE_PLAT`='浦发' WHERE  `OUT_TRADE_SEQ`='0517af7e6dbd41fe9e4';");
        siacDataBase.execute(querysql1);
    }

    public static void ModyfyAmountChargeHistory2(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        EvcardDataBase isvDataBase = getisvDataBase();
        String querysql1=String.format("UPDATE `siac`.`amount_charge_history` SET `TRADE_PLAT`='银联' WHERE  `OUT_TRADE_SEQ`='0517af7e6dbd41fe9e4';");
        siacDataBase.execute(querysql1);
    }

    public static void Modifybdpriskorder(){
        EvcardDataBase issDataBase= getissDataBase();
        String querysql1=String.format("UPDATE `iss`.`bdp_risk_order` SET `risk_order_status`='1' WHERE  `auth_id`='15800477857';");
        issDataBase.execute(querysql1);
    }

    public static void Modifybdpriskorder2(){
        EvcardDataBase issDataBase= getissDataBase();
        String querysql1=String.format("UPDATE `iss`.`bdp_risk_order` SET `risk_order_status`='0' WHERE  `auth_id`='15800477857';");
        issDataBase.execute(querysql1);
    }

    public static void modifyorderinfo(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("UPDATE `siac`.`order_info` SET `PAYMENT_STATUS`='0' WHERE  `ORDER_SEQ`='C2018120418440000010';");
        siacDataBase.execute(querysql1);
    }

    public static void modifyorderinfo2(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("UPDATE `siac`.`order_info` SET `PAYMENT_STATUS`='5' WHERE  `ORDER_SEQ`='C2018120418440000010';");
        siacDataBase.execute(querysql1);
    }

    public static void clearcardno(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("update membership_info set card_no='' where mobile_phone=15800477857");
        siacDataBase.execute(querysql1);
    }

    public static void clearusercouponlist(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("delete from user_coupon_list where COUPON_ORIGIN = '新手礼包' and auth_id=15800477857");
        siacDataBase.execute(querysql1);
    }

    public static void modifydrivercode(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("update membership_info set driver_code='32108119880813781X' where pk_id=101");
        siacDataBase.execute(querysql1);
    }

    public static void modifydrivercode2(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("update membership_info set driver_code=123123213213 where pk_id=101");
        siacDataBase.execute(querysql1);
    }

    public static void modifyauthstatus(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("update membership_info set authentication_status=0 where MOBILE_PHONE=15800477857");
        siacDataBase.execute(querysql1);
    }

    public static void modifyauthstatus2(){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("update membership_info set authentication_status=2 where MOBILE_PHONE=15800477857");
        siacDataBase.execute(querysql1);
    }

    public static Map getuauthid(String telephone){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("select auth_id from membership_info where mobile_phone=%s",telephone);
        Map result= siacDataBase.query(querysql1);
        return result;
    }

    //定义链接的数据库
    public static EvcardDataBase getsiacDataBase() {
        return new EvcardDataBase("siac");
    }

    public static EvcardDataBase getisvDataBase() {
        return new EvcardDataBase("isv");
    }

    public static EvcardDataBase getissDataBase() {
        return new EvcardDataBase("iss");
    }

    }

