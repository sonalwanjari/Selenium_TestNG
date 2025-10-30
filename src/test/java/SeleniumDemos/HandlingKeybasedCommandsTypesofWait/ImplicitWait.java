package SeleniumDemos.HandlingKeybasedCommandsTypesofWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWait {
    public static void main(String[] args) {
        // Set ChromeDriver path
        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver(); // Open Chrome Browser

        // Open practice site
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement country = driver.findElement(By.id("autocomplete"));
        country.sendKeys("United ");
        System.out.println("Found Element >> " +country.getTagName());
        driver.quit();



    }

}
