package com.example.test.myFilter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//WebMvcConfigurer 这是扩展web配置的
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*
    //拦截器配置
    void addInterceptors(InterceptorRegistry var1);
    // 视图跳转控制器
    void addViewControllers(ViewControllerRegistry registry);
    //静态资源处理
    void addResourceHandlers(ResourceHandlerRegistry registry);
    // 默认静态资源处理器
    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);
    //这里配置视图解析器
    void configureViewResolvers(ViewResolverRegistry registry);
    // 配置内容裁决的一些选项
    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
    //解决跨域问题
    public void addCorsMappings(CorsRegistry registry) ;
*/
    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //继承WebMvcConfigurerAdapter，重写addInterceptor方法，利用registry添加拦截器（拦截器@Component，本就是Spring容器的）
        registry.addInterceptor(this.myInterceptor());

    }


}
