package com.example.membrodolaboratorio1.repository;

import com.example.membrodolaboratorio1.entity.Memoir;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class MemoirRepository {

    private Collection<Memoir> memoirRepository = new ArrayList<>();

    public void save(Memoir memoir){
        this.memoirRepository.add(memoir);
    }

    public Collection<Memoir> getALl(){
        return this.memoirRepository;
    }
}
