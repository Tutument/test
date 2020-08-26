package com.example.test.myFilter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    // 标识当前执行到第几个过滤器
    private int index = 0;

    // 所有已注册的过滤器
    private List<Filter> filters = new ArrayList<Filter>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        // return this，返回当前对象，即可形成链式调用
        return this;
    }

    // 执行过滤器
    public void doFilter(Request request, Response response) {
        // 所有过滤器执行完毕，return
        if (index == filters.size()) {
            return;
        }
        // 得到过滤器
        Filter filter = filters.get(index);
        // 自增操作不能和下面doFilter互换
        index++;
        // 执行过滤器
        filter.doFilter(request, response, this);

    }
}
