package com.example.test.cache;

public class test {

    public void getFwp(int i, int j, String... m) {
        if (m.length != 0) {
            System.out.println(m.length);
            System.out.println(m[0]);
        }
        System.out.println(i);
        System.out.println(j);

    }

    public static void main(String[] args) {
        test s = new test();

     //s.getFwp(1, 2, "sdfsadf");
       s.getFwp(1, 2, "sdfsadf1", "sfasdf");
    }
}
