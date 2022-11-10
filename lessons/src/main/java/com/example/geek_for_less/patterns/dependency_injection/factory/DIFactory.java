package com.example.geek_for_less.patterns.dependency_injection.factory;

import com.example.geek_for_less.patterns.dependency_injection.service.DBIntegrationService;
import com.example.geek_for_less.patterns.dependency_injection.service.FileIntegrationService;
import com.example.geek_for_less.patterns.dependency_injection.service.FileIntegrationServiceImpl;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DIFactory implements AbstractFactory {
    private static final Map<Class, Object> context = new HashMap<>();

    @Override
    public <T> T create(Class<T> clazz) {
        if (FileIntegrationService.class.isAssignableFrom(clazz)) {
            Object object = context.get(clazz);
            if (object == null) {
                FileIntegrationService fileIntegrationService = new FileIntegrationServiceImpl();
                context.put(clazz, fileIntegrationService);
                return (T) fileIntegrationService;
            }
            return (T) (object);
        }

        if (DBIntegrationService.class.isAssignableFrom(clazz)) {
            return (T) getProxy(clazz);
        }
        return null;
    }

    private Object getProxy(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
            // constructSqlSearchUserById
            if (method.getName().startsWith("get")) {
                String param = (String) args[0];
                String tableNameAndParameter = method.getName().substring(3, method.getName().length());
                String[] tableNameParameter = tableNameAndParameter.split("By");
                String sql = String.format("SELECT * FROM %s where %s = %s", tableNameParameter[0].toLowerCase(), tableNameParameter[1].toLowerCase(), param);
                System.out.println(sql);
                return sql;
            }
            return null;
        });
    }
}