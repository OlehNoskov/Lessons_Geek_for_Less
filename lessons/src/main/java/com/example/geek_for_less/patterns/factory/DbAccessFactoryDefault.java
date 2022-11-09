package com.example.geek_for_less.patterns.factory;

import com.example.geek_for_less.patterns.facade.first_example.service.DbConnectionService;
import com.example.geek_for_less.patterns.facade.first_example.service.DbServiceConnectionMySql;
import com.example.geek_for_less.patterns.proxy.service.SQLQueryService;
import com.example.geek_for_less.patterns.proxy.service.SQLServiceGeneric;

/**
 * Implementation DbAccessFactory
 * **/

public class DbAccessFactoryDefault implements DbAccessFactory {
    @Override
    public DbConnectionService dbConnectionService() {
         return new DbServiceConnectionMySql();
    }

    @Override
    public SQLQueryService sqlQueryService() {
        return new SQLServiceGeneric();
    }
}