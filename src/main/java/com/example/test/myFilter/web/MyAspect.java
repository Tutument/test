package com.example.test.myFilter.web;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

//@Aspect
//@Component
public class MyAspect {

  /*  @Before("execution(* com.example.test.myFilter.web.MyController.*(..))")
    public void before() {
        System.out.println("Before");
    }

    @After("execution(* com.example.test.myFilter.web.MyController.*(..))")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("execution(* com.example.test.myFilter.web.MyController.*(..))")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @AfterThrowing("execution(* com.example.test.myFilter.web.MyController.*(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
*/

    @Around("execution(* com.example.test.myFilter.web.MyController.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("around前置");
        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object result = pjp.proceed();
        HttpServletResponse response = attributes.getResponse();

        response.setHeader("appID","123456");
        System.out.println("around后置");
        return result;
    }
}
