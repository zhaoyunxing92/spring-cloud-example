# spring-cloud-example
###  服务注册和发现-[eureka](./spring-cloud-eureka)

####   server配置

#####    gradle配置

```groovy
buildscript {
    ext {
        springBootVersion = '2.0.1.RELEASE'
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
version = '1.0-SNAPSHOT'
sourceCompatibility = 1.8

repositories {
    mavenCentral()
    maven { url "http://repo.spring.io/snapshot" }
    maven { url "http://repo.spring.io/milestone" }
    maven { url "http://repo.spring.io/plugins-release" }
}


ext {
    springCloudVersion = 'Finchley.M9'
}

dependencies {
    //使用spring-cloud-starter-eureka-server
    compile('org.springframework.cloud:spring-cloud-starter-eureka-server:1.3.2.RELEASE')
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



####   provider配置

##### gradle配置

```groovy
buildscript {
    ext {
        springBootVersion = '2.0.1.RELEASE'
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
version = '1.0.2-SNAPSHOT'
sourceCompatibility = 1.8

repositories {
    mavenCentral()
    maven { url "http://repo.spring.io/snapshot" }
    maven { url "http://repo.spring.io/milestone" }
    maven { url "http://repo.spring.io/plugins-release" }
}


ext {
    springCloudVersion = 'Finchley.M9'
}

dependencies {
    //使用 spring-cloud-starter-eureka
    compile('org.springframework.cloud:spring-cloud-starter-eureka:1.3.2.RELEASE')
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

