package com.example.test.myFilter.web;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter start");
       if(false){
           response.setContentType("text/plain");
           String resdata = "哈哈，你个黑户不能进的奥";
           response.setContentLength(resdata.getBytes().length);
           response.setCharacterEncoding("UTF-8");
           response.getOutputStream().write(resdata.getBytes());
           response.getOutputStream().flush();
           return;
       }
        chain.doFilter(request,response);
        System.out.println("filter end");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
}
