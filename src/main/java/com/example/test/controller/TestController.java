package com.example.test.controller;

import com.dragonsoft.dcuc.common.util.PropUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello success!";
    }

    @GetMapping("/")
    public String index(){
        //PropUtils.getInstance().getConfigItem("");

        return "hello success! index";
    }
}
