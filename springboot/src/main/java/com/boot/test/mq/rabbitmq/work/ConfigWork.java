package com.boot.test.mq.rabbitmq.work;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigWork {

    @Bean
    public Queue queueWork() {
        return new Queue("springBoot_rabbit_work");
    }
}
