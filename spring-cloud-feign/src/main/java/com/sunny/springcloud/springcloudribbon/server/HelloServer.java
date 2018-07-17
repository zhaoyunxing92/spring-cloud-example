package com.sunny.springcloud.springcloudribbon.server;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
