package com.example.membrodolaboratorio1.controller;

import com.example.membrodolaboratorio1.consumer.KafkaConsumer;
import com.example.membrodolaboratorio1.dto.Memoir;
import com.example.membrodolaboratorio1.producer.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/memoir")
public class MemoirController {

    private final KafkaProducer kafkaProducer;
    private final KafkaConsumer kafkaConsumer;

    public MemoirController(KafkaProducer kafkaProducer, KafkaConsumer kafkaConsumer){
        this.kafkaProducer = kafkaProducer;
        this.kafkaConsumer = kafkaConsumer;
    }

    @PostMapping("/create")
    public ResponseEntity<Memoir> createMemoir(@RequestBody Memoir memoir){
        if(kafkaProducer.send(memoir))
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/getALl")
    public ResponseEntity<Collection<Memoir>> getMemoirs(){
        return new ResponseEntity<>(kafkaConsumer.getRepository(), HttpStatus.OK);
    }
}
