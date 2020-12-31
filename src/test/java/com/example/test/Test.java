package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.example.test.jvm.TestClass;

import java.lang.reflect.Method;

public class Test {


    public static void main(String[] args) {
        /*Test test = new Test();
        int inc = test.inc();
        System.out.println(inc);
        TestClass testClass = new TestClass();*/
        String s = "123";
        String s1 = new String("123");
        str(s);
        str(s1);
        str(s1.intern());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1","123");
        jsonObject.put("2",new String("123"));
        String string = jsonObject.getString("1");
        String string2= jsonObject.getString("2");
        str(string);
        str(string2);

        System.out.println(System.getProperty("user.dir"));
    }



    /**
     * 检查try catch finally 中变量的执行
     * @return
     */
    public int inc() {
        int x;

        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
            //System.out.println(x);
        }
    }


    public static void str(String s){



        System.out.println(s == "123");
    }




}
