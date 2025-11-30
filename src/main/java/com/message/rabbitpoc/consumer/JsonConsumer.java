package com.message.rabbitpoc.consumer;

import com.message.rabbitpoc.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonConsumer {

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void listenRabbitUserData(User user){
        log.info(" JsonConsumer :: listenRabbitUserData :: {}", user.toString());
    }
}
