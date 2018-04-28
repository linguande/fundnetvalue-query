package com.lingd.fundnetvaluequery;

import com.alibaba.fastjson.JSONObject;
import com.lingd.fundnetvaluequery.utils.HttpUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {
    public static void main(String[] args) {
        String url = "http://fundgz.1234567.com.cn/js/001186.js";
        String result = HttpUtils.sendGet(url);
        Pattern pattern = Pattern.compile("(?<=jsonpgz\\()[^\\)]+");
        Matcher matcher = pattern.matcher(result);
        if(matcher.find()){
            System.out.println(matcher.group());
            JSONObject jsonObject = (JSONObject) JSONObject.parse(matcher.group());
            System.out.println(jsonObject.get("name"));
        }
    }
}
