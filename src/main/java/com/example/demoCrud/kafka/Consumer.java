package com.example.demoCrud.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message){
//        logger.info(String.format("#### -> Consumed message -> %s", message));
        System.out.println(message);
    }
}
