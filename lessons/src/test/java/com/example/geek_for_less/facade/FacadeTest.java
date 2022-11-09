package com.example.geek_for_less.facade;

import com.example.geek_for_less.patterns.facade.first_example.DbAccessServiceFacade;
import com.example.geek_for_less.patterns.facade.first_example.DbAccessService;
import com.example.geek_for_less.patterns.facade.first_example.service.DbConnectionService;
import com.example.geek_for_less.patterns.facade.first_example.service.DbServiceConnectionMySql;
import com.example.geek_for_less.patterns.proxy.service.SQLQueryService;
import com.example.geek_for_less.patterns.proxy.service.SQLServiceGeneric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class FacadeTest {
    private static final String EXPECTED_RESULT = "result of getting by id sql = SELECT * FROM users WHERE id = randomId";

    private static final String ID = "randomId";

    @Test
    public void happyPath() {
        SQLQueryService sqlQueryService = new SQLServiceGeneric();
        DbConnectionService dbConnectionService = new DbServiceConnectionMySql();

        DbAccessService dbAccessService = new DbAccessServiceFacade(sqlQueryService, dbConnectionService);
        String result = dbAccessService.userById(ID);
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void happyMock() {
        SQLQueryService sqlQueryService = new SQLServiceGeneric();
        // This is simplified way to create complex object required for test

        DbConnectionService dbConnectionService = mock(DbConnectionService.class);
        Mockito.when(dbConnectionService.invokeSql(anyString())).thenReturn("result of getting by id sql  = SELECT * FROM users WHERE id = randomId");

        // end of complex object initialization

        DbAccessService dbAccessService = new DbAccessServiceFacade(sqlQueryService, dbConnectionService);
        String result = dbAccessService.userById(ID);
        verify(dbConnectionService, times(1)).invokeSql(eq("SELECT * FROM users WHERE id = randomId"));
    }
}