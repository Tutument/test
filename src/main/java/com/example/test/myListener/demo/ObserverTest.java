package com.example.test.myListener.demo;

public class ObserverTest {
    public static void main(String[] args) {
        Thief thief = new Thief();

        ThiefListener listener = new ThiefListener() {

            @Override
            public void shot(Event event) {
                System.out.println("嘟嘟嘟");
            }
        };
        thief.registerListener(listener);
        thief.steal();

    }
}
