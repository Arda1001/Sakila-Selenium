package sakilaTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static sakilaTest.CommonStepDefs.driver;


public class LanguagePageStepDefs {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("the user clicks on the Languages link")
    public void theUserClicksOnTheLanguagesLink() {
        driver.findElement(By.linkText("Languages")).click();
    }

    @Then("the user should be taken to the Language page")
    public void theUserShouldBeTakenToTheLanguagePage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:5173/languages", "The URL is correct");
    }

    @And("the user should see a list of languages")
    public void theUserShouldSeeAListOfLanguages() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".language-list")));
        List<WebElement> languageList = driver.findElements(By.cssSelector(".language-list li"));
        assertFalse(languageList.isEmpty(), "The language list is not empty");
    }

    @Given("the user is on the language page")
    public void theUserIsOnTheLanguagePage() {
        driver.get("http://localhost:5173/languages");
    }

    @And("types the name of a language")
    public void typesTheNameOfALanguage() {
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.click();
        searchInput.sendKeys("German");
    }

    @Then("the correct language should be displayed")
    public void theCorrectLanguageShouldBeDisplayed() {
        driver.findElement(By.xpath("//li[text()[contains(.,'GERMAN')]]"));
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:5173/languages", "Can search for a language");
    }

    @When("the user clicks on the create language button")
    public void theUserClicksOnTheCreateLanguageButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".create-button")));
        WebElement createLanguageButton = driver.findElement(By.cssSelector(".create-button"));
        createLanguageButton.click();
    }

    @And("the user enters valid language details")
    public void theUserEntersValidLanguageDetails() {
        driver.findElement(By.id("name")).sendKeys("Selenium");
    }

    @Then("the language should be added to the language list")
    public void theLanguageShouldBeAddedToTheLanguageList() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:5173/languages", "Can create a language");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-bar")));
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.click();
        searchInput.sendKeys("Selenium");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li[text()[contains(., 'SELENIUM')]]")
        ));
        currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:5173/languages", "Can search for created language");
    }

    @And("the user leaves the language details blank")
    public void theUserLeavesTheLanguageDetailsBlank() {
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.clear();
    }

    @Then("the language form should not be submitted")
    public void theLanguageFormShouldNotBeSubmitted() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/languages/create";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
    }
}
