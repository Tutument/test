package com.example.test.myaop;


import com.example.test.myaop.anotation.MyTransactional;
import com.example.test.myaop.factory.BeanFactory;
import com.example.test.myaop.service.UserService;

public class AopTest {
    public static void main(String[] args) throws Exception {

        MyTransactional declaredAnnotation = AopTest.class.getDeclaredAnnotation(MyTransactional.class);
        BeanFactory beanFactory = new BeanFactory();
        UserService bean = (UserService)beanFactory.getBean("com.example.test.myaop.service.UserServiceImpl");

        System.out.println(bean.getClass().getName());
    }
}
