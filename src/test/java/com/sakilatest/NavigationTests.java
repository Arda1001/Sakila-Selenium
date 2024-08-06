package com.sakilatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationTests {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver.manage().window().maximize();
    }

    @Test
    public void navigateFromHomeToActors() {
        String url = "http://localHost:5173/";
        driver.get(url);
        driver.findElement(By.linkText("Actors")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromHomeToFilms() {
        String url = "http://localHost:5173/";
        driver.get(url);
        driver.findElement(By.linkText("Films")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/films";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromHomeToLanguages() {
        String url = "http://localHost:5173/";
        driver.get(url);
        driver.findElement(By.linkText("Languages")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/languages";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromHomeToHome() {
        String url = "http://localHost:5173/";
        driver.get(url);
        driver.findElement(By.linkText("Home")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromActorsToActors() {
        String url = "http://localHost:5173/actors";
        driver.get(url);
        driver.findElement(By.linkText("Actors")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromFilmsToFilms() {
        String url = "http://localHost:5173/films";
        driver.get(url);
        driver.findElement(By.linkText("Films")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/films";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromLanguagesToLanguages() {
        String url = "http://localHost:5173/languages";
        driver.get(url);
        driver.findElement(By.linkText("Languages")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/languages";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromActorsToHome() {
        String url = "http://localHost:5173/actors";
        driver.get(url);
        driver.findElement(By.linkText("Home")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromFilmsToHome() {
        String url = "http://localHost:5173/films";
        driver.get(url);
        driver.findElement(By.linkText("Home")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromLanguagesToHome() {
        String url = "http://localHost:5173/languages";
        driver.get(url);
        driver.findElement(By.linkText("Home")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromActorsToFilms() {
        String url = "http://localHost:5173/actors";
        driver.get(url);
        driver.findElement(By.linkText("Films")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/films";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromActorsToLanguages() {
        String url = "http://localHost:5173/actors";
        driver.get(url);
        driver.findElement(By.linkText("Languages")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/languages";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromFilmsToActors() {
        String url = "http://localHost:5173/films";
        driver.get(url);
        driver.findElement(By.linkText("Actors")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromFilmsToLanguages() {
        String url = "http://localHost:5173/films";
        driver.get(url);
        driver.findElement(By.linkText("Languages")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/languages";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromLanguagesToActors() {
        String url = "http://localHost:5173/languages";
        driver.get(url);
        driver.findElement(By.linkText("Actors")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromLanguagesToFilms() {
        String url = "http://localHost:5173/languages";
        driver.get(url);
        driver.findElement(By.linkText("Films")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/films";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromActorDetailsToActors() {
        String url = "http://localHost:5173/actors/1";
        driver.get(url);
        driver.findElement(By.linkText("Actors")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromActorDetailsToFilms() {
        String url = "http://localHost:5173/actors/1";
        driver.get(url);
        driver.findElement(By.linkText("Films")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/films";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromActorDetailsToLanguages() {
        String url = "http://localHost:5173/actors/1";
        driver.get(url);
        driver.findElement(By.linkText("Languages")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/languages";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromActorDetailsToHome() {
        String url = "http://localHost:5173/actors/1";
        driver.get(url);
        driver.findElement(By.linkText("Home")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromFilmDetailsToFilms() {
        String url = "http://localHost:5173/films/1";
        driver.get(url);
        driver.findElement(By.linkText("Films")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/films";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromFilmDetailsToActors() {
        String url = "http://localHost:5173/films/1";
        driver.get(url);
        driver.findElement(By.linkText("Actors")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromFilmDetailsToLanguages() {
        String url = "http://localHost:5173/films/1";
        driver.get(url);
        driver.findElement(By.linkText("Languages")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/languages";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void navigateFromFilmDetailsToHome() {
        String url = "http://localHost:5173/films/1";
        driver.get(url);
        driver.findElement(By.linkText("Home")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
