package com.codearms.maoqiqi.one;

import java.util.regex.Pattern;

public class AmountUtils {

    /**
     * 从字符串中提取数字US$119.99
     */
    public static float getNumberFromString(String str) {
        float s = 0;
        try {
            String regEx = "[^0-9.]";
            String result = Pattern.compile(regEx).matcher(str).replaceAll("");
            int i = result.lastIndexOf(".");
            if (i != -1) {
                String s1 = result.substring(0, i).replaceAll("[.]", "");
                String s2 = result.substring(i + 1);
                result = s1 + "." + s2;
            }
            s = Float.parseFloat(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 从字符串中提取去掉数字的字符(US$)US$119.99
     */
    public String getRemoveNumberString(String str) {
        String s = "";
        try {
            s = str.replaceAll("([1-9]+[0-9]*|0)(\\.[\\d]+)?", "");
            s = s.replace(",", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
