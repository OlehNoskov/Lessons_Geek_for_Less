package com.example.geek_for_less.web_driver_selenium.service;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test describes opportunities WebDriver Selenium
 **/

public class WebDriverFactoryChromeDriverTest {

    @Test
    public void initChromeDriverTest() throws InterruptedException {
        WebDriverFactory webDriverFactory = new WebDriverFactoryChromeDriver();
        WebDriver webDriver = webDriverFactory.create();

        // Enter this link
        webDriver.get("http://info.cern.ch/");

        // List elements from page (CSS selector)
        List<WebElement> webElements = webDriver.findElements(By.cssSelector(" body > ul > li > a"));

        assertTrue(webElements.size() == 4);
        // Waiting 5 seconds for example, because it works fast
        TimeUnit.SECONDS.sleep(3L);

        // Choose first element from list webElements
        WebElement firstLink = webElements.get(0);
        // Click on this element
        firstLink.click();
        TimeUnit.SECONDS.sleep(3L);

        //Close this website
        webDriver.quit();
    }

    @Test
    public void checkSomeActions() throws InterruptedException {
        WebDriverFactory webDriverFactory = new WebDriverFactoryChromeDriver();
        WebDriver webDriver = webDriverFactory.create();

        // Chrome will be opened in maximum size
        webDriver.manage().window().maximize();

        // Enter this link
        webDriver.get("https://google.com/");

        TimeUnit.SECONDS.sleep(2L);
        // Find element on the page
        WebElement inputElement = webDriver.findElement(By.xpath(" //form//div[1]/div[2]/input"));

        // Press enter
        inputElement.sendKeys("rozetka");

        // Press enter
        inputElement.sendKeys(Keys.ENTER);

        // Find elements on the page for tags
        List<WebElement> links = webDriver.findElements(By.tagName("h3"));

        System.out.println(" Links size:" + links.size());

        links.get(0).click();

        WebElement notesAndPC = webDriver.findElement(By.xpath("//rz-top-page-banner//img"));
        notesAndPC.click();

        WebElement phone = webDriver.findElement(By.xpath("//section[1]/rz-grid/ul/li[1]//a[2]/span"));
        phone.click();

        webDriver.quit();
    }

    @Test
    public void testByLinkTest() throws InterruptedException {
        WebDriverFactory webDriverFactory = new WebDriverFactoryChromeDriver();
        WebDriver webDriver = webDriverFactory.create();

        webDriver.manage().window().maximize();

        // Enter this link
        webDriver.get("https://google.com/");

        TimeUnit.SECONDS.sleep(2L);
        // Find element on the page
        WebElement inputElement = webDriver.findElement(By.xpath(" //form//div[1]/div[2]/input"));
        inputElement.sendKeys("selenium webdriver download");
        inputElement.sendKeys(Keys.ENTER);

        List<WebElement> webElementList = webDriver.findElements(By.tagName("h3"));
        WebElement websiteSelenium = webElementList.get(0);
        websiteSelenium.click();

        WebElement documentation = webDriver.findElement(By.linkText("documentation"));
        documentation.click();

        webDriver.quit();
    }
}