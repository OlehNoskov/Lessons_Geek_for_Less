package com.example.geek_for_less.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
// You need this dependency: spring-boot-configuration-processor
// To working you have to add getters and setters for fields from properties file
@ConfigurationProperties(prefix = "demo.test.string")
public class DemoServiceImpl implements DemoService {

//    @Value(value = "Hello Oleg!")
//    @Value(value = "${demo.test.string:Hello!}")
//    private String demoString;

    private String demo;
    private String demo2;

    @Override
    public String getDemoString() {
        return demo2;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public String getDemo2() {
        return demo2;
    }

    public void setDemo2(String demo2) {
        this.demo2 = demo2;
    }
}