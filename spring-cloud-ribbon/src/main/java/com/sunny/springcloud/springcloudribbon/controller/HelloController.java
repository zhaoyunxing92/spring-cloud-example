package com.sunny.springcloud.springcloudribbon.controller;

import com.sunny.springcloud.springcloudribbon.server.HelloServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className HelloController
 * @date 2018-04-14 23:38
 * @description:
 */
@RestController
@RequestMapping("/")
public class HelloController {
    @Autowired
    private HelloServer helloServer;

    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return helloServer.sayHello(name);
    }

}
