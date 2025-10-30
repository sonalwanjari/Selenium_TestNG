package TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
public class TestAnnotations {
    WebDriver driver;
    @BeforeTest
    public void browserSetup()
    {
        System.out.println("BeforeTest: Setting up WebDriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void navigateURL()
    {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("Before Method: Navigation Successful");
    }
    @Test
    public void testWebsiteTitle() {
        System.out.println("Test 1: Checking title");
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
    }

    @Test
    public void testWebsiteURL() {
        System.out.println("Test 2: Checking URL");
        String url = driver.getCurrentUrl();
        System.out.println("Current URL is: " + url);
    }
    @AfterMethod
    public void clearSession()
    {
        driver.manage().deleteAllCookies();
        System.out.println("After method: Browser Cookies are cleared");
    }
    @AfterTest
    public void browserCloser()
    {
        System.out.println("After test: Browser Closed");
        if(driver != null) {
            driver.quit();
        }
    }
}
