package com.example.membrodolaboratorio1.entity;

import com.example.membrodolaboratorio1.dto.MemoirDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collection;

@Getter
@EqualsAndHashCode
public class MemoirGroup {
    private String name;
    private Collection<MemoirDTO> memoirDTOS;
}
