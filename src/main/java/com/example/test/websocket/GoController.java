package com.example.test.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoController {

    @RequestMapping("/chat")
    public String goChat(){

        return "chat2";
    }
}
