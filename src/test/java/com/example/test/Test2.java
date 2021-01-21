package com.example.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        //test02();
        //test03();
        test05();
    }

    public static void test01(){
        String a = "a";
        String b = "b";
        String intern = a.intern();
        String c = "b";

        String b2 = new String("b");
        System.out.println(b.equals(b2));
        System.out.println(b2.hashCode());

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(intern.hashCode());
        System.out.println(c.hashCode());
    }

    public static void test02(){

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
    }

    public static void test03(){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMdd:HHmmss");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after = now.plusMinutes(Long.valueOf(5));
        String dateStr = now.format(pattern) + after.format(pattern);
        String dateStr2 =  pattern.format(now) + pattern.format(after);
        System.out.println(dateStr);
        System.out.println(dateStr2);
    }

    public static void test04(){

        List<? extends Number> list = new ArrayList<>();
        //list.add(new Integer(1));

        List<? super String > list2 = new ArrayList<>();
        list2.add(new String("1"));

        List<? super ArrayList> list3 = new ArrayList<>();
        List a = new AbstractList() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public Object get(int index) {
                return null;
            }
        };
        //list3.add(a);

    }

    public static void test05(){

        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("aj","a");
        jsonObject.put("cj","c");
        jsonObject.put("bj","b");

        jsonObject.put("fj","f");
        jsonObject.put("dj","d");
        jsonObject.put("zj","z");
        jsonObject.put("zf","z");
        jsonObject.forEach((k, v)->{

            System.out.println(k + ":" + v);
        });

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        map.put("aj","a");
        map.put("cj","c");
        map.put("bj","b");

        map.put("fj","f");
        map.put("dj","d");
        map.put("zj","z");
        map.put("zf","z");
        map.forEach((k, v)->{

            //System.out.println(k + ":" + v);
        });

        ArrayList<String> strings = new ArrayList<>();
        //strings.stream()

        //MultiValueMap<K, V> multiValueMap = CollectionUtils.toMultiValueMap(map);
        //JSONObject jsonObject1 = new JSONObject();


    }
}
