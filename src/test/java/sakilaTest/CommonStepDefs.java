package sakilaTest;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonStepDefs {

    public static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void  tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        driver.get("http://localhost:5173/");
    }

    @When("the user clicks on the search bar")
    public void theUserClicksOnTheSearchBar() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBar")));
        WebElement searchInput = driver.findElement(By.id("searchBar"));
        searchInput.click();
    }

    @Then("a success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @And("the user submits the form")
    public void theUserSubmitsTheForm() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("createButton")));
        WebElement createButton = driver.findElement(By.id("createButton"));
        createButton.click();
    }

    @When("the user clicks on the create button")
    public void theUserClicksOnTheCreateButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".create-button")));
        WebElement createButton = driver.findElement(By.cssSelector(".create-button"));
        createButton.click();
    }
}
