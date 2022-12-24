package com.example.geek_for_less.controller;

import com.example.geek_for_less.service.OkHttpClientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ok/http/test")
public class OkHttpClientController {

    private final OkHttpClientService okHttpClientService;

    public OkHttpClientController(OkHttpClientService okHttpClientService) {
        this.okHttpClientService = okHttpClientService;
    }

    @GetMapping("/get")
    public ResponseEntity<String> getData(){
        return ResponseEntity.ok(okHttpClientService.fetchData());
    }

    @PostMapping("/post")
    public ResponseEntity<String> postData(){
        return ResponseEntity.ok(okHttpClientService.sendData());
    }
}