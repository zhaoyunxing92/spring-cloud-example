#eureka服务发现与注册

###   server配置

#####    gradle配置

```groovy
buildscript {
    ext {
        springBootVersion = '1.5.12.RELEASE'
    }
    repositories {
        mavenCentral()
        maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
       // jcenter()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

group = 'com.sunny.spring-cloud'
version = '1.0.0-SNAPSHOT'
sourceCompatibility = 1.8

repositories {
    maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
    mavenCentral()
    maven { url "http://repo.spring.io/snapshot" }
    maven { url "http://repo.spring.io/milestone" }
    maven { url "http://repo.spring.io/plugins-release" }
}


ext {
    springCloudVersion = 'Dalston.SR1'
}

dependencies {
	compile('org.springframework.boot:spring-boot-starter-actuator')
    compile('org.springframework.cloud:spring-cloud-starter-eureka-server')
    testCompile('org.springframework.boot:spring-boot-starter-test')
    //testCompile('org.springframework.security:spring-security-test')
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}


```

##### yml配置

```yaml
server:
  port: 8761
logging:
  level:
    root: debug
    com:
     spring: debug
eureka:
  instance:
    hostname: localhost
  client:
    fetch-registry: false  #禁止从获取eureka注册信息
    register-with-eureka: false # 是否注册到eureka
    serviceUrl:
     defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
spring:
  application:
    name: eureka-server
```

> eureka server 必须禁止`fetch-registry` 和`register-with-eureka` 否则启动报错

##### java代码

```java
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerApplication.class, args);
    }
}
```



###   provider配置

##### gradle配置

```groovy
buildscript {
    ext {
        springBootVersion = '1.5.12.RELEASE'
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

group = 'com.sunny.spring-cloud'
version = '1.0.0-SNAPSHOT'
sourceCompatibility = 1.8

repositories {
   mavenCentral()

}


ext {
    springCloudVersion = 'Dalston.SR1'
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter-actuator')
    compile('org.springframework.boot:spring-boot-starter-web')
    compile('org.springframework.cloud:spring-cloud-starter-eureka')
    testCompile('org.springframework.boot:spring-boot-starter-test')
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}

```

##### yml配置

```yaml
spring:
  application:
    name: eureka-provider # 服务的名称
server:
  port: 8700
eureka:
  client:
    serviceUrl:
        defaultZone: http://localhost:8761/eureka/ # eureka-server地址
  instance:
    hostname: localhost

```

##### java代码

```java
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudEurekaProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaProviderApplication.class, args);
	}
}

```
> [github代码地址](https://github.com/zhaoyunxing92/spring-cloud-example/tree/master/spring-cloud-eureka) 欢迎大神指正
