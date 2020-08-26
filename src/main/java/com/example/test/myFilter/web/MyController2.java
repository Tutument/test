package com.example.test.myFilter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletConfigAware;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MyController2 {



    @RequestMapping("/hi3")
    @ResponseBody
    public String hi3(HttpServletRequest request){
        int hashCode = request.hashCode();
        System.out.println(hashCode);
        System.out.println(request.getSession().getId());
        return "haha3";
    }

}
