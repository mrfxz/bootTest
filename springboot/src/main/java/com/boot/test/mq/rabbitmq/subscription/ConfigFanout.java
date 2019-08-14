package com.boot.test.mq.rabbitmq.subscription;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFanout {

    /**
     * 初始化队列并交给spring管理
     *
     * @return
     */
    @Bean
    public Queue queue_01() {
        return new Queue("springBoot_rabbit_fanout_01");
    }

    @Bean
    public Queue queue_02() {
        return new Queue("springBoot_rabbit_fanout_02");
    }

    /**
     * 初始化交换机
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("springBoot_rabbit_fanoutExchange");
    }

    /**
     * 队列绑定交换机
     */
    @Bean
    Binding bindingExchange_01(Queue queue_01, FanoutExchange exchange) {
        return BindingBuilder.bind(queue_01).to(exchange);
    }

    @Bean
    Binding bindingExchange_02(Queue queue_02, FanoutExchange exchange) {
        return BindingBuilder.bind(queue_02).to(exchange);
    }
}
