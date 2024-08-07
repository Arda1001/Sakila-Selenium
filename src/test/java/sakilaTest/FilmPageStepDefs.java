package sakilaTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static sakilaTest.CommonStepDefs.driver;

public class FilmPageStepDefs {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @And("types the name of a film")
    public void typesTheNameOfAFilm() {
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.sendKeys("Academy Dinosaur");
    }

    @Then("the correct film should be displayed")
    public void theCorrectFilmShouldBeDisplayed() {
        driver.findElement(By.xpath("//li/a[text()[contains(.,'ACADEMY DINOSAUR')]]"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/films"), "Can search for a film");
    }

    @And("the user enters valid film details")
    public void theUserEntersValidFilmDetails() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
        WebElement titleInput = driver.findElement(By.id("title"));
        titleInput.clear();
        titleInput.sendKeys("The Matrix");

        WebElement descriptionInput = driver.findElement(By.id("description"));
        descriptionInput.clear();
        descriptionInput.sendKeys("A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.");

        WebElement releaseYearInput = driver.findElement(By.id("releaseYear"));
        releaseYearInput.clear();
        releaseYearInput.sendKeys("1999");

        WebElement rentalDurationInput = driver.findElement(By.id("rentalDuration"));
        rentalDurationInput.clear();
        rentalDurationInput.sendKeys("3");

        WebElement rentalRateInput = driver.findElement(By.id("rentalRate"));
        rentalRateInput.clear();
        rentalRateInput.sendKeys("2.99");

        WebElement lengthInput = driver.findElement(By.id("length"));
        lengthInput.clear();
        lengthInput.sendKeys("136");

        WebElement replacementCostInput = driver.findElement(By.id("replacementCost"));
        replacementCostInput.clear();
        replacementCostInput.sendKeys("19.99");

        WebElement ratingInput = driver.findElement(By.id("rating"));
        ratingInput.sendKeys("R");

        Select specialFeaturesSelect = new Select(driver.findElement(By.id("specialFeatures")));
        specialFeaturesSelect.selectByVisibleText("Behind The Scenes");
        driver.findElement(By.cssSelector(".btn-add")).click();
        specialFeaturesSelect.selectByVisibleText("Trailers");
        driver.findElement(By.cssSelector(".btn-add")).click();

        Select languageSelect = new Select(driver.findElement(By.id("languageId")));
        languageSelect.selectByVisibleText("English");

        Select originalLanguageSelect = new Select(driver.findElement(By.id("originalLanguageId")));
        originalLanguageSelect.selectByVisibleText("English");

        Select actorSelect = new Select(driver.findElement(By.id("castIds")));
        actorSelect.selectByVisibleText("PENELOPE GUINESS");
        driver.findElement(By.cssSelector(".btn-add")).click();
        actorSelect.selectByVisibleText("ED CHASE");
        driver.findElement(By.cssSelector(".btn-add")).click();

    }

    @Then("the film should be added to the film list")
    public void theFilmShouldBeAddedToTheFilmList() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/films"), "Can create a film");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-bar")));
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.click();
        searchInput.sendKeys("The Matrix");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(., 'THE MATRIX')]]")
        ));
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/films"), "Can search for created film");
    }

    @And("the user leaves the film details blank")
    public void theUserLeavesTheFilmDetailsBlank() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
        WebElement titleInput = driver.findElement(By.id("title"));
        titleInput.clear();

        WebElement submitButton = driver.findElement(By.cssSelector(".create-button"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/films/create"), "The URL is correct");

        titleInput.sendKeys("The Matrix");
        WebElement descriptionInput = driver.findElement(By.id("description"));
        descriptionInput.clear();
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/films/create"), "The URL is correct");
    }

    @Then("the film form should not be submitted")
    public void theFilmFormShouldNotBeSubmitted() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/films/create";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @And("the user enters invalid release year")
    public void theUserEntersInvalidReleaseYear() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
        WebElement titleInput = driver.findElement(By.id("title"));
        titleInput.clear();
        titleInput.sendKeys("The Matrix");

        WebElement submitButton = driver.findElement(By.cssSelector(".create-button"));

        WebElement descriptionInput = driver.findElement(By.id("description"));
        descriptionInput.clear();
        descriptionInput.sendKeys("A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.");

        WebElement releaseYearInput = driver.findElement(By.id("releaseYear"));
        releaseYearInput.clear();
        releaseYearInput.sendKeys("2122");
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/films/create"), "The URL is correct");

        releaseYearInput.clear();
        releaseYearInput.sendKeys("1765");
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/films/create"), "The URL is correct");

    }
}
