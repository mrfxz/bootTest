package com.springcloud.eurekaproductor2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productor")
public class ProductorController {
    @Value("${server.port}")
    private String port;
    @RequestMapping(method = RequestMethod.GET)
    public String getTom(){
        return "i am tom:" + port;
    }
}
