package com.boot.test.mq.rabbitmq.work;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 简单模式消费者
 */
@Component
@RabbitListener(queues = "springBoot_rabbit_work")
public class MyConsumerWork_02 {

    @RabbitHandler
    public void cousume(String msgContent){
        System.out.println("work模式_02_接收消息： " + msgContent);
    }
}
