package com.example.test.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    @org.junit.Test
    public void test(){
        //测试  @ComponentScan ,@Import ，@Bean 注入类的顺序  @ComponentScan > @Import > @Bean
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //applicationContext.
    }
}
