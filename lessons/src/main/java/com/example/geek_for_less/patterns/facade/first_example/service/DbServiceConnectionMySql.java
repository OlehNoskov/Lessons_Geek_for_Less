package com.example.geek_for_less.patterns.facade.first_example.service;

public class DbServiceConnectionMySql implements DbConnectionService{
    @Override
    public String invokeSql(String sql) {
        System.out.println("Setup connection...");
        return "result of getting by id sql = " + sql;
    }
}