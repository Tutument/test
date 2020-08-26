package com.example.test.myFilter;

public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.doSomething("HTMLFilter Request");
        chain.doFilter(request, response);
        response.doSomething("HTMLFilter Response");
    }
}
