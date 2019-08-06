package com.boot.test.mq.rabbitmq.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 简单模式消费者
 */
@Component
@RabbitListener(queues = "springBoot_rabbit_simple")
public class MyConsumer {

    @RabbitHandler
    public void cousume(String msgContent){
        System.out.println("简单模式消息消费者接收消息： " + msgContent);
    }
}
