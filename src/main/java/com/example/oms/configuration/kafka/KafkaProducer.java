package com.example.oms.configuration.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer{


    @Autowired
    private KafkaTemplate<String, java.lang.String> kafkaTemplate;

    private final String TOPIC_NAME = "test-topic";

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
    }
}
