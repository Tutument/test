package com.example.test.tomcat.timeout;

import com.alibaba.fastjson.JSONObject;

public class Test {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        String json = RestTemplateUtil.sendPostJSON(jsonObject, "http://localhost:8083/test01");
        System.out.println(json);
    }
}
