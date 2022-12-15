package com.example.geek_for_less.controller;

import com.example.geek_for_less.service.DemoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping(path = "/api/demo/value")
    public ResponseEntity<String> getDemoString() {
        return ResponseEntity.ok(demoService.getDemoString());
    }
}