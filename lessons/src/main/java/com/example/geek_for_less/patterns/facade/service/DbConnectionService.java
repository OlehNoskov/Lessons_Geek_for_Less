package com.example.geek_for_less.patterns.facade.service;

public interface DbConnectionService {
    String invokeSql(String sql);
}