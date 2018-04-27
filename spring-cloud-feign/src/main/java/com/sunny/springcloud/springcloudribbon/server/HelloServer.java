package com.sunny.springcloud.springcloudribbon.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunny
 * @className HelloServer
 * @date 2018-04-15 00:51
 * @description:
 */
@FeignClient("eureka-provider")
public interface HelloServer {

    @GetMapping("/say")
    String sayHello(@RequestParam(value = "name") String name);
//    public String sayHello(String name){
//        return restTemplate.getForObject("http://eureka-provider/say?name="+name,String.class);
//    }
}
