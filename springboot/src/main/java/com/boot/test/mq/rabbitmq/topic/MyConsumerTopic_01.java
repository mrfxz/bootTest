package com.boot.test.mq.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topicQueue_01")
public class MyConsumerTopic_01 {

    /**
     * 方法名不要和其他使用RabbitHandle的方法重名，不然会失效
     *
     * @param msg
     */
    @RabbitHandler
    public void consumeTopic_01(String msg) {
        System.out.println("主题模式_01_" + msg);
    }
}
