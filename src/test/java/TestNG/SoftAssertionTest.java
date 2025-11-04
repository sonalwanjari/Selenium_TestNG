package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

public class SoftAssertionTest {

@Test
    public void checkPageTitleExact() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        SoftAssert softAssert = new SoftAssert();

        driver.get("https://www.linkedin.com/");
            System.out.println("Starting soft assertion test (exact match)");

            String actualTitle = driver.getTitle();
            System.out.println("Actual Title: \"" + actualTitle + "\"");

//String expectedTitle = "LinkedIn3ed: Log In or Sign Up";

        // before
//softAssert.assertEquals(actualTitle, "LinkedIn3ed: Log In or Sign Up");

// after
softAssert.assertEquals(actualTitle, "LinkedIn: Log In or Sign Up");


            // Soft assertion: will not stop execution even if it fails
            softAssert.assertEquals(actualTitle, expectedTitle,
                    "Page title did not exactly match expected");

            System.out.println("This line still executes even if the assertion fails");

            // Collect & report all soft assertion failures at the end
            softAssert.assertAll();

            System.out.println("Soft assertion passed, test continued...");

       {
            driver.quit();
        }
    }
}
