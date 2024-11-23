/*
package com.example.oms.configuration.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class KafkaConsumer<V> {
    @Value(value = "spring.kafka.consumer.group-id")
    private String groupId;

    @KafkaListener(topics = "stock-events-t1", groupId ="group-t1")
    public V consumeMessage(V value){
        return value;
    }
}
*/
