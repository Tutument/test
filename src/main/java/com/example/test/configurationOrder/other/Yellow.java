package com.example.test.configurationOrder.other;

import com.example.test.configurationOrder.Blue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Yellow {

    @Autowired
    Blue blue;

    public Yellow() {
        System.out.println(color+ "黄");
    }

    private String color = "黄";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say(){
        System.out.println(blue.getColor());
    }
}
