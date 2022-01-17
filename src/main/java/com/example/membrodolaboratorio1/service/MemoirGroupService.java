package com.example.membrodolaboratorio1.service;

import com.example.membrodolaboratorio1.dto.MemoirGroupDTO;
import com.example.membrodolaboratorio1.entity.MemoirGroup;
import com.example.membrodolaboratorio1.producer.KafkaProducer;
import com.example.membrodolaboratorio1.repository.MemoirGroupRepository;
import com.example.membrodolaboratorio1.repository.MemoirRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MemoirGroupService {

    private final MemoirGroupRepository memoirGroupRepository;
    private final MemoirRepository memoirRepository;
    private KafkaProducer kafkaProducer;

    public MemoirGroupService(MemoirGroupRepository memoirGroupRepository, MemoirRepository memoirRepository, KafkaProducer kafkaProducer) {
        this.memoirGroupRepository = memoirGroupRepository;
        this.memoirRepository = memoirRepository;
        this.kafkaProducer = kafkaProducer;
    }


    public boolean createMemoirGroup(MemoirGroupDTO memoirGroupDTO){
        return kafkaProducer.sendGroup(new MemoirGroup(memoirGroupDTO.getName(), null));
    }

//    public boolean addMemoirToGroup(String id, String group){
//
//    }

    public Collection<MemoirGroup> getAll(){
        return memoirGroupRepository.getAll();
    }
}
