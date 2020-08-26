package com.example.test.myproxy;

import java.util.EnumSet;

public class CalculatorImpl implements Calculator {

    public String name;

    @Override
    public void add() {
        System.out.println("add========");
    }

    @Override
    public void find() {
        Boolean.valueOf("a");
   //     EnumSet
    }
}
