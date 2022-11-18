package com.example.geek_for_less.web_driver_selenium.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactoryChromeDriver implements WebDriverFactory {

    // Set System.setProperty for chrome driver and specify path for chromedriver.exe file
    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe ");
    }

    @Override
    public WebDriver create() {
        ChromeOptions chromeOptions = new ChromeOptions();

        //Add arguments into  chromeOptions: It will be opened in maximum size
        chromeOptions.addArguments("start-maximized");

        // First way
        // for proxy Chrome driver object example addArguments
//        chromeOptions.addArguments("--proxy-server-<username>:<password>@<host>:<port>");

        // Second way
        //Map includes preferences settings for gadgets or desktop version
//        Map<String, Object> pref = new HashMap<>();
//        pref.put("deviceName", "iPhone X");
//        pref.put("deviceSamsung", "Samsung Galaxy S20+");
        // SetExperimentalOption is working only for Google Chrome!!!
//        chromeOptions.setExperimentalOption("mobileEmulation", pref);

        return new ChromeDriver(chromeOptions);
    }
}