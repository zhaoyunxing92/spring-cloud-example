package com.sunny.springcloud.config.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class ConfigClientApplication {
    private final static Logger logger = LoggerFactory.getLogger(ConfigClientApplication.class);

    @Value("${spring.application.name}")
    private String name;
    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String say() {
        logger.info("name={},port={}", name, port);
        return name + ",port=" + port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
