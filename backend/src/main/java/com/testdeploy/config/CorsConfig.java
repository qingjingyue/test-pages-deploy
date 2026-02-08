package com.testdeploy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口都支持跨域
                .allowedOriginPatterns("*") // 允许所有来源，生产环境应该限制具体域名
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许所有 HTTP 方法
                .allowedHeaders("*") // 允许所有请求头
                .allowCredentials(true) // 允许发送 Cookie
                .maxAge(3600); // 预检请求的有效期，单位秒
    }
}
