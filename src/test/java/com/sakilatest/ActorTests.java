package com.sakilatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void displayAllActorsTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://localHost:5173/";
        driver.get(url);
        driver.findElement(By.linkText("Actors")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localHost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
        driver.quit();
    }
}
