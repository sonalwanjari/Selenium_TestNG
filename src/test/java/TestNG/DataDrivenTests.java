// DataDrivenTests.java
package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

/**
 * Simple Data Provider Examples
 * Shows how to run same test with different data
 */
public class DataDrivenTests {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 7a. dataProvider - creates test data
    @DataProvider(name = "searchData")
    public Object[][] getSearchTerms() {
        return new Object[][] {
                {"Java"},
                {"Selenium"},
                {"TestNG"}
        };
    }

    // 7b. Using the data provider - test runs 3 times with different data
    @Test(dataProvider = "searchData")
    public void searchTest(String searchTerm) {
        driver.get("https://www.google.com/ncr"); // /ncr helps avoid country redirect
        // Optional: handle consent dialog here if it appears

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        driver.findElement(By.name("q")).sendKeys(searchTerm);
        driver.findElement(By.name("q")).submit();

        // wait until title contains search term
        wait.until(ExpectedConditions.titleContains(searchTerm));

        Assert.assertTrue(driver.getTitle().toLowerCase().contains(searchTerm.toLowerCase()),
                "Title does not contain search term: " + searchTerm);
        System.out.println("Searched for: " + searchTerm);
    }

    // 7c. dataProviderClass - using external data provider
    @Test(dataProvider = "externalData", dataProviderClass = DataProvider.class)
    public void externalDataTest(String data) {
        driver.get("https://www.google.com/ncr");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        driver.findElement(By.name("q")).sendKeys(data);
        driver.findElement(By.name("q")).submit();
        wait.until(ExpectedConditions.titleContains(data));
        System.out.println("Testing with external data: " + data);
    }

    @AfterMethod
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }
}
