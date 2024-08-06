package com.sakilatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class NavigationTests {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

    @Test
    public void navigateFromActorDetailsToFilmDetails() {
        String url = "http://localHost:5173/actors/1";
        driver.get(url);
        WebElement firstFilmLink = driver.findElement(By.cssSelector(".film-list li a"));
        // Capture the film title from the list
        String expectedFilmTitle = firstFilmLink.getText().split("\\(")[0].trim();
        System.out.println("Expected Film Title: " + expectedFilmTitle);

        // Click the first film link to navigate to the film details page
        firstFilmLink.click();

        // Wait for the film detail page to load and verify the film title
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

        // Capture the film title displayed on the film details page
        WebElement filmTitleElement = driver.findElement(By.cssSelector("h1"));
        String actualFilmTitle = filmTitleElement.getText().split("\\(")[0].trim();
        System.out.println("Actual Film Title: " + actualFilmTitle);

        // Assert that the actual film title matches the expected title
        Assert.assertEquals(actualFilmTitle, expectedFilmTitle, "Correct film details page is displayed");
    }

    @Test
    public void navigateFromFilmDetailsToActorDetails() {
        String url = "http://localHost:5173/films/1";
        driver.get(url);
        WebElement firstActorLink = driver.findElement(By.cssSelector(".actor-list li a"));
        // Capture the actor name from the list
        String expectedActorName = firstActorLink.getText().split("\\(")[0].trim();
        System.out.println("Expected Actor Name: " + expectedActorName);

        // Click the first actor link to navigate to the actor details page
        firstActorLink.click();

        // Wait for the actor detail page to load and verify the actor name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

        // Capture the actor name displayed on the actor details page
        WebElement actorNameElement = driver.findElement(By.cssSelector("h1"));
        String actualActorName = actorNameElement.getText().split("\\(")[0].trim();
        System.out.println("Actual Actor Name: " + actualActorName);

        // Assert that the actual actor name matches the expected name
        Assert.assertEquals(actualActorName, expectedActorName, "Correct actor details page is displayed");
    }

    @Test
    public void testInvalidUrlNavigation() {
        // Navigate to the invalid URL
        String invalidUrl = "http://localhost:5173/gsgsgrsgrs";
        driver.get(invalidUrl);

        // Wait for the 404 error page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));

        // Check if the correct error page is displayed
        String errorMessage = driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals(errorMessage, "404", "The error page is not displayed correctly.");

        // Optionally, verify the presence of other elements, like the button
        String buttonText = driver.findElement(By.cssSelector("button")).getText();
        Assert.assertEquals(buttonText, "Home", "The button text is not as expected.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
