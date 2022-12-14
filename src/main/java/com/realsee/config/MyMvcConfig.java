package com.realsee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

//这是一个配置类等同于配置文件
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    private String[] patterns = new String[]{
            "test",
            "/",
            "/index",
            "/index.html",
            "/user/login",
            "static/**"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
