package com.boot.test.mq.rabbitmq.work;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 简单模式生产者
 */
@Component
public class MyProductorWork {

    @Autowired
    private AmqpTemplate template;

    public void product(String msgContent,String queueName){
        System.out.println("简单模式消息生产放入队列： " + queueName);
        this.template.convertAndSend(queueName,msgContent);
    }
}
