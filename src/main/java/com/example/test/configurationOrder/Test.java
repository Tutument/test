package com.example.test.configurationOrder;

import com.example.test.configurationOrder.other.Yellow;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    //@org.junit.Test
    public void test(){
        //测试  @ComponentScan ,@Import ，@Bean 注入类的顺序  @ComponentScan > @Import > @Bean
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Yellow yellow = applicationContext.getBean(Yellow.class);
        yellow.say();
        Blue blue = applicationContext.getBean(Blue.class);
        blue.say();
    }
}
