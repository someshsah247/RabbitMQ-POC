package com.message.rabbitpoc.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProducerClass {

    @Value("${rabbit.exchange.name}")
    String exchangeName;

    @Value("${rabbit.routing.key}")
    String routingKey;

    // Spring automatically created it
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        log.info("ProducerClass :: sendMessage :: {}", message);
        Message byteMessage = new Message(message.getBytes());
        rabbitTemplate.send(exchangeName,routingKey,byteMessage);
    }
}
