package com.example.membrodolaboratorio1.consumer;

import com.example.membrodolaboratorio1.entity.Memoir;
import com.example.membrodolaboratorio1.entity.MemoirGroup;
import com.example.membrodolaboratorio1.repository.MemoirGroupRepository;
import com.example.membrodolaboratorio1.repository.MemoirRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    private final MemoirRepository memoirRepository;
    private final MemoirGroupRepository memoirGroupRepository;
    private final ObjectMapper objectMapper;

    public KafkaConsumer(MemoirRepository memoirRepository, MemoirGroupRepository memoirGroupRepository, ObjectMapper objectMapper) {
        this.memoirRepository = memoirRepository;
        this.memoirGroupRepository = memoirGroupRepository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "topictest", groupId = "topictest")
    public void consumeMemoir(ConsumerRecord<?, String> message) {
        log.info("Mensagem consumida -> {} " + message.key());

        try {
            memoirRepository.save(objectMapper.readValue(message.value(), Memoir.class));
        } catch (Exception e){
            log.error("Falhou ao tentar consumir a mensagem " + message.key() + ". Erro: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "topictest2", groupId = "topictest2")
    public void consumeGroup(ConsumerRecord<?, String> message) {
        log.info("Mensagem consumida -> {} " + message.key());

        try {
            memoirGroupRepository.save(objectMapper.readValue(message.value(), MemoirGroup.class));
        } catch (Exception e){
            log.error("Falhou ao tentar consumir a mensagem " + message.key() + ". Erro: " + e.getMessage());
        }
    }
}
