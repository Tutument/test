package com.example.test.myFilter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //继承WebMvcConfigurerAdapter，重写addInterceptor方法，利用registry添加拦截器（拦截器@Component，本就是Spring容器的）
        registry.addInterceptor(myInterceptor);

    }
}
