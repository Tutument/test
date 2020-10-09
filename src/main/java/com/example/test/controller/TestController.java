package com.example.test.controller;

import com.dragonsoft.dcuc.common.util.PropUtils;
import com.example.test.myaop.source.CloudEnc;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/hello")
    @CloudEnc
    public String hello(@RequestParam("str") String str){
        System.out.println(str);
        return "hello success!";
    }

    @GetMapping("/{str}")
    @CloudEnc
    public String index(@PathVariable String str){
        //PropUtils.getInstance().getConfigItem("");
        System.out.println(str);
        return "hello success! index";
    }
}
