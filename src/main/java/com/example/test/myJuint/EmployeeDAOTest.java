package com.example.test.myJuint;

public class EmployeeDAOTest {

    @MyBefore(value = "aa")
    public void init(){
        System.out.println("初始化=====");
    }

    @MyTest("bb")
    public void test01(){
        System.out.println("test01=====");
    }
    @MyTest("cc")
    public void test02(){
        System.out.println("test02=====");
    }

    @MyAfter("dd")
    public void destory(){
        System.out.println("destory====");
    }
}
