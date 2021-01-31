package com.bili.scoreboard.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


/**
 * @author admin
 * @title: RabbitmqConfig
 * @projectName scoreboard
 * @description: mq的配置类
 * @date 2021/1/3121:05
 */
@Configuration
@ConditionalOnProperty(name="websocket.enabled",havingValue = "true")
public class RabbitmqConfig {

    final public static String EXCHANGENAME = "websocketExchange";

    /**
     * 创建交换器
     */
    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGENAME);
    }

    @Bean
    public Queue queue(){
        return new Queue(orderQueueName());
    }

    @Bean
    Binding bindingExchangeMessage(Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind((Exchange) queue).to(exchange);
    }

    /**
     * 在这里写获取队列名的具体过程
     * @return
     */
    public String orderQueueName(){
        return "orderChannel";
    }
}
