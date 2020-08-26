package com.example.test.myspring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class MyAspectJAutoProxyCreator implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        final Object obj = bean;

        if(obj instanceof Calculator){

            Object proxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(), bean.getClass().getInterfaces(), (object, method, args) -> {
                System.out.println("=======before");
                Object invoke = method.invoke(obj, args);
                System.out.println("=======after");
                return invoke;
            });
            return proxyInstance;
        }
        return obj;
    }


}
