package com.example.membrodolaboratorio1.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Memoir {
    private final String id;
    private final String name;
    private final String group;

    public Memoir(String name, String group) {
        this.name = name;
        this.group = group;
        this.id = name + LocalDateTime.now();
    }
}
