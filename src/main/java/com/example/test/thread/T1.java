package com.example.test.thread;

import java.util.concurrent.TimeUnit;

public class T1 extends Thread{
    private boolean running;
    public void setRunning(boolean running) {
        this.running = running;
    }
    @Override
    public void run() {
        while (running) {
            System.out.println("i am working ....");
            if(Thread.currentThread().isInterrupted()){
                break;
            }
        }
    }
    public static void main(String[] args) {
        T1 myThread = new T1();
        myThread.setRunning(true);
        myThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }
        myThread.interrupt();
    }
}
