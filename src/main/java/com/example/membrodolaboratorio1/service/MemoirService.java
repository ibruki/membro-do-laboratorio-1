package com.example.membrodolaboratorio1.service;

import com.example.membrodolaboratorio1.dto.MemoirDTO;
import com.example.membrodolaboratorio1.entity.Memoir;
import com.example.membrodolaboratorio1.producer.KafkaProducer;
import com.example.membrodolaboratorio1.repository.MemoirRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MemoirService {
    private final MemoirRepository memoirRepository;
    private final KafkaProducer kafkaProducer;

    public MemoirService(MemoirRepository memoirRepository, KafkaProducer kafkaProducer) {
        this.memoirRepository = memoirRepository;
        this.kafkaProducer = kafkaProducer;
    }

    public boolean createMemoir(MemoirDTO memoirDTO){
        return kafkaProducer.sendMemoir(new Memoir(memoirDTO.getName(), null));
    }

    public Collection<Memoir> getAll(){
        return memoirRepository.getALl();
    }
}
