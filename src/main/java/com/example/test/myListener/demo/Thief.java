package com.example.test.myListener.demo;

public class Thief {

    //观察者模式
    private ThiefListener listener;

    public void registerListener(ThiefListener listener) {
        this.listener = listener;
    }

    public void steal(){
        System.out.println("偷东西");
        if(listener!=null){
            listener.shot(new Event(this));
        }
    }

}
