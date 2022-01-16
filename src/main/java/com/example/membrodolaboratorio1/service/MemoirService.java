package com.example.membrodolaboratorio1.service;

import com.example.membrodolaboratorio1.dto.MemoirDTO;
import com.example.membrodolaboratorio1.entity.Memoir;
import com.example.membrodolaboratorio1.producer.KafkaProducer;
import com.example.membrodolaboratorio1.repository.MemoirRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MemoirService {
    private final MemoirRepository memoirRepository;
    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper;

    public MemoirService(MemoirRepository memoirRepository, KafkaProducer kafkaProducer, ObjectMapper objectMapper) {
        this.memoirRepository = memoirRepository;
        this.kafkaProducer = kafkaProducer;
        this.objectMapper = objectMapper;
    }

    public boolean createMemoir(MemoirDTO memoirDTO){
        return kafkaProducer.sendMemoir(objectMapper.convertValue(memoirDTO, Memoir.class));
    }

    public Collection<Memoir> getAll(){
        return memoirRepository.getALl();
    }
}
