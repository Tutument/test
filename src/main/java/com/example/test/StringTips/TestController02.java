package com.example.test.StringTips;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController02 {


    @RequestMapping("/test02")
    public String readTimeOut(){


        try {
            Thread.sleep(25 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ReadTimeOut";
    }

    public void test(){

    }
}
