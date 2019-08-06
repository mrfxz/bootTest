package com.boot.test.mq.rabbitmq.routing;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "routeQueue_01")
public class MyConsumerRouting_01 {

    /**
     * 方法名不要和其他使用RabbitHandle的方法重名，不然会失效
     * @param msg
     */
    @RabbitHandler
    public void consumeRouting_01(String msg){
        System.out.println("路由模式_01_" + msg);
    }
}
