#feign注意事项

###   RequestParam.value() was empty on parameter 0 异常问题

```java
@FeignClient("eureka-provider")
public interface HelloServer {
    
    @GetMapping("/say")
    String sayHello(@RequestParam(value = "name") String name);
}
```

`@RequestParam(value = "name")` 必须参数映射

###  java.lang.ClassNotFoundException: feign.Feign$Builder 解决方法

```groovy
compile('org.springframework.cloud:spring-cloud-starter-feign')
```

缺少`spring-cloud-starter-feign` jar导致

> [github代码地址](https://github.com/zhaoyunxing92/spring-cloud-example/tree/master/spring-cloud-feign) 欢迎大神指正
