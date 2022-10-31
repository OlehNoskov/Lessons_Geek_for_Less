package com.example.geek_for_less.patterns.proxy.service;

public class SQLServiceGeneric implements SQLQueryService {

    @Override
    public String constructSqlSearchUserById(String id) {
        String sql = String.format("SELECT * FROM users WHERE id = %s", id);
        System.out.println(sql);
        return sql;
    }
}
