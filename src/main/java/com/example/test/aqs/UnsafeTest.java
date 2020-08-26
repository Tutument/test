package com.example.test.aqs;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {


    public static void main(String[] args) {
        Unsafe unsafe = getUnsafe();

        System.out.println(unsafe);
    }

    public static Unsafe getUnsafe()  {
        Class clazz = Unsafe.class;
        Field f = null;
        Unsafe unsafe = null;
        try {
            f = clazz.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe)f.get(clazz);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return unsafe;
    }
}
