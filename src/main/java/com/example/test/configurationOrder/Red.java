package com.example.test.configurationOrder;



public class Red {

    public Red() {
        System.out.println(color+"红");
    }
    private String color = "红";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
