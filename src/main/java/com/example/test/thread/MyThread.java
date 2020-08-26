package com.example.test.thread;


/**
 * 线程异常处理
 */
public class MyThread extends  Thread {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.setUncaughtExceptionHandler((t, e)->{
            System.out.println("线程异常");
            System.out.println("线程名称"+t.getName());
            System.out.println("异常名称"+e.getMessage());
        });
        myThread.start();
        System.out.println("结束");
    }

    @Override
    public void run(){
       /* try{
            Class.forName("he");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发生了一个异常");
        }*/
        int i =10/0;

        System.out.println("子线程");
    }
}
