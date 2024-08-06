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
        driver.get("http://localhost:5173/actors");
        driver.findElement(By.linkText("Actors")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void displayActorDetailsTest() {
        driver.get("http://localhost:5173/actors");

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
        driver.get("http://localhost:5173/actors");

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
        driver.get("http://localhost:5173/actors");

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

        // Submit the form
        WebElement saveButton = driver.findElement(By.cssSelector(".create-button"));
        saveButton.click();

        // Wait for the alert to be present
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Verify that the actor was created
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");

        // Search for the created actor
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

    @Test
    public void createActorWithEmptyFieldsTest() {
        // Navigate to the actor creation page
        driver.get("http://localhost:5173/actors");

        // Wait for the create actor button to be visible and click it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".create-button")));
        WebElement createActorButton = driver.findElement(By.cssSelector(".create-button"));
        createActorButton.click();

        // Attempt to submit form with empty first name
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.clear();

        WebElement submitButton = driver.findElement(By.cssSelector(".create-button"));
        submitButton.click();

        // Verify that the form is not submitted and user stays on the same page
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:5173/actors/create");

        // Fill in the first name and attempt to submit form with empty last name
        firstNameInput.sendKeys("John");
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.clear();
        submitButton.click();

        // Verify that the form is not submitted due to empty last name
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:5173/actors/create");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
