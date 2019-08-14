package com.myeurekaconsumer.myeurekaconsumer.controller;

import com.myeurekaconsumer.myeurekaconsumer.consumer.EurekaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaConsumerController {
    @Autowired
    private EurekaConsumer consumer;

    @RequestMapping(value = "hi")
    public String hi(){
        return consumer.getTom();
    }
}
