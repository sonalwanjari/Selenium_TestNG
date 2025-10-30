package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationCountExample {

    WebDriver driver;

    @Test(invocationCount = 2)  // This test will run 2 times automatically
    public void openHomePageMultipleTimes() {
        // Create ChromeDriver instance
        driver = new ChromeDriver();

        // Open the practice page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Print the title
        System.out.println("Page Title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}

