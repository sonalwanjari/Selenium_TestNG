package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Main TestNG Assignment demonstrating core annotation attributes
 * Author: [Your Name]
 * Purpose: Learning TestNG attributes with Selenium automation
 */
        public class TestNGAttributesAssignment {

            WebDriver driver;

            @BeforeMethod
            public void browserSetup() {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

            // Attribute 1: description - provides test documentation
            // Attribute 2: timeOut - sets maximum execution time in milliseconds
            // Attribute 3: priority - controls execution order (lower numbers first)
            @Test(description = "Verify that Google homepage loads correctly", timeOut = 8000, priority = 1)
            public void verifyHomepageLoading() {
                driver.get("https://www.google.com");
                String pageTitle = driver.getTitle();
                Assert.assertTrue(pageTitle.contains("Google"), "Homepage title should contain Google");
                System.out.println("Test 1 completed: Homepage loads successfully");
            }

            // Attribute 6: groups - categorizes tests for selective execution
            @Test(description = "Check if search box is visible and working?", priority = 2, groups = {"smoke", "ui"})
            public void checkSearchBoxVisibility() {
                driver.get("https://www.google.com");
                WebElement searchInput = driver.findElement(By.name("q"));
                Assert.assertTrue(searchInput.isDisplayed(), "Search box should be visible");

                // Test basic interaction
                searchInput.sendKeys("TestNG Framework");
                Assert.assertEquals(searchInput.getAttribute("value"), "TestNG Framework");
                System.out.println("Test 2 completed: Search box is working properly");
            }

            // Attribute 4: dependsOnMethods - creates test dependencies
            @Test(description = "Perform actual search operation",
                    dependsOnMethods = {"verifyHomepageLoading"},
                    priority = 3,
                    groups = {"functional"})
            public void performSearchOperation() {
                driver.get("https://www.google.com");
                WebElement searchField = driver.findElement(By.name("q"));
                searchField.sendKeys("Selenium WebDriver");
                searchField.submit();

                // Wait for results to load
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String resultTitle = driver.getTitle();
                Assert.assertTrue(resultTitle.contains("Selenium WebDriver"),
                        "Search results should be displayed");
                System.out.println("Test 3 completed: Search operation successful");
            }

            // Attribute 8: dependsOnGroups - depends on completion of specific test groups
            // Attribute 9: alwaysRun - executes even if dependencies fail
            @Test(description = "Validate search results page elements",
                    dependsOnGroups = {"smoke"},
                    alwaysRun = true,
                    priority = 4)
            public void validateSearchResults() {
                driver.get("https://www.google.com");
                driver.findElement(By.name("q")).sendKeys("Java Programming");
                driver.findElement(By.name("q")).submit();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String currentUrl = driver.getCurrentUrl();
                Assert.assertTrue(currentUrl.contains("search"), "URL should contain search parameter");
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

                WebElement searchBox = driver.findElement(By.name("q"));
                searchBox.sendKeys(term);
                searchBox.submit();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Assert.assertTrue(driver.getTitle().contains(term),
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
