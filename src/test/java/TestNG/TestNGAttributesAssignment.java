package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

/**
 * Main TestNG Assignment demonstrating core annotation attributes
 * Author: Sonal
 * Purpose: Learning TestNG attributes with Selenium automation
 */
public class TestNGAttributesAssignment {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void browserSetup() {
        // Ensure the right chromedriver is present and configure headless mode for CI
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // headless for Jenkins/CI; remove if you want to see the browser locally
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        // create a wait helper
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Attribute 1: description - provides test documentation
    // Attribute 2: timeOut - sets maximum execution time in milliseconds
    // Attribute 3: priority - controls execution order (lower numbers first)
    @Test(description = "Verify that Google homepage loads correctly", timeOut = 8000, priority = 1)
    public void verifyHomepageLoading() {
        driver.get("https://www.google.com");
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle != null && pageTitle.contains("Google"), "Homepage title should contain Google");
        System.out.println("Test 1 completed: Homepage loads successfully");
    }

    // Attribute 6: groups - categorizes tests for selective execution
    @Test(description = "Check if search box is visible and working?", priority = 2, groups = {"smoke", "ui"})
    public void checkSearchBoxVisibility() {
        driver.get("https://www.google.com");
        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        Assert.assertTrue(searchInput.isDisplayed(), "Search box should be visible");

        // Test basic interaction
        String text = "TestNG Framework";
        searchInput.sendKeys(text);
        Assert.assertEquals(searchInput.getAttribute("value"), text);
        System.out.println("Test 2 completed: Search box is working properly");
    }

    // Attribute 4: dependsOnMethods - creates test dependencies
    @Test(description = "Perform actual search operation",
            dependsOnMethods = {"verifyHomepageLoading"},
            priority = 3,
            groups = {"functional"})
    public void performSearchOperation() {
        final String query = "Selenium WebDriver";

        driver.get("https://www.google.com");

        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        searchField.clear();
        searchField.sendKeys(query);
        searchField.submit();

        // Use explicit wait and tolerant locators for results
        By[] possibleLocators = new By[]{
                By.cssSelector("#search"),        // Google main results container
                By.cssSelector(".g"),             // Google single result block
                By.cssSelector(".search-results"),// generic
                By.cssSelector(".result-item"),   // alternate
                By.xpath("//div[contains(@class,'results')]")
        };

        boolean resultsFound = false;
        for (By locator : possibleLocators) {
            try {
                WebElement resultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                if (resultsContainer != null && resultsContainer.isDisplayed()) {
                    // basic sanity: ensure it contains at least one child element
                    if (!resultsContainer.findElements(By.xpath(".//*")).isEmpty()) {
                        resultsFound = true;
                        break;
                    }
                }
            } catch (Exception ignored) {
                // try the next locator
            }
        }

        // Fallback: check title contains query (useful for some search engines)
        String resultTitle = driver.getTitle();
        if (!resultsFound && resultTitle != null && resultTitle.toLowerCase().contains(query.toLowerCase())) {
            resultsFound = true;
        }

        Assert.assertTrue(resultsFound, "Search results should be displayed");
        System.out.println("Test 3 completed: Search operation successful");
    }

    // Attribute 8: dependsOnGroups - depends on completion of specific test groups
    // Attribute 9: alwaysRun - executes even if dependencies fail
    @Test(description = "Validate search results page elements",
            dependsOnGroups = {"smoke"},
            alwaysRun = true,
            priority = 4)
    public void validateSearchResults() {
        final String query = "Java Programming";
        driver.get("https://www.google.com");
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        searchBox.clear();
        searchBox.sendKeys(query);
        searchBox.submit();

        // Wait until title contains the query or results container is visible
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.titleContains(query),
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search"))
            ));
        } catch (Exception e) {
            // ignore - we'll assert below
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl != null && currentUrl.contains("search"), "URL should contain search parameter");
        System.out.println("Test 4 completed: Search results page validated");
    }

    // Attribute 5: enabled - controls whether test should run
    @Test(description = "This test is currently disabled for demonstration",
            enabled = false,
            priority = 5)
    public void skippedTestExample() {
        // This test will be skipped during execution
        driver.get("https://www.google.com");
        System.out.println("This message should not appear in console");
    }

    // Attribute 10: parameters - receives values from testng.xml
    @Test(description = "Test with external parameters from XML configuration",
            priority = 6)
    @Parameters({"testUrl", "searchTerm"})
    public void testWithXmlParameters(@Optional("https://www.google.com") String url,
                                      @Optional("TestNG") String term) {
        System.out.println("Testing with URL: " + url + " and search term: " + term);
        driver.get(url);

        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.clear();
        searchBox.sendKeys(term);
        searchBox.submit();

        // wait until title contains the search term
        try {
            wait.until(ExpectedConditions.titleContains(term));
        } catch (Exception ignored) {
            // proceed to assertion below
        }

        Assert.assertTrue(driver.getTitle() != null && driver.getTitle().toLowerCase().contains(term.toLowerCase()),
                "Page title should contain the search term");
        System.out.println("Test 6 completed: XML parameter test successful");
    }

    @AfterMethod
    public void cleanupBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void printTestSummary() {
        System.out.println("\n--- TestNG Assignment Summary ---");
        System.out.println("Demonstrated attributes:");
        System.out.println("✓ description: Added meaningful test descriptions");
        System.out.println("✓ timeOut: Set execution time limits");
        System.out.println("✓ priority: Controlled test execution order");
        System.out.println("✓ dependsOnMethods: Created method dependencies");
        System.out.println("✓ enabled: Showed how to disable tests");
        System.out.println("✓ groups: Organized tests into categories");
        System.out.println("✓ dependsOnGroups: Made tests depend on groups");
        System.out.println("✓ alwaysRun: Ensured critical tests always execute");
        System.out.println("✓ parameters: Used external configuration");
    }
}
