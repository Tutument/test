package com.example.test.myJuint;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 模拟junit 的before 和 after
 */
public class MyJunitFrameWork {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Class clazz = EmployeeDAOTest.class;
        Object instance = clazz.newInstance();
        Method[] methods = clazz.getMethods();

        ArrayList<Method> listBefore = new ArrayList<>();
        ArrayList<Method> listAfter = new ArrayList<>();
        ArrayList<Method> listTest = new ArrayList<>();
        for (Method method :methods){
            if(method.isAnnotationPresent(MyBefore.class)){
                listBefore.add(method);
            }else if(method.isAnnotationPresent(MyAfter.class)){
                listAfter.add(method);
            }else if(method.isAnnotationPresent(MyTest.class)){
                listTest.add(method);
            }
        }

        for (Method method :listTest){
            for (Method methodb :listBefore){
                methodb.invoke(instance);
            }
            method.invoke(instance);

            for (Method methoda :listAfter){
                methoda.invoke(instance);
            }
        }

    }
}
