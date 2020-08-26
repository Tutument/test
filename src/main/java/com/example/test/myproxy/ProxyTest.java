package com.example.test.myproxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) throws Exception {
        CalculatorImpl calculator = new CalculatorImpl();
        //Calculator proxy = (Calculator)getProxy(calculator);
        Calculator proxy = (Calculator)getProxy2(calculator);
        proxy.add();

    }

    //比较好理解
    public static Object getProxy( Object target) throws Exception {

        Class<?> proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        Object o = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("======before");
                Object invoke = method.invoke(target, args);
                System.out.println("======after");
                return invoke;
            }
        });
        return o;
    }

    public static Object getProxy2( Object target) throws Exception {
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("======before");
                Object invoke = method.invoke(target,args);
                System.out.println("======after");
                return invoke;
            }
        });
        return o;
    }
}
