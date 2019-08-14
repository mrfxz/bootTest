package com.boot.test.mq.rabbitmq.routing;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigRouting {

    /**
     * 初始化队列
     *
     * @return
     */
    @Bean
    public Queue routeQueue_01() {
        return new Queue("routeQueue_01");
    }

    @Bean
    public Queue routeQueue_02() {
        return new Queue("routeQueue_02");
    }

    /**
     * 初始化路由交换机
     *
     * @return
     */
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("routeExchange");
    }

    /**
     * 绑定队列和交换机
     * 和其他模块方法重名，指定beanName,否则不会初始化Bean
     */
    @Bean(name = "routeBinding_01")
    Binding bindingExchange_01(Queue routeQueue_01, DirectExchange directExchange) {
        return BindingBuilder.bind(routeQueue_01).to(directExchange).with("routeKey.1");
    }

    /**
     * 绑定队列和交换机
     * 和其他模块方法重名，指定beanName,否则不会初始化Bean
     */
    @Bean(name = "routeBinding_02")
    Binding bindingExchange_02(Queue routeQueue_02, DirectExchange directExchange) {
        return BindingBuilder.bind(routeQueue_02).to(directExchange).with("routeKey.2");
    }
}
