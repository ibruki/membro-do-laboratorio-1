package com.example.membrodolaboratorio1.consumer;

import com.example.membrodolaboratorio1.dto.Memoir;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Slf4j
public class KafkaConsumer {

    private Collection<Memoir> memoirRepository = new ArrayList<>();
    private final ObjectMapper objectMapper;

    public KafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "topictest", groupId = "topictest")
    public void consume(ConsumerRecord<?, String> message) {
        log.info("Mensagem consumida -> {} " + message.key());

        try {
            Memoir memoir = objectMapper.readValue(message.value(), Memoir.class);
            memoirRepository.add(memoir);
        } catch (Exception e){
            log.error("Falhou ao tentar consumir a mensagem " + message.key() + ". Erro: " + e.getMessage());
        }
    }

    public Collection<Memoir> getRepository(){
        return this.memoirRepository;
    }
}
