package com.example.test.myFilter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/say")
public class MyController  {


    @RequestMapping("/hi")
    @ResponseBody
    public String hi(HttpServletRequest request)  {


        int hashCode = request.hashCode();
        System.out.println(hashCode);
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession();
        System.out.println("haha"+session.getId());
        System.out.println("haha"+session1.getId());
        return "haha";
    }

    @RequestMapping("/hi2")
    @ResponseBody
    public String hi2(HttpServletRequest request){

        int hashCode = request.hashCode();
        System.out.println(hashCode);
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession();
        System.out.println("haha2"+session.getId());
        System.out.println("haha2"+session1.getId());
        return "haha2";
    }
}
