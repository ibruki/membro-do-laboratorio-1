package com.example.membrodolaboratorio1.service;

import com.example.membrodolaboratorio1.dto.MemoirGroupDTO;
import com.example.membrodolaboratorio1.entity.MemoirGroup;
import com.example.membrodolaboratorio1.producer.KafkaProducer;
import com.example.membrodolaboratorio1.repository.MemoirGroupRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MemoirGroupService {

    private final MemoirGroupRepository memoirGroupRepository;
    private KafkaProducer kafkaProducer;
    private ObjectMapper objectMapper;

    public MemoirGroupService(MemoirGroupRepository memoirGroupRepository, KafkaProducer kafkaProducer, ObjectMapper objectMapper) {
        this.memoirGroupRepository = memoirGroupRepository;
        this.kafkaProducer = kafkaProducer;
        this.objectMapper = objectMapper;
    }

    public boolean createMemoirGroup(MemoirGroupDTO memoirGroupDTO){
        return kafkaProducer.sendGroup(objectMapper.convertValue(memoirGroupDTO, MemoirGroup.class));
    }

    public Collection<MemoirGroup> getAll(){
        return memoirGroupRepository.getAll();
    }
}
