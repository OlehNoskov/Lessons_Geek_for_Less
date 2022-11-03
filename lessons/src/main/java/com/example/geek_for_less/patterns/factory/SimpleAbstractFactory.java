package com.example.geek_for_less.patterns.factory;

import com.example.geek_for_less.patterns.facade.service.DbConnectionService;
import com.example.geek_for_less.patterns.facade.service.DbServiceConnectionMySql;
import com.example.geek_for_less.patterns.proxy.service.SQLQueryService;
import com.example.geek_for_less.patterns.proxy.service.SQLServiceGeneric;

public class SimpleAbstractFactory implements AbstractFactory{
    @Override
    public <T> T create(Class<T> clazz) {
        if (clazz.isAssignableFrom(DbConnectionService.class)){
            return (T) new DbServiceConnectionMySql();
        }
        if (clazz.isAssignableFrom(SQLQueryService.class)){
            return (T) new SQLServiceGeneric();
        }
        // default
        return null;
    }
}
