package com.example.test.myspring;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
    @Override
    public void add(int a, int b) {
        System.out.println(a+b);
    }
}
