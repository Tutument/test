package com.example.test.SpringTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "init2")
    public Person person(){
        return new Person();
    }
}
