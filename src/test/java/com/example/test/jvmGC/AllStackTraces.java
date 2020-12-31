package com.example.test.jvmGC;

import java.util.Map;

public class AllStackTraces {

    public static void main(String[] args) {
        getAllStackTraces();
    }

    /**
     * 可代替jstack 命令
     */
    public static void getAllStackTraces(){


        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()){
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stack = stackTrace.getValue();
            if(thread.equals(Thread.currentThread())){
                continue;
            }
            System.out.println("线程: " + thread.getName());
            for (StackTraceElement element: stack) {
                System.out.println(element);
            }
        }
    }
}
