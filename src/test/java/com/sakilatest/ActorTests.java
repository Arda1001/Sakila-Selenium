package com.sakilatest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActorTests {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver.manage().window().maximize();
    }

    @Test
    public void displayAllActorsTest() {
        String url = "http://localHost:5173/";
        driver.get(url);
        driver.findElement(By.linkText("Actors")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void displayActorDetailsTest() {
        String url = "http://localhost:5173/actors";
        driver.get(url);
        // Wait for the actor list to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".actor-list")));
        // Use XPath to find the link for Ed Chase by text
        WebElement actorLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(.,'PENELOPE')]][text()[contains(.,'GUINESS')]]")
        ));
        actorLink.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/actors/"), "Navigated to the actor's detail page");
    }

    @Test
    public void searchActorTest() {
        String url = "http://localhost:5173/actors";
        driver.get(url);
        // Wait for the actor list to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-bar")));
        // Locate the search input using CSS Selector
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.click();
        searchInput.sendKeys("Ed Chase");
        // Use XPath to find the link for Ed Chase by text
        WebElement actorLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(.,'ED')]][text()[contains(.,'CHASE')]]")
        ));
        actorLink.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/actors/"), "Navigated to the actor's detail page");
    }

    @Test
    public void createActorTest() {
        String url = "http://localhost:5173/actors";
        driver.get(url);
        // Wait for the actor list to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".create-button")));
        // Locate the create actor button using CSS Selector
        WebElement createActorButton = driver.findElement(By.cssSelector(".create-button"));
        createActorButton.click();
        // Locate the first name input using CSS Selector
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.click();
        firstNameInput.sendKeys("John");
        // Locate the last name input using CSS Selector
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.click();
        lastNameInput.sendKeys("Doe");
        // Locate the save button using CSS Selector
        WebElement saveButton = driver.findElement(By.cssSelector(".create-button"));
        saveButton.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-bar")));
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.click();
        searchInput.sendKeys("John Doe");
        // Use XPath to find the link for John Doe by text
        WebElement actorLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(.,'JOHN')]][text()[contains(.,'DOE')]]")
        ));
        actorLink.click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/actors/"), "Navigated to the actor's detail page");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
