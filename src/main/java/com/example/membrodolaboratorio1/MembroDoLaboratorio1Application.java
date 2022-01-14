package com.example.membrodolaboratorio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.example"}, exclude = {DataSourceAutoConfiguration.class })
public class MembroDoLaboratorio1Application {

    public static void main(String[] args) {
        SpringApplication.run(MembroDoLaboratorio1Application.class, args);
    }
}
