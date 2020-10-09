package com.example.test.myFilter;

public class Test {

    public static void main(String[] args) {
        // Tomcat准备了Request、Response
        Request request = new Request();
        Response response = new Response();

        // 过滤器链
        FilterChain chain = new FilterChain();
        // 注册过滤器，可以看看下方FilterChain代码是如何实现链式调用的
        chain.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter()).addFilter(new HTMLFilter());
        // 开始执行过滤器
        chain.doFilter(request, response);
    }
}
