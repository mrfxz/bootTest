package com.boot.test.mq.rabbitmq.routing;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyProductorRouting {
    @Autowired
    private RabbitTemplate template;

    public void pro(String exchangeName, String routingKey, String msgContent) {
        System.out.println("路由模式生产放入交换机：" + exchangeName);
        this.template.convertAndSend(exchangeName, routingKey, msgContent);
    }
}
