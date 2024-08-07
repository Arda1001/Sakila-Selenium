package sakilaTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static sakilaTest.CommonStepDefs.driver;

public class NavigationStepDefs {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("the user clicks on the Films link")
    public void theUserClicksOnTheFilmsLink() {
        driver.findElement(By.linkText("Films")).click();
    }

    @Then("the user should be taken to the Film page")
    public void theUserShouldBeTakenToTheFilmPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:5173/films", "The URL is correct");
    }

    @And("the user should see a list of films")
    public void theUserShouldSeeAListOfFilms() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".film-list")));
        List<WebElement> filmList = driver.findElements(By.cssSelector(".film-list li"));
        assertFalse(filmList.isEmpty(), "The film list is not empty");
    }

    @When("the user clicks on the Home link")
    public void theUserClicksOnTheHomeLink() {
        driver.findElement(By.linkText("Home")).click();
    }

    @Then("the user should stay on the Home page")
    public void theUserShouldStayOnTheHomePage() {
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.linkText("Home")).click();
        assertEquals(currentUrl, "http://localhost:5173/", "The URL is correct");
    }

    @And("the user should see the home page")
    public void theUserShouldSeeTheHomePage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".home-container")));
        List<WebElement> homePage = driver.findElements(By.cssSelector(".home-container"));
        assertFalse(homePage.isEmpty(), "The home page is not empty");
    }

    @Then("the user should stay on the Actor page")
    public void theUserShouldStayOnTheActorPage() {
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.linkText("Actors")).click();
        assertEquals(currentUrl, "http://localhost:5173/actors", "The URL is correct");
    }

    @Given("the user is on the film page")
    public void theUserIsOnTheFilmPage() {
        driver.get("http://localhost:5173/films");
    }

    @Then("the user should stay on the Film page")
    public void theUserShouldStayOnTheFilmPage() {
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.linkText("Films")).click();
        assertEquals(currentUrl, "http://localhost:5173/films", "The URL is correct");
    }

    @Then("the user should stay on the Language page")
    public void theUserShouldStayOnTheLanguagePage() {
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.linkText("Languages")).click();
        assertEquals(currentUrl, "http://localhost:5173/languages", "The URL is correct");
    }

    @Then("the user should be taken to the home page")
    public void theUserShouldBeTakenToTheHomePage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:5173/", "The URL is correct");
    }

    @Given("the user is on the actor details page")
    public void theUserIsOnTheActorDetailsPage() {
        driver.get("http://localhost:5173/actors/1");
    }

    @Given("the user is on the film details page")
    public void theUserIsOnTheFilmDetailsPage() {
        driver.get("http://localhost:5173/films/1");
    }

    @When("the user clicks on a film")
    public void theUserClicksOnAFilm() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".film-list")));
        WebElement filmLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(.,'ACADEMY DINOSAUR')]]")
        ));
        filmLink.click();
    }

    @Then("the user should be taken to the film details page")
    public void theUserShouldBeTakenToTheFilmDetailsPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:5173/films/1", "The URL is correct");
    }

    @And("the user should see the film details")
    public void theUserShouldSeeTheFilmDetails() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".film-details")));
        List<WebElement> filmDetails = driver.findElements(By.cssSelector(".film-details p"));
        List<WebElement> cast = driver.findElements(By.cssSelector(".actor-list li"));
        Assert.assertFalse(filmDetails.isEmpty(), "The film details are not empty");
        Assert.assertFalse(cast.isEmpty(), "The cast list is not empty");
    }

    @Given("the user goes to an invalid url")
    public void theUserGoesToAnInvalidUrl() {
        driver.get("http://localhost:5173/invalid");
    }

    @Then("the user should see an error page")
    public void theUserShouldSeeAErrorPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        String errorMessage = driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals(errorMessage, "404", "The error page is not displayed correctly.");
        String buttonText = driver.findElement(By.cssSelector("button")).getText();
        Assert.assertEquals(buttonText, "Home", "The button text is not as expected.");
    }
}
