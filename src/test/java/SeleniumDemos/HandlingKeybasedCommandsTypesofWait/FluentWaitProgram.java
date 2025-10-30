package SeleniumDemos.HandlingKeybasedCommandsTypesofWait;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitProgram {
    public static void main(String[] args) {

        // Set ChromeDriver path
        System.getProperty("webdriver.chrome.driver","C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver(); // Open Chrome Browser

        // Open practice site
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Locate the textbox and type partial text
        WebElement country = driver.findElement(By.id("autocomplete"));
        country.sendKeys("Unite");

        // Create FluentWait
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))   // maximum wait time
                .pollingEvery(Duration.ofSeconds(2))   // check every 2 seconds
                .ignoring(NoSuchElementException.class);

        // Wait until "United Kingdom (UK)" option is visible
        WebElement select = fluentWait.until(
                drv -> drv.findElement(By.xpath("//li/div[text()='United Kingdom (UK)']"))
        );

        // Click on the option
        select.click();

        System.out.println("Selected: United Kingdom (UK)");

        driver.quit();
    }
}
