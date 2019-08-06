package com.boot.test.mq.rabbitmq.subscription;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 简单模式消费者
 */
@Component
@RabbitListener(queues = "springBoot_rabbit_fanout_01")
public class MyConsumerFanout_01 {

    @RabbitHandler
    public void cousume(String msgContent){
        System.out.println("订阅模式_01_接收消息： " + msgContent);
    }
}
