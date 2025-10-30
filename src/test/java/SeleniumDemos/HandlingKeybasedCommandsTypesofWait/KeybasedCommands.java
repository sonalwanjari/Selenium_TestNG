package SeleniumDemos.HandlingKeybasedCommandsTypesofWait;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeybasedCommands {
    public static void main(String[] args) {
        // Set ChromeDriver path
        System.getProperty("webdriver.chrome.driver","C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver(); // Open Chrome Browser

        // Open practice site
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Find Country text box
        try {
            WebElement country = driver.findElement(By.id("autocomplete"));
            Actions action = new Actions(driver);
            action.keyDown(Keys.SHIFT).sendKeys(country, "India").keyUp(Keys.SHIFT).perform();
            Thread.sleep(3000);
            // Copy text
            action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
            Thread.sleep(3000);

            // Paste text
            action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
            Thread.sleep(3000);

            // Submit form using ENTER key
            country.sendKeys(Keys.ENTER);            Thread.sleep(3000);


            driver.quit();
        } catch (RuntimeException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
