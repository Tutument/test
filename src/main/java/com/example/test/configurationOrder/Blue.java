package com.example.test.configurationOrder;

import com.example.test.configurationOrder.other.Yellow;
import org.springframework.beans.factory.annotation.Autowired;

public class Blue {

    @Autowired
    Yellow yellow;

    public Blue() {
        System.out.println(color + "蓝");
    }
    private String color = "蓝";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say(){
        System.out.println(yellow.getColor());
    }
}
