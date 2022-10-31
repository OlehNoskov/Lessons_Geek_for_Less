package com.example.geek_for_less.patterns.facade;

import com.example.geek_for_less.patterns.facade.service.DbConnectionService;
import com.example.geek_for_less.patterns.proxy.service.SQLQueryService;

public class DbAccessFacade implements DbAccessService {
    private SQLQueryService sqlQueryService;
    private DbConnectionService dbConnectionService;

    public DbAccessFacade(SQLQueryService sqlQueryService, DbConnectionService dbConnectionService) {
        this.sqlQueryService = sqlQueryService;
        this.dbConnectionService = dbConnectionService;
    }

    @Override
    public String userById(String id) {
        String sql = sqlQueryService.constructSqlSearchUserById(id);
        return dbConnectionService.invokeSql(sql);
    }
}
