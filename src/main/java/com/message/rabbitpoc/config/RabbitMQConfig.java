package com.message.rabbitpoc.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Value("${rabbit.queue.name}")
    String queueName;

    @Value("${rabbit.exchange.name}")
    String exchangeName;

    @Value("${rabbit.routing.key}")
    String routingKey;

    // spring bean for queue
    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }

    //spring bean for exchange
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(exchangeName);
    }

    // Now need to bind queue and exchange with routing key
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(routingKey);
    }


// Spring automatically created bellow  INFRASTRUCTURE beans , we don't need to crete it explicitly.
// ConnectionFactory
// RabbitTemplate
// RabbitAdmin

    // for sending JSON message we need to define a couple of more bean

    @Bean
    public MessageConverter messageConverter(){
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setMessageConverter(messageConverter());
        rabbitTemplate.setConnectionFactory(connectionFactory);
        return rabbitTemplate;
    }
}



