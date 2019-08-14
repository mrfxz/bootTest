package com.boot.test.mq.rabbitmq.subscription;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订阅模式生产者
 */
@Component
public class MyProductorFanout {

    @Autowired
    private AmqpTemplate template;

    public void product(String msgContent, String exchange) {
        System.out.println("订阅模式消息生产放入交换机： " + exchange);
        this.template.convertAndSend(exchange, "", msgContent);
    }
}
