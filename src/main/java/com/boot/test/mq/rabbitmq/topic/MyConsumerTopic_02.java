package com.boot.test.mq.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topicQueue_02")
public class MyConsumerTopic_02 {

    @RabbitHandler
    public void consumeTopic_02(String msg){
        System.out.println("主题模式_02_" + msg);
    }
}
