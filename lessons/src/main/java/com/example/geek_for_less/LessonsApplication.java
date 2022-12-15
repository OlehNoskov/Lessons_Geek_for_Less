package com.example.geek_for_less;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// EnableScheduling guarantees, that background tasks will be created
@EnableScheduling
// Start SpringBootApplication
@SpringBootApplication
public class LessonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessonsApplication.class, args);
    }
}