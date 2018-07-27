package com.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.boot.test"})
public class PoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoiApplication.class, args);
    }
}
