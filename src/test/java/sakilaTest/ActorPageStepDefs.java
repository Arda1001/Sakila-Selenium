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
import static sakilaTest.CommonStepDefs.driver;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class ActorPageStepDefs {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("the user is on the actor page")
    public void theUserIsOnTheActorPage() {
        driver.get("http://localhost:5173/actors");
    }

    @When("the user clicks on the Actors link")
    public void theUserClicksOnTheActorsLink() {
        driver.findElement(By.linkText("Actors")).click();
    }

    @When("the user clicks on an actor")
    public void theUserClicksOnAnActor() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".actor-list")));
        WebElement actorLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(.,'PENELOPE')]][text()[contains(.,'GUINESS')]]")
        ));
        actorLink.click();
    }

    @Then("the user should be taken to the Actor page")
    public void theUserShouldBeTakenToTheActorPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:5173/actors", currentUrl);
    }

    @Then("the user should be taken to the actor details page")
    public void theUserShouldBeTakenToTheActorDetailsPage() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/actors/"));
    }

    @Then("the correct actor should be displayed")
    public void theCorrectActorShouldBeDisplayed() {
        WebElement actorLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(.,'ED')]][text()[contains(.,'CHASE')]]")
        ));
        actorLink.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/actors/"), "Navigated to the actor's detail page");

    }

    @Then("the actor should be added to the actor list")
    public void theActorShouldBeAddedToTheActorList() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/actors"), "Can create an actor");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-bar")));
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.click();
        searchInput.sendKeys("John Doe");
        WebElement actorLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li/a[text()[contains(., 'JOHN')]][text()[contains(., 'DOE')]]")
        ));
        actorLink.click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/actors"), "Can search for created actor");
    }

    @Then("the actor form should not be submitted")
    public void theActorFormShouldNotBeSubmitted() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/actors/create";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }

    @And("the user should see a list of actors")
    public void theUserShouldSeeAListOfActors() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".actor-list")));
        List<WebElement> actorList = driver.findElements(By.cssSelector(".actor-list li"));
        Assert.assertFalse(actorList.isEmpty(), "The actor list is not empty");
    }


    @And("the user should see the actor details")
    public void theUserShouldSeeTheActorDetails() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".film-list")));
        List<WebElement> actorDetails = driver.findElements(By.cssSelector(".film-list li"));
        Assert.assertFalse(actorDetails.isEmpty(), "The actor details are not empty");
    }


    @And("types the name of an actor")
    public void typesTheNameOfAnActor() {
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.sendKeys("Ed Chase");
    }


    @And("the user enters valid actor details")
    public void theUserEntersValidActorDetails() {
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
    }



    @And("the user leaves the actor details blank")
    public void theUserLeavesTheActorDetailsBlank() {
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.clear();
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.clear();
    }
}
