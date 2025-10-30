package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class NM {
    WebDriver driver;

    @BeforeTest
    public void setBrowser()
    {
        System.out.println("Browser setup");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void navigateURL()
    {
        driver.get("https://www.instagram.com/");
        System.out.println("Navigation success");
    }

    @AfterTest
    public void browserClose()
    {
        driver.quit();
    }

    @AfterMethod
    public void clearSession(){
        driver.manage().deleteAllCookies();
    }

    @Test
    public void Login()
    {
        System.out.println("Login successful");
    }

    @Test
    public void Logout()
    {
        System.out.println("Logout successful");
    }
}