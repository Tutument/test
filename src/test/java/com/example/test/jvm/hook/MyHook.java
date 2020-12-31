package com.example.test.jvm.hook;

public class MyHook extends Thread {

    private String name;
    public MyHook (String name) {
        this.name = name;
        setName(name);
    }
    public void run() {
        System.out.println(name + " Ends.");
    }
    //重写Finalizer，将在关闭钩子后调用
    protected void finalize() throws Throwable {
        System.out.println(name + " Finalize.");
    }

}
