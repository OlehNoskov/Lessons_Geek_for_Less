package com.example.geek_for_less.proxy;

import com.example.geek_for_less.patterns.proxy.proxy.SQLQueryServiceProxy;
import com.example.geek_for_less.patterns.proxy.service.SQLQueryService;
import com.example.geek_for_less.patterns.proxy.service.SQLServiceGeneric;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyTest {

    @Test
    public void happyPath() {
        SQLQueryService sqlQueryService = new SQLServiceGeneric();
        // real object
        assertEquals("SELECT * FROM users WHERE id = randomId", sqlQueryService.constructSqlSearchUserById("randomId"));

        sqlQueryService = new SQLQueryServiceProxy(sqlQueryService);
        // proxy object
        assertEquals("SELECT * FROM users WHERE id = randomId", sqlQueryService.constructSqlSearchUserById("randomId"));
    }
}