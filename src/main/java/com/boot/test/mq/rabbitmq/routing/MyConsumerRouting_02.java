package com.boot.test.mq.rabbitmq.routing;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "routeQueue_02")
public class MyConsumerRouting_02 {

    @RabbitHandler
    public void consumeRouting_02(String msg){
        System.out.println("路由模式_02_" + msg);
    }
}
