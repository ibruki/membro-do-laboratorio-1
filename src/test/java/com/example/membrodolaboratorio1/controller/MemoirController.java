package com.example.membrodolaboratorio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MemoirController.class)
public class MemoirController {

    @Autowired
    private MockMvc mockMvc;

}
