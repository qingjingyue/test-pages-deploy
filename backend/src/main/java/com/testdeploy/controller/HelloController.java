package com.testdeploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloController {

    private static final String COUNT_KEY = "visit_count";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        Long count = redisTemplate.opsForValue().increment(COUNT_KEY);
        return """
                <h1> Hello World! </h1>
                <p> 当前时间：%s </p>
                <p> 这是第 %d 次访问 </p>
                """
                .formatted(
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                        count);
    }

    @GetMapping("/count")
    public Long count() {
        return redisTemplate.opsForValue().increment(COUNT_KEY);
    }

}
