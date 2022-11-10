package com.example.geek_for_less.patterns.dependency_injection;

import com.example.geek_for_less.patterns.dependency_injection.factory.AbstractFactory;
import com.example.geek_for_less.patterns.dependency_injection.factory.DIFactory;
import com.example.geek_for_less.patterns.dependency_injection.service.DBIntegrationService;
import com.example.geek_for_less.patterns.dependency_injection.service.FileIntegrationService;

public class AppDI {
    public static void main(String[] args) {
        AbstractFactory factory = new DIFactory();
        FileIntegrationService fileIntegrationService = factory.create(FileIntegrationService.class);

        fileIntegrationService.getFileNameByPath("D:\\Документы Олега\\DDOS attacks.txt");
        DBIntegrationService dbIntegrationService = factory.create(DBIntegrationService.class);
        dbIntegrationService.getClientByName("Oleg");
        dbIntegrationService.getUserById("100");
    }
}
