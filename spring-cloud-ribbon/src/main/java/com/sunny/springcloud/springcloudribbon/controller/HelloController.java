package com.sunny.springcloud.springcloudribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunny
 * @className HelloController
 * @date 2018-04-14 23:38
 * @description:
 */
@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;
    public String sayHello(){
        return "";
    }

}
