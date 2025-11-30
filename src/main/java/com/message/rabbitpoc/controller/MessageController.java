package com.message.rabbitpoc.controller;

import com.message.rabbitpoc.dto.User;
import com.message.rabbitpoc.producer.JsonProducer;
import com.message.rabbitpoc.producer.ProducerClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MessageController {

    @Autowired
    private ProducerClass producerClass;

    @Autowired
    private JsonProducer jsonProducer;

    // For normal String
    @GetMapping("/publishString/{message}")
    public ResponseEntity<String> sendMessageToProducer(@PathVariable String message){
        if (message != null){
            producerClass.sendMessage(message);
            return ResponseEntity.ok("Message Sent.");
        }
        return ResponseEntity.ok("Message is Empty.");
    }

    // For norJson data
    @PostMapping("/publishJsonString")
    public ResponseEntity<String> sendMessageToProducer(@RequestBody User user){
        if (user != null){
            jsonProducer.sendMessage(user);
            return ResponseEntity.ok("User Json Sent.");
        }
        return ResponseEntity.ok("User is Empty.");
    }

}
