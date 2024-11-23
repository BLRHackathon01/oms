package com.example.oms.configuration.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer<V> {
    @Autowired
    private KafkaTemplate<String, V> kafkaTemplate;

    private final String TOPIC_NAME = "stock-events-t1";

    public void sendMessage(V value) {
        kafkaTemplate.send(TOPIC_NAME, value);
    }
}
