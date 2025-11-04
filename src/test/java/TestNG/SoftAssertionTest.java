package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Use headless for CI; remove headless when debugging locally if you want to see the browser
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkPageTitleExact() {
        driver.get("https://www.linkedin.com");

        SoftAssert soft = new SoftAssert();

        // actual title
        String actualTitle = driver.getTitle();

        // define expectedTitle variable so compilation succeeds
        String expectedTitle = "LinkedIn: Log In or Sign Up";

        // Strict exact-match assertion (will fail if text differs exactly)
        soft.assertEquals(actualTitle, expectedTitle, "Page title did not exactly match expected");

        // Alternative (more tolerant) — uncomment to use contains check instead
        // soft.assertTrue(actualTitle != null && actualTitle.contains("LinkedIn"), "Page title should contain 'LinkedIn'");

        // Report all soft assertion failures
        soft.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
