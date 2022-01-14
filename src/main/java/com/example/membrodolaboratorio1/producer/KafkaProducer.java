package com.example.membrodolaboratorio1.producer;

import com.example.membrodolaboratorio1.dto.Memoir;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaProducer {

    @Value("topictest")
    private String topic;
    private KafkaTemplate<String, String> kafka;
    private ObjectMapper objectMapper;

    public KafkaProducer(KafkaTemplate<String, String> kafka, ObjectMapper objectMapper){
        this.kafka = kafka;
        this.objectMapper = objectMapper;
    }

    public boolean send(Memoir memoir){
        try{
            kafka.send(topic, memoir.getNome() + "-" + LocalDateTime.now(), objectMapper.writeValueAsString(memoir));
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
