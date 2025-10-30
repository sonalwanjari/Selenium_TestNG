package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertionTest {

    @Test
    public void checkPageTitleExact() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

            driver.get("https://www.linkedin.com/");
            System.out.println("Starting hard assertion test (exact match)");

            String actualTitle = driver.getTitle();
            System.out.println("Actual Title: \"" + actualTitle + "\"");

            String expectedTitle = "LinkedIn: Log In or Sign Up";

            Assert.assertEquals(actualTitle, expectedTitle, "Page title did not exactly match expected");

            System.out.println("Exact title assertion passed, test continued...");

            driver.quit();

    }
}
