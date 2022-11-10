package com.example.geek_for_less.patterns.dependency_injection.service;

public interface DBIntegrationService {
    // select * from user where ID = '33'
    String getUserById(String id);
    // select * from client where name = 'John'
    String getClientByName(String name);
}