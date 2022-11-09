package com.example.geek_for_less.patterns.facade.first_example;

import com.example.geek_for_less.patterns.facade.first_example.service.DbConnectionService;
import com.example.geek_for_less.patterns.proxy.service.SQLQueryService;

public class DbAccessServiceFacade implements DbAccessService {

    private SQLQueryService sqlQueryService;
    private DbConnectionService dbConnectionService;

    public DbAccessServiceFacade(SQLQueryService sqlQueryService, DbConnectionService dbConnectionService) {
        this.sqlQueryService = sqlQueryService;
        this.dbConnectionService = dbConnectionService;
    }

    @Override
    public String userById(String id) {
        String sql = sqlQueryService.constructSqlSearchUserById(id);
        return dbConnectionService.invokeSql(sql);
    }
}