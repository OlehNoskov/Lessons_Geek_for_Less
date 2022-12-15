package com.example.geek_for_less.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
//import org.springframework.beans.factory.annotation.Value;



@Service
// You need this dependency: spring-boot-configuration-processor
// To working you have to add getters and setters for fields from properties file
@ConfigurationProperties(prefix = "demo.test.string")
public class DemoServiceImpl implements DemoService {

//    @Value(value = "Hello Oleg!")
//    @Value(value = "${demo.test.string:Hello!}")
//    private String demoString;

    private final Logger LOGGER =  LoggerFactory.getLogger(DemoServiceImpl.class);
    private String demo;
    private String demo2;
    private String cron;

    @Override
    public String getDemoString() {
        return demo2;
    }

    // The task will be executed every second
    // @Scheduled(cron = "1 0 0 0 * ?")

    // (cron = "0(sec) 15(minutes) 10(hours) 15(days) *(month ) ?")
    // The task will be executed at 10:15 AM on the 15th day of every month
    // @Scheduled(cron = "0 15 10 15 * ?")
    // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html


    @Override
    @Async
    // @Scheduled(cron = "*/2 * * * * *")
    @Scheduled(cron = "${cron}")
    public void testSchedule() throws InterruptedException {
    // LOGGER.info("Testing schedule!");
        LOGGER.info(String.format("Testing schedule: %s", Thread.currentThread().getName()));
        TimeUnit.SECONDS.sleep(4);
        LOGGER.info(String.format("Finish  schedule: %s", Thread.currentThread().getName()));
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