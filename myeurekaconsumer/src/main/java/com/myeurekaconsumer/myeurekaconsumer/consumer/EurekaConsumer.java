package com.myeurekaconsumer.myeurekaconsumer.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "spring-boot-rabbitmq" ,fallbackFactory = MyFeignFallFactory.class)
public interface EurekaConsumer {
    @RequestMapping(value = "/productor",method = RequestMethod.GET)
    public String getTom();

    @RequestMapping(value = "/productor/token/{id}",method = RequestMethod.GET)
    public String getToken(@PathVariable("id") Long id);
}
