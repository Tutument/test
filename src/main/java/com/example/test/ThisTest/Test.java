package com.example.test.ThisTest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.Assert;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        //对this指向的测试spuer()这个方法 在B中 this.super();
        /*B b = new B();
        b.get();
        A a = new A();
        a.get();*/

        //ass(null);

        //ReentrantLock lock;

        //f();

        /*JSONObject jsonObject = new JSONObject();
        String aa = jsonObject.getString("aa");
        System.out.println(aa);*/
       /* JSONObject jsonObject = new JSONObject();
        String aa = jsonObject.getString("aa");
        System.out.println(aa);
*/
       /* JSONObject jsonObject = new JSONObject();

        String a = jsonObject.getString("a");
       System.out.println(a);
       //Objects;
        FileInputStream inputStream;
        Socket socket;
        ServerSocket serverSocket;*/
       /* System.out.println("00000000-5c0e-3cea-0000-000074ad0c1e".replaceAll("-","").length());

        System.out.println("E0FA6F3849B4450FB93CB7400CE5F794".length());
        System.out.println("000000005C0E3CEA0000000074AD0C1E".length());

        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        //System.out.println(list.get(0));*/

        /*List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
       *//* while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("2")) {
                iterator.remove();
            }
        }*//*

        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }*/

        try {
            int i = 1/0;
        }catch (Exception e){
            String exceptionStackTrace = getExceptionStackTrace(e);
            System.out.println(exceptionStackTrace);
        }
    }
    public static void ass(String name){
        Assert.notNull(name, "Name must not be null!");
    }

    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }

    public static String getExceptionStackTrace(Throwable anexcepObj)
    {
        StringWriter sw = null;
        PrintWriter printWriter = null;
        try{
            if(anexcepObj != null)
            {
                sw = new StringWriter();
                printWriter = new PrintWriter(sw);
                anexcepObj.printStackTrace(printWriter);
                printWriter.flush();
                sw.flush();
                return sw.toString();
            }
            else
                return null;
        }finally
        {

            try
            {
                if(sw != null)
                    sw.close();
                if(printWriter != null)
                    printWriter.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
