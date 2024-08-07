package com.sakilatest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FilmTests {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver.manage().window().maximize();
    }

    @Test
    public void displayAllFilmsTest() {
        String url = "http://localHost:5173/";
        driver.get(url);
        driver.findElement(By.linkText("Films")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/films";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @Test
    public void displayFilmDetailsTest() {
        String url = "http://localhost:5173/films";
        driver.get(url);
        // Wait for the film list to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".film-list")));
        // Use XPath to find the link for the film with title "ACADEMY DINOSAUR"
        WebElement filmLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(.,'ACADEMY DINOSAUR')]]")
        ));
        filmLink.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/films/"), "Navigated to the film's detail page");
    }

    @Test
    public void searchFilmTest() {
        String url = "http://localhost:5173/films";
        driver.get(url);
        // Wait for the film list to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-bar")));
        // Locate the search input using CSS Selector
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.click();
        searchInput.sendKeys("Academy Dinosaur");
        // Use XPath to find the link for the film with title "ACADEMY DINOSAUR"
        WebElement filmLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(.,'ACADEMY DINOSAUR')]]")
        ));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/films"), "Can search for a film");
    }

    @Test
    public void createFilmWithValidDataTest() {
        String url = "http://localhost:5173/films";
        driver.get(url);

        // Wait for the film list to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".create-button")));

        // Locate the create film button using CSS Selector
        WebElement createFilmButton = driver.findElement(By.cssSelector(".create-button"));
        createFilmButton.click();

        // Fill out the form with valid data
        WebElement titleInput = driver.findElement(By.id("title"));
        titleInput.clear();  // Clear default value
        titleInput.sendKeys("Selenium Film");

        WebElement descriptionInput = driver.findElement(By.id("description"));
        descriptionInput.clear();  // Clear default value
        descriptionInput.sendKeys("A selenium film.");

        WebElement releaseYearInput = driver.findElement(By.id("releaseYear"));
        releaseYearInput.clear();  // Clear default value
        releaseYearInput.sendKeys("2021");

        WebElement rentalDurationInput = driver.findElement(By.id("rentalDuration"));
        rentalDurationInput.clear();  // Clear default value
        rentalDurationInput.sendKeys("5");

        WebElement rentalRateInput = driver.findElement(By.id("rentalRate"));
        rentalRateInput.clear();  // Clear default value
        rentalRateInput.sendKeys("4.99");

        WebElement lengthInput = driver.findElement(By.id("length"));
        lengthInput.clear();  // Clear default value
        lengthInput.sendKeys("120");

        WebElement replacementCostInput = driver.findElement(By.id("replacementCost"));
        replacementCostInput.clear();  // Clear default value
        replacementCostInput.sendKeys("19.99");

        // Select a rating from the dropdown
        Select ratingSelect = new Select(driver.findElement(By.id("rating")));
        ratingSelect.selectByVisibleText("PG-13");

        // Add special feature
        Select specialFeatureSelect = new Select(driver.findElement(By.id("specialFeatures")));
        specialFeatureSelect.selectByVisibleText("Behind The Scenes");
        driver.findElement(By.cssSelector(".btn-add")).click();
        specialFeatureSelect.selectByVisibleText("Trailers");
        driver.findElement(By.cssSelector(".btn-add")).click();

        // Select a language from the dropdown
        Select languageSelect = new Select(driver.findElement(By.id("languageId")));
        languageSelect.selectByVisibleText("English");

        // Select an original language from the dropdown
        Select originalLanguageSelect = new Select(driver.findElement(By.id("originalLanguageId")));
        originalLanguageSelect.selectByVisibleText("French");

        // Add actor
        Select actorSelect = new Select(driver.findElement(By.id("castIds")));
        actorSelect.selectByVisibleText("PENELOPE GUINESS");
        driver.findElement(By.cssSelector(".btn-add")).click();
        actorSelect.selectByVisibleText("ED CHASE");
        driver.findElement(By.cssSelector(".btn-add")).click();


        // Submit the form
        driver.findElement(By.cssSelector(".create-button")).click();

        // Handle the alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Verify redirection to the films list page
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/films";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");

        // Verify the created film appears in the list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-bar")));
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.sendKeys("Selenium Film");

        // Use XPath to find the link for the created film by text
        WebElement filmLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()='SELENIUM FILM']")
        ));
        filmLink.click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/films/"), "Can search for created film");
    }

    @Test
    public void createFilmWithEmptyFieldsTest() {
        // Navigate to the film creation page
        driver.get("http://localhost:5173/films");

        // Wait for the create film button to be visible and click it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".create-button")));
        WebElement createFilmButton = driver.findElement(By.cssSelector(".create-button"));
        createFilmButton.click();

        // Attempt to submit form with empty title
        WebElement titleInput = driver.findElement(By.id("title"));
        titleInput.clear();

        WebElement submitButton = driver.findElement(By.cssSelector(".create-button"));
        submitButton.click();

        // Verify that the form is not submitted and user stays on the same page
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:5173/films/create");

        // Fill title, attempt to submit with empty description
        titleInput.sendKeys("Valid Title");
        WebElement descriptionInput = driver.findElement(By.id("description"));
        descriptionInput.clear();
        submitButton.click();

        // Verify that the form is not submitted due to empty description
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:5173/films/create");
    }

    @Test
    public void createFilmWithInvalidReleaseYearTest() {
        // Navigate to the film creation page
        driver.get("http://localhost:5173/films");

        // Wait for the create film button to be visible and click it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".create-button")));
        WebElement createFilmButton = driver.findElement(By.cssSelector(".create-button"));
        createFilmButton.click();

        // Fill valid data for title and description
        WebElement titleInput = driver.findElement(By.id("title"));
        titleInput.clear();
        titleInput.sendKeys("Valid Title");

        WebElement descriptionInput = driver.findElement(By.id("description"));
        descriptionInput.clear();
        descriptionInput.sendKeys("Valid Description");

        WebElement submitButton = driver.findElement(By.cssSelector(".create-button"));

        // Test invalid release year (after 2100)
        WebElement releaseYearInput = driver.findElement(By.id("releaseYear"));
        releaseYearInput.clear();
        releaseYearInput.sendKeys("2101");
        submitButton.click();

        // Ensure form is not submitted due to invalid release year
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:5173/films/create");

        // Test invalid release year (before 1900)
        releaseYearInput.clear();
        releaseYearInput.sendKeys("1899");
        submitButton.click();

        // Ensure form is not submitted due to invalid release year
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:5173/films/create");

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
