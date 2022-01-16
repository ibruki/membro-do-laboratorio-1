package com.example.membrodolaboratorio1.controller;

import com.example.membrodolaboratorio1.dto.MemoirGroupDTO;
import com.example.membrodolaboratorio1.entity.MemoirGroup;
import com.example.membrodolaboratorio1.service.MemoirGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/group")
public class MemoirGroupController {

    private final MemoirGroupService memoirGroupService;

    public MemoirGroupController(MemoirGroupService memoirGroupService) {
        this.memoirGroupService = memoirGroupService;
    }

    @PostMapping
    public ResponseEntity<String> createGroup(@RequestBody MemoirGroupDTO memoirGroupDTO){
        if(memoirGroupService.createMemoirGroup(memoirGroupDTO))
            return new ResponseEntity<>("Grupo criado com sucesso!", HttpStatus.CREATED);
        return new ResponseEntity<>("Group não criado com sucesso!", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getALl")
    public ResponseEntity<Collection<MemoirGroup>> getAll(){
        return new ResponseEntity<>(memoirGroupService.getAll(), HttpStatus.OK);
    }
}
