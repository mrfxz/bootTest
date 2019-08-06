package com.boot.test.mq.rabbitmq.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    /**
     * 初始化队列并交给spring管理
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue("springBoot_rabbit_simple");
    }

}
