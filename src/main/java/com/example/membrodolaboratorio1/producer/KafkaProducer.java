package com.example.membrodolaboratorio1.producer;

import com.example.membrodolaboratorio1.entity.Memoir;
import com.example.membrodolaboratorio1.entity.MemoirGroup;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.membrodolaboratorio1.enums.Topics.GROUP;
import static com.example.membrodolaboratorio1.enums.Topics.MEMOIR;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafka;
    private final ObjectMapper objectMapper;

    public KafkaProducer(KafkaTemplate<String, String> kafka, ObjectMapper objectMapper){
        this.kafka = kafka;
        this.objectMapper = objectMapper;
    }

    public boolean sendMemoir(Memoir message){
        try{
            kafka.send(MEMOIR.label, message.getName() + "-" + LocalDateTime.now(), objectMapper.writeValueAsString(message));
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendGroup(MemoirGroup message){
        try{
            kafka.send(GROUP.label, message.getName() + "-" + LocalDateTime.now(), objectMapper.writeValueAsString(message));
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
