package com.example.membrodolaboratorio1.controller;

import com.example.membrodolaboratorio1.dto.MemoirDTO;
import com.example.membrodolaboratorio1.entity.Memoir;
import com.example.membrodolaboratorio1.service.MemoirService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/memoir")
public class MemoirController {

    private final MemoirService memoirService;

    public MemoirController(MemoirService memoirService) {
        this.memoirService = memoirService;
    }

    @PostMapping("/create")
    public ResponseEntity<Memoir> createMemoir(@RequestBody MemoirDTO memoirDTO){
        if(memoirService.createMemoir(memoirDTO))
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/getALl")
    public ResponseEntity<Collection<Memoir>> getMemoirs(){
        return new ResponseEntity<>(memoirService.getAll(), HttpStatus.OK);
    }
}
