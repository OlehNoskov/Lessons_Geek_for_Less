package com.example.geek_for_less.factory;

import com.example.geek_for_less.patterns.facade.first_example.DbAccessService;
import com.example.geek_for_less.patterns.facade.first_example.DbAccessServiceFacadeFactoryBased;
import com.example.geek_for_less.patterns.factory.AbstractFactory;
import com.example.geek_for_less.patterns.factory.DbAccessFactory;
import com.example.geek_for_less.patterns.factory.DbAccessFactoryDefault;

import com.example.geek_for_less.patterns.factory.SimpleAbstractFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryTest {
    private static final String EXPECTED_RESULT = "result of getting by id sql = SELECT * FROM users WHERE id = randomId";

    private static final String ID = "randomId";

    @Test
    public void happyPath() {
        // Create object Factory
        DbAccessFactory dbAccessFactory = new DbAccessFactoryDefault();
        DbAccessService dbAccessService = new DbAccessServiceFacadeFactoryBased(dbAccessFactory);
        String result = dbAccessService.userById(ID);

        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void happyPathAbstractFactory() {
        // Create object AbstractFactory
        AbstractFactory abstractFactory = new SimpleAbstractFactory();
        DbAccessService dbAccessService = new DbAccessServiceFacadeFactoryBased(abstractFactory);
        String result = dbAccessService.userById(ID);

        assertEquals(EXPECTED_RESULT, result);
    }
}
