package com.longklxs.config;

import com.longklxs.interceptor.MyInterceptorDemo1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class UserWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
    }

//    @Bean
//    public HandlerInterceptor myInterceptorDemo01(){
//        return new MyInterceptorDemo1();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptorDemo1()).addPathPatterns("/**").excludePathPatterns(Arrays.asList("/index.html","/front/**","/css/**","/js/**"));
    }
}
