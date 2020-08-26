package com.example.test.myJpa;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User x = new User("xiaoming", 18);
        long l1 = System.nanoTime();
        userDao.add(x);
        long l2 = System.nanoTime();
        System.out.println(l2-l1);
    }
}
