package com.example.geek_for_less.patterns.facade;

import com.example.geek_for_less.patterns.facade.service.DbConnectionService;
import com.example.geek_for_less.patterns.facade.service.DbServiceConnectionMySql;
import com.example.geek_for_less.patterns.factory.AbstractFactory;
import com.example.geek_for_less.patterns.factory.DbAccessFactory;
import com.example.geek_for_less.patterns.proxy.service.SQLQueryService;
import com.example.geek_for_less.patterns.proxy.service.SQLServiceGeneric;

/**
 * Create facade via DbAccessFactoryDefault in the constructor
 **/

public class DbAccessServiceFacadeFactoryBased implements DbAccessService {

    private final SQLQueryService sqlQueryService;
    private final DbConnectionService dbConnectionService;

    public DbAccessServiceFacadeFactoryBased(DbAccessFactory dbAccessFactory) {
        // methods DbAccessFactory return instance implementation interfaces
        this.sqlQueryService = dbAccessFactory.sqlQueryService();
        this.dbConnectionService = dbAccessFactory.dbConnectionService();
    }

    // create object via AbstractFactory
    public DbAccessServiceFacadeFactoryBased(AbstractFactory abstractFactory) {
        this.dbConnectionService = abstractFactory.create(DbConnectionService.class);
        this.sqlQueryService = abstractFactory.create(SQLQueryService.class);
    }

    @Override
    public String userById(String id) {
        String sql = sqlQueryService.constructSqlSearchUserById(id);
        return dbConnectionService.invokeSql(sql);
    }
}