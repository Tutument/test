package com.example.test.myFilter;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.doSomething("SensitiveFilter Request");
        chain.doFilter(request, response);
        response.doSomething("Sensitive Response");
    }
}
