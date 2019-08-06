package com.boot.test.mq.rabbitmq.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注意事项
 * 绑定方法接参要和参数BeanName保持一致（BeanName默认是方法名）
 */
@Configuration
public class MyConfigTopic {

    /**
     * 初始化队列
     * @return
     */
    @Bean
    public Queue topicQueue_01(){
        return new Queue("topicQueue_01");
    }

    @Bean
    public Queue topicQueue_02(){
        return new Queue("topicQueue_02");
    }

    /**
     * 初始化路由交换机
     * @return
     */
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    /**
     * 绑定队列和交换机
     */
    @Bean
    Binding bindingExchange_01(Queue topicQueue_01,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueue_01).to(topicExchange).with("routeKey.*");
    }

    /**
     * 绑定队列和交换机
     */
    @Bean
    Binding bindingExchange_02(Queue topicQueue_02,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueue_02).to(topicExchange).with("routeKey.#");
    }
}
