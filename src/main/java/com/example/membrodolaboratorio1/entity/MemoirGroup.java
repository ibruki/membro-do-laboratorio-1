package com.example.membrodolaboratorio1.entity;

import com.example.membrodolaboratorio1.dto.MemoirDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@EqualsAndHashCode
public class MemoirGroup {
    private String id;
    private String name;
    private Collection<Memoir> memoirs;

    public MemoirGroup(String name, Collection<Memoir> memoirs) {
        this.name = name;
        this.memoirs = memoirs;
        this.id = name + LocalDateTime.now();
    }
}
