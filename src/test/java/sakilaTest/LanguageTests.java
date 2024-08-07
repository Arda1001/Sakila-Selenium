package sakilaTest;

import org.openqa.selenium.Alert;
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
import java.util.List;

public class LanguageTests {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver.manage().window().maximize();
    }

    @Test
    public void displayAllLanguagesTest() {
        String url = "http://localHost:5173/";
        driver.get(url);
        driver.findElement(By.linkText("Languages")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/languages";
        Assert.assertEquals(currentUrl, expectedUrl, "The URL is correct");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".language-list")));
        List<WebElement> languageList = driver.findElements(By.cssSelector(".language-list li"));
        Assert.assertFalse(languageList.isEmpty(), "The language list is not empty");
    }

    @Test
    public void searchLanguageTest() {
        String url = "http://localhost:5173/languages";
        driver.get(url);
        // Wait for the actor list to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-bar")));
        // Locate the search input using CSS Selector
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.click();
        searchInput.sendKeys("German");
        // Use XPath to find the link for German by text
        driver.findElement(By.xpath("//li[text()[contains(.,'GERMAN')]]"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/languages"), "Can search for a language");
    }

    @Test
    public void createLanguageTest() {
        String url = "http://localhost:5173/languages";
        driver.get(url);
        // Wait for the actor list to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".create-button")));
        // Locate the create actor button using CSS Selector
        WebElement createLanguageButton = driver.findElement(By.cssSelector(".create-button"));
        createLanguageButton.click();
        driver.findElement(By.id("name")).sendKeys("Selenium");
        driver.findElement(By.cssSelector(".create-button")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/languages"), "Can create a language");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-bar")));
        WebElement searchInput = driver.findElement(By.cssSelector(".search-bar"));
        searchInput.click();
        searchInput.sendKeys("Selenium");
        // Use XPath to find the link for John Doe by text
        WebElement actorLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//li[text()[contains(., 'SELENIUM')]]")
        ));
        actorLink.click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/languages"), "Can search for created language");

    }

    @Test
    public void createLanguageWithEmptyNameTest() {
        // Navigate to the language creation page
        driver.get("http://localhost:5173/languages");

        // Wait for the create language button to be visible and click it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".create-button")));
        WebElement createLanguageButton = driver.findElement(By.cssSelector(".create-button"));
        createLanguageButton.click();

        // Attempt to submit form with empty name
        WebElement titleInput = driver.findElement(By.id("name"));
        titleInput.clear();

        WebElement submitButton = driver.findElement(By.cssSelector(".create-button"));
        submitButton.click();

        // Verify that the form is not submitted and user stays on the same page
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:5173/languages/create");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
