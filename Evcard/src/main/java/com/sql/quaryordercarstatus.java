package com.sql;

import com.db.EvcardDataBase;

import java.util.Map;
import java.util.UUID;

/**
 * Created by mia on 2017/7/21.
 */
public class quaryordercarstatus {
    //执行具体的SQL
    public static String quarystatus(String order_seq){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("select payment_status from ORDER_INFO WHERE order_seq = '%s'",order_seq);
        Map<String, Object>  status= siacDataBase.query(querysql1);
        return status.get("payment_status").toString();
    }

    //查询本次消费的金额
    public static String quaryamount(String order_seq){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String querysql1=String.format("select amount from ORDER_INFO WHERE order_seq = '%s' ",order_seq);
        Map<String, Object>  amount= siacDataBase.query(querysql1);
        String querysql2=String.format("select insurance from order_price_detail WHERE order_seq = '%s'",order_seq);
        Map<String, Object>  insurance= siacDataBase.query(querysql2);
        double money1=Double.parseDouble(amount.get("amount").toString());
        double money2=Double.parseDouble(insurance.get("insurance").toString());
        double money=money1+money2;
        String Money=Double.toString(money);
        return Money;
    }

    //查询车辆当前所在网点
    public static String quaryshopseq(String vin){
        EvcardDataBase isvDataBase=getisvDataBase();
        String sql=String.format("SELECT SHOP_SEQ FROM `vehicle_info` where vin = '%s';",vin);
        Map<String, Object>  shopseq= isvDataBase.query(sql);
        return shopseq.get("SHOP_SEQ").toString();
    }

    //充押金
    public static void chargeAccount(String telephone){
        EvcardDataBase siacDataBase = getsiacDataBase();
        String sql=String.format("select auth_id from membership_info  where mobile_phone=%s",telephone);
        Map<String, Object>  amount= siacDataBase.query(sql);
        String sql2=String.format("UPDATE siac.membership_info SET DEPOSIT = DEPOSIT +1000 WHERE AUTH_ID =%s",amount.get("auth_id"));
        siacDataBase.execute(sql2);
        String sql3=String.format("INSERT INTO `siac`.`amount_charge_history` (\n" +
                "  `OUT_TRADE_SEQ`,\n" +
                "  `AUTH_ID`,\n" +
                "  `MEMBERSHIP_TYPE`,\n" +
                "  `PAY_TRADE_NO`,\n" +
                "  `TRADE_PLAT`,\n" +
                "  `TRADE_STATUS`,\n" +
                "  `SELLER_ID`,\n" +
                "  `SELLER_EMAIL`,\n" +
                "  `BUYER_EMAIL`,\n" +
                "  `BUY_ID`,\n" +
                "  `PAY_TYPE`,\n" +
                "  `TOTAL_FREE`,\n" +
                "  `RETURN_STATUS`,\n" +
                "  `RETURN_MONEY`,\n" +
                "  `PLAN_RETURN_MONEY`,\n" +
                "  `BODY`,\n" +
                "  `ORDER_SEQ`,\n" +
                "  `GMT_CREATE`,\n" +
                "  `GMT_PAYMENT`,\n" +
                "  `THAW_TIME`,\n" +
                "  `RETURN_AGREE_TIME`,\n" +
                "  `RETURN_TIME`,\n" +
                "  `EXP_DATE`,\n" +
                "  `RENT_MINS`,\n" +
                "  `REMARK`,\n" +
                "  `CREATED_TIME`,\n" +
                "  `CREATED_USER`,\n" +
                "  `UPDATED_TIME`,\n" +
                "  `UPDATED_USER`,\n" +
                "  `UNIONPAY_FLAG`,\n" +
                "  `DEDUCT_MONEY`,\n" +
                "  `IF_INVOICED`,\n" +
                "  `INVOICE_SEQ`,\n" +
                "  `INVOICE_COUNT`\n" +
                ")\n" +
                "VALUES\n" +
                "  (\n" +
                "    \"%s\",\n" +
                "    %s,\n" +
                "    '0',\n" +
                "    %s,\n" +
                "    '银联',\n" +
                "    '1',\n" +
                "    '105290075110414',\n" +
                "    NULL,\n" +
                "    NULL,\n" +
                "    NULL,\n" +
                "    '2',\n" +
                "    '1000.00',\n" +
                "    '0',\n" +
                "    '0.00',\n" +
                "    '0.00',\n" +
                "    '押金支付',\n" +
                "    '',\n" +
                "    '2017-07-02 15:06:40',\n" +
                "    '2017-07-02 15:06:40',\n" +
                "    NULL,\n" +
                "    NULL,\n" +
                "    NULL,\n" +
                "    '',\n" +
                "    '0.00',\n" +
                "    NULL,\n" +
                "    '20170702150640263',\n" +
                "    'app',\n" +
                "    '20170702150656000',\n" +
                "    '银联异步通知',\n" +
                "    '1',\n" +
                "    '0.00',\n" +
                "    '0',\n" +
                "    NULL,\n" +
                "    NULL\n" +
                "  );", UUID.randomUUID().toString().replaceAll("-", ""),amount.get("auth_id"),(int)(Math.random()*100));
        siacDataBase.execute(sql3);
    }

    /* 清除普通押金 */
    public static void cleanDeposit(String telephone) {
        EvcardDataBase siacDataBase = getsiacDataBase();
        String sql = String.format("select auth_id from membership_info  where mobile_phone=%s", telephone);
        Map<String, Object> amount = siacDataBase.query(sql);
        String sql2 = String.format("UPDATE siac.membership_info SET DEPOSIT = 0 WHERE AUTH_ID ='%s'", amount.get("auth_id"));
        siacDataBase.execute(sql2);
        String sql3 = String.format("delete from amount_charge_history where auth_id='%s'", amount.get("auth_id"));
        siacDataBase.execute(sql3);
    }

    /* 充i3押金 */
    public static void chargeVehicleDeposit(String telephone) {
        EvcardDataBase siacDataBase = getsiacDataBase();
        String sql = String.format("select auth_id from membership_info  where mobile_phone=%s", telephone);
        Map<String, Object> amount = siacDataBase.query(sql);
        String sql2 = String.format("UPDATE siac.membership_info SET DEPOSIT_VEHICLE = 3000 WHERE AUTH_ID ='%s'", amount.get("auth_id"));
        siacDataBase.execute(sql2);
        String sql3 = String.format("INSERT INTO `siac`.`amount_charge_history` (\n" +
                "  `OUT_TRADE_SEQ`,\n" +
                "  `AUTH_ID`,\n" +
                "  `MEMBERSHIP_TYPE`,\n" +
                "  `PAY_TRADE_NO`,\n" +
                "  `TRADE_PLAT`,\n" +
                "  `TRADE_STATUS`,\n" +
                "  `SELLER_ID`,\n" +
                "  `SELLER_EMAIL`,\n" +
                "  `BUYER_EMAIL`,\n" +
                "  `BUY_ID`,\n" +
                "  `PAY_TYPE`,\n" +
                "  `TOTAL_FREE`,\n" +
                "  `RETURN_STATUS`,\n" +
                "  `RETURN_MONEY`,\n" +
                "  `PLAN_RETURN_MONEY`,\n" +
                "  `BODY`,\n" +
                "  `ORDER_SEQ`,\n" +
                "  `GMT_CREATE`,\n" +
                "  `GMT_PAYMENT`,\n" +
                "  `THAW_TIME`,\n" +
                "  `RETURN_AGREE_TIME`,\n" +
                "  `RETURN_TIME`,\n" +
                "  `EXP_DATE`,\n" +
                "  `RENT_MINS`,\n" +
                "  `REMARK`,\n" +
                "  `CREATED_TIME`,\n" +
                "  `CREATED_USER`,\n" +
                "  `UPDATED_TIME`,\n" +
                "  `UPDATED_USER`,\n" +
                "  `UNIONPAY_FLAG`,\n" +
                "  `DEDUCT_MONEY`,\n" +
                "  `IF_INVOICED`,\n" +
                "  `INVOICE_SEQ`,\n" +
                "  `INVOICE_COUNT`\n" +
                ")\n" +
                "VALUES\n" +
                "  (\n" +
                "    \"%s\",\n" +
                "    '%s',\n" +
                "    '0',\n" +
                "    '%s',\n" +
                "    '银联',\n" +
                "    '1',\n" +
                "    '105290075110414',\n" +
                "    NULL,\n" +
                "    NULL,\n" +
                "    NULL,\n" +
                "    '18',\n" +
                "    '3000.00',\n" +
                "    '0',\n" +
                "    '0.00',\n" +
                "    '0.00',\n" +
                "    '押金支付',\n" +
                "    '',\n" +
                "    '2017-07-02 15:06:40',\n" +
                "    '2017-07-02 15:06:40',\n" +
                "    NULL,\n" +
                "    NULL,\n" +
                "    NULL,\n" +
                "    '',\n" +
                "    '0.00',\n" +
                "    NULL,\n" +
                "    '20170702150640263',\n" +
                "    'app',\n" +
                "    '20170702150656000',\n" +
                "    '银联异步通知',\n" +
                "    '1',\n" +
                "    '0.00',\n" +
                "    '0',\n" +
                "    NULL,\n" +
                "    NULL\n" +
                "  );", UUID.randomUUID().toString().replaceAll("-", ""), amount.get("auth_id"), (int) (Math.random() * 100));
        String sql4 = String.format("SELECT ifnull(sum(TOTAL_FREE-DEDUCT_MONEY-RETURN_MONEY),0) as totalDeposit from siac.AMOUNT_CHARGE_HISTORY where AUTH_ID = '%s' and MEMBERSHIP_TYPE = 0 and PAY_TYPE = 18 and RETURN_STATUS = 0", amount.get("auth_id"));
        String deposit;
        do {
            siacDataBase.execute(sql3);
            deposit = siacDataBase.query(sql4).get("totalDeposit").toString().trim();
            System.out.println(">>> Essential deposit: " + deposit);
        } while (!deposit.equals("3000.00"));
    }


    //定义链接的数据库
    public static EvcardDataBase getsiacDataBase() {
        return new EvcardDataBase("siac");
    }

    public static EvcardDataBase getisvDataBase() {
        return new EvcardDataBase("isv");
    }
}
