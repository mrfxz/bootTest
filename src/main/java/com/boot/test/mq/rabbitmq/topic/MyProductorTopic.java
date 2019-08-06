package com.boot.test.mq.rabbitmq.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyProductorTopic {
    @Autowired
    private RabbitTemplate template;

    public void pro(String exchangeName,String routingKey,String msgContent){
        System.out.println("路由模式生产放入交换机："  + exchangeName);
        this.template.convertAndSend(exchangeName,routingKey,msgContent);
    }
}
