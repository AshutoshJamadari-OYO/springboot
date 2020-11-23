package com.example.demoCrud.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish/{msg}")
    public void sendMessageToKafkaTopic(@PathVariable String msg) {
        this.producer.sendMessage(msg);
    }
}
