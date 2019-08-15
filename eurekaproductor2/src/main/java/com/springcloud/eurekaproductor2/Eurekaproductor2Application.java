package com.springcloud.eurekaproductor2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Eurekaproductor2Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaproductor2Application.class, args);
    }

}
