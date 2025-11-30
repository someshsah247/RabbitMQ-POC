package com.message.rabbitpoc.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerClass {

    // This method is used is used for string data ,
    // we have only 1 queue in this POC -- so need to comment it inorder to work with json data

//    @RabbitListener(queues = "${rabbit.queue.name}")
//    public void listenRabbitMessage(String message){
//        log.info(" ConsumerClass :: listenRabbitMessage :: {}", message);
//    }
}
