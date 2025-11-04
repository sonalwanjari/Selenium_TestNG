package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

    private WebDriver driver;
    private final int testParam; // value provided by Factory

    // add a public constructor that accepts the int that FactoryDemo passes
    public SampleTest(int i) {
        this.testParam = i;
    }

    // also keep a no-arg constructor only if you need one; not required for Factory usage
    public SampleTest() {
        this.testParam = -1; // or some default
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
    }

    // remove DataProvider usage if Factory provides parameters
    @Test
    public void testMethod() {
        driver.get("https://www.google.com");
        System.out.println("param: " + testParam + " title: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
