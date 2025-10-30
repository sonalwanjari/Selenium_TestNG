package SeleniumDemos.HandlingKeybasedCommandsTypesofWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args) {

        // Set ChromeDriver path
        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver(); // Open Chrome Browser

        // Open practice site
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Locate the textbox and type "ind"
        WebElement country = driver.findElement(By.id("autocomplete"));
        country.sendKeys("Unite");

        // Wait until India option is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement select = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/div[text()='United Kingdom (UK)']"))
                //got help from internet, search - "how to select value from drop-down"
        );

        // Click
        select.click();
    }
}
