package com.example.geek_for_less.patterns.factory;

import com.example.geek_for_less.patterns.facade.first_example.service.DbConnectionService;
import com.example.geek_for_less.patterns.proxy.service.SQLQueryService;

/**
* Example abstract factory
**/

public interface DbAccessFactory {
    DbConnectionService dbConnectionService();
    SQLQueryService sqlQueryService();
}