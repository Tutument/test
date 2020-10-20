package com.example.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = "com.example.test.configuration.other")
@Import(Red.class)
public class MainConfig {

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
