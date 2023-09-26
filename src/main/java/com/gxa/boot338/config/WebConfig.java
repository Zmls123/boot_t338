package com.gxa.boot338.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
* web相关配置
* 1、包括跨域配置
* 2、资源映射配置
* */
@Configuration
public class WebConfig implements WebMvcConfigurer {
/*
* 跨域访问的方法
* */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*");
    }

    /*
    * 建立资源映射的方法
    * registry资源处理器的注射器
    * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /表示服务器的根路径 localhost:8080/
        //添加一个资源的处理方案 针对/uploadImg/** 资源下的所有文件请求
        registry.addResourceHandler("/uploadImg/**").addResourceLocations("https://zml-1318096182.cos.ap-chengdu.myqcloud.com");
    }
}
