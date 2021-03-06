package com.example.test.procon;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 生产者 消费者
 * @param <T>
 */
public class MyContainer2<T> {

    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10; //固定容量,假定最多10个元素
    private int count = 0;

    //put方法
    public synchronized void put(T t) {
        while(lists.size() == MAX) { //想想为什么用while而不是用if？
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lists.add(t);
        ++count;
        this.notifyAll(); //通知消费者线程进行消费
    }

    //get方法
    public synchronized T get() {
        T t = null;
        while(lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count --;
        this.notifyAll(); //通知生产者进行生产
        return t;
    }

    public static void main(String[] args) {
        MyContainer2<String> c = new MyContainer2<>();
        //启动消费者线程
        for(int i=0; i<10; i++) {
            new Thread(()->{
                for(int j=0; j<5; j++)
                    System.out.println(c.get());
            }, "c" + i).start();
        }
        System.out.println("=======");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者线程
        for(int i=0; i<2; i++) {
            new Thread(()->{
                for(int j=0; j<25; j++){
                    c.put(Thread.currentThread().getName() + " " + j);
                    System.out.println(Thread.currentThread().getName()+"__"+j);
                }

            }, "p" + i).start();
        }
    }
}
