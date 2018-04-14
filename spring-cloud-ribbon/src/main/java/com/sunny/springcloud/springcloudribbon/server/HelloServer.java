package com.sunny.springcloud.springcloudribbon.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunny
 * @className HelloServer
 * @date 2018-04-15 00:51
 * @description:
 */
@Service
public class HelloServer {
    @Autowired
    private RestTemplate restTemplate;

    public String sayHello(String name){
        return restTemplate.getForObject("http://EUREKA-PROVIDER/say?name="+name,String.class);
    }
}
