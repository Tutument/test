package com.example.test.procon;


import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hard {

    public static void main(String[] args) {
        toFormate();
    }

    public static void  listAdd(){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for(int i=0; i<3;i++){
           // list.add(list.get(i)+1);
            list.set(i,list.get(i)+1);
        }
        list.forEach(e->{
            System.out.println(e);
        });
    }

    public static void add(){
        int count =14;
        int pagesize = 10;
        int t =(count % pagesize)== 0 ? 0 : 1;
        System.out.println(t);
        int tt= count / pagesize +(count % pagesize== 0 ? 0 : 1);
        String s = null;
        Assert.isNull(s,"字符串不能为空！");
        System.out.println(tt);
    }

    public static void test(){
        HashSet<String> set = new HashSet<>();
        Thread thread = new Thread();
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("a");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("aa");
            }
        };

        Thread a = new Thread(){
            @Override
            public void run() {
                System.out.println("bb");
            }
        };

    }

    public static void toFormate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = formatter.format(LocalDateTime.now());
        System.out.println(format);

        Lock lock = new ReentrantLock();
        Condition conditionOne = lock.newCondition();
        try {
            lock.lock();

            if (true) {
                System.out.println("进入");
                conditionOne.await();
                System.out.println("结束");
            }
            conditionOne.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}
