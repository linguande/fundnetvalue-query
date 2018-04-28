package com.lingd.fundnetvaluequery.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Auther: linguande
 * @Date: 2018/4/27 8:59
 * @Description: 正则表达式
 */
public class RegularUtils {

    public static String getFundResult(String string) {
        Pattern pattern = Pattern.compile("(?<=jsonpgz\\()[^\\)]+");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}
