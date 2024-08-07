package sakilaTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class ActorPageStepDefs {

    private final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        driver.get("http://localhost:5173/");
    }

    @When("the user clicks on the Actors link")
    public void theUserClicksOnTheActorsLink() {
        driver.findElement(By.linkText("Actors")).click();
    }

    @Then("the user should be taken to the Actor page")
    public void theUserShouldBeTakenToTheActorPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:5173/actors", currentUrl);
    }

    @And("the user should see a list of actors")
    public void theUserShouldSeeAListOfActors() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".actor-list")));
        List<WebElement> actorList = driver.findElements(By.cssSelector(".actor-list li"));
        Assert.assertFalse(actorList.isEmpty(), "The actor list is not empty");
    }
}
