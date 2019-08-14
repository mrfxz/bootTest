package com.myeurekaconsumer.myeurekaconsumer.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "spring-boot-rabbitmq")
public interface EurekaConsumer {
    @RequestMapping(value = "/restful",method = RequestMethod.GET)
    public String getTom();
}
