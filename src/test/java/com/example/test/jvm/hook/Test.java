package com.example.test.jvm.hook;

/**
 * jvm关闭钩子测试
 */
public class Test {


    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        //启用退出JVM时执行Finalizer
        Runtime.runFinalizersOnExit(true);
        MyHook hook1 = new MyHook("Hook1");
        MyHook hook2 = new MyHook("Hook2");
        MyHook hook3 = new MyHook("Hook3");

        //注册关闭钩子
        Runtime.getRuntime().addShutdownHook(hook1);
        Runtime.getRuntime().addShutdownHook(hook2);
        Runtime.getRuntime().addShutdownHook(hook3);

        //移除关闭钩子
        Runtime.getRuntime().removeShutdownHook(hook3);

        //Main线程将在执行这句之后退出
        System.out.println("Main Thread Ends.");
    }
}
