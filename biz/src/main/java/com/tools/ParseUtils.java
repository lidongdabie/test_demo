package com.tools;

//import com.dianping.combiz.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LTT on 16/1/12.
 */
public class ParseUtils {
    private static final Logger logger = Logger.getLogger(ParseUtils.class);

//    public static List<Integer> jsonToIntegers(String json) {
//        List<Integer> integers = new ArrayList<Integer>();
//        if (StringUtils.isEmpty(json)) {
//            return integers;
//        }
//
//        try {
//            List list = JsonUtils.fromStr(json, List.class);
//            for (Object obj : list) {
//                int integer = (Integer) obj;
//                integers.add(integer);
//            }
//        } catch (IOException e) {
//            logger.error("Cast json to integer error", e);
//        }
//        return integers;
//    }

    public static List<Integer> stringToIntegers(String string) {
        List<Integer> integers = new ArrayList<Integer>();
        if (StringUtils.isEmpty(string)) {
            return integers;
        }

        try {
            String[] array = string.split(",");
            for (String s : array) {
                integers.add(Integer.parseInt(s.trim()));
            }
        } catch (Exception e) {
            logger.error("Parse integer list error, string " + string, e);
            return integers;
        }

        return integers;
    }

    public static List<String> stringToList(String string) {
        List<String> stringList = new ArrayList<String>();
        if (StringUtils.isEmpty(string)) {
            return stringList;
        }
        try {
            String[] array = string.split(",");
            for (String s : array) {
                stringList.add(s.trim());
            }
        } catch (Exception e) {
            logger.error("Parse integer list error, string " + string, e);
            return stringList;
        }
        return stringList;
    }

    public static String numberToString(long data) {
        String string;
        if (data > 99999) {
            double quotient = (double) data / 10000;
            string = formatDouble(quotient, 2) + "w";
        } else {
            DecimalFormat df = new DecimalFormat(",###,###");
            string = df.format(data);
        }
        return string;
    }

    public static String numberToString(double data) {
        String string;
        if (data > 100000) {
            double quotient = (double) data / 10000;
            string = formatDouble(quotient, 2) + "w";
        } else {
            DecimalFormat df = new DecimalFormat(",###,###.00");
            df.setRoundingMode(RoundingMode.FLOOR);
            string = df.format(data);
        }

        return string;
    }

    /**
     * 保留n位小数 去尾
     * @param data
     * @return
     */
    public static String formatDouble(double data, int digits) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(digits);

        nf.setRoundingMode(RoundingMode.DOWN);
        return nf.format(data);
    }

    public static double doubleFormat(double data, int digits) {
        BigDecimal bg = new BigDecimal(data);
        return bg.setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String decimalFormat(double number){
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String m = df.format(number);
        return m;
    }

    public static String integerFormat(int number){
        DecimalFormat df = new DecimalFormat("#,###,###");
        String m = df.format(number);
        return m;
    }
}

