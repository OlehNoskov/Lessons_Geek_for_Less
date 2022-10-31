package com.example.geek_for_less.patterns.proxy.proxy;

import com.example.geek_for_less.patterns.proxy.service.SQLQueryService;

import java.util.HashMap;
import java.util.Map;

public class SQLQueryServiceProxy implements SQLQueryService {

    private final SQLQueryService sqlQueryService;
    private static final Map<String, String> CACHE = new HashMap<>();

    public SQLQueryServiceProxy(SQLQueryService sqlQueryService) {
        this.sqlQueryService = sqlQueryService;
    }

    @Override
    public String constructSqlSearchUserById(String id) {
        //Do some additional staff
        System.out.println("User id called " + id);

        //call real method
        String sql = CACHE.get(id);
        if (sql == null) {
            String realSql = sqlQueryService.constructSqlSearchUserById(id);
            CACHE.put(id, realSql);
            return realSql;
        }
        return sql;
    }
}