package com.example.oms.configuration.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class KafkaConsumer<V> {
    @Value(value = "spring.kafka.consumer.group-id")
    private String groupId;



    @KafkaListener(topics = "test-topic", groupId ="group-t1")
    public V consumeMessage(String message){

        System.out.println("Message received from kafka : " + message);
        return null;
    }
}
