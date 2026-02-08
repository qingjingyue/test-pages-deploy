package com.testdeploy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    static int i = 0;

    @GetMapping("/hello")
    public String hello() {
        return """
                <h1> Hello World! </h1>
                <p> 这是第 %d 次访问 </p>
                """.formatted(++i);
    }
}
