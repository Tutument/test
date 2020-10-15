package com.example.test.SpringTest;

import javax.annotation.PostConstruct;

public class Person {

    private String name;

    private Integer age;

    @PostConstruct
    public void init(){
        this.name = "小明";

    }


    public void init2(){
        this.age = 18;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
