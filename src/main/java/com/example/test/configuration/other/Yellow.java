package com.example.test.configuration.other;

import org.springframework.stereotype.Component;

@Component
public class Yellow {

    public Yellow() {
        System.out.println(color+ "黄");
    }

    private String color = "黄";
}
