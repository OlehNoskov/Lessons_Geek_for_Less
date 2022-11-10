package com.example.geek_for_less.patterns.dependency_injection.service;

import java.io.File;

public class FileIntegrationServiceImpl implements FileIntegrationService {
    @Override
    public String getFileNameByPath(String path) {
        File f = new File(path);
        System.out.println(f.getName());
        return f.getName();
    }
}