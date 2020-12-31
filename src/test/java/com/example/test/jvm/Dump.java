package com.example.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试堆溢出错误
 */
public class Dump {


    public static void main(String[] args) {

        List<OomObject> list = new ArrayList<>();

        while (true){
            list.add(new OomObject());
        }
    }



    static class OomObject{
        long a = 1;
    }
}
