package com.boot.test.mq.rabbitmq.subscription;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 简单模式消费者
 */
@Component
@RabbitListener(queues = "springBoot_rabbit_fanout_02")
public class MyConsumerFanout_02 {

    @RabbitHandler
    public void cousume(String msgContent){
        System.out.println("订阅模式_02_接收消息： " + msgContent);
    }
}
