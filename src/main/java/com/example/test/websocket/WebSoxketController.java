package com.example.test.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class WebSoxketController {

    @Autowired
    WebSocket webSocket;


    @ResponseBody
    @GetMapping("/sendTo")
    public String sendTo(@RequestParam("userId") String userId, @RequestParam("msg") String msg) throws IOException {

        webSocket.sendMessageTo(msg,userId);

        return "推送成功";
    }

    @RequestMapping("/webSocketIndex/{userId}")
    public String index(Model model, @PathVariable String userId){
        model.addAttribute("userId",userId);
        return "websocket";
    }
}
