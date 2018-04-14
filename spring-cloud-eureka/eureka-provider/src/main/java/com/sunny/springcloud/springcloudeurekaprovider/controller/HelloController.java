package com.sunny.springcloud.springcloudeurekaprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className HelloController
 * @date 2018-04-15 01:06
 * @description:
 */
@RestController
@RequestMapping
public class HelloController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/say")
    String sayHello(@RequestParam String name) {
        return "hello " + name + " i am from port:" + port;
    }
}
