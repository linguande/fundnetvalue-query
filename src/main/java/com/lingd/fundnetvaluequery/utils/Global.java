package com.lingd.fundnetvaluequery.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: linguande
 * @Date: 2018/4/26 18:24
 * @Description: 全局配置
 */
public class Global {

    private static String[] fundCodeList = new String[]{"161725", "161726", "001268", "001266", "161724", "161030"};

    private static String url = "http://fundgz.1234567.com.cn/js/";

    public static List<String> getFundUrl() {
        List<String> list = new ArrayList<String>();
        if (fundCodeList != null && fundCodeList.length > 0) {
            for (int i = 0, length = fundCodeList.length; i < length; i++) {
                list.add(url + fundCodeList[i] + ".js");
            }
        }
        return list;
    }

}
