package com.example.test.asyncmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @RequestMapping("/sync")
    public String sync(){
        return "";
    }

    @RequestMapping("/order")
    public Callable<String> order(){
        logger.info("主线程开始！");
        Callable<String> result = ()->{
            logger.info("子线程开始！");
            Thread.sleep(5000L);
            logger.info("子线程结束！");
            return "success!";
        };
        logger.info("主线程结束！");
        return result;
    }
}
