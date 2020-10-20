package com.example.test.configurationOrder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = "com.example.test.configurationOrder.other")
@Import(Red.class)
public class MainConfig {

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
