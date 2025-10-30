package SeleniumDemos.WebDrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

// BaseTest class to hold common WebDriver actions.
// This class uses a static WebDriver instance so it can be shared across static methods.
public class BaseTest {
    static WebDriver driver;

    // Helper method to find a WebElement by a given locator.
    // This reduces code repetition and makes the code cleaner.
    static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Method to open a new browser window and navigate to a URL.
    static void openWindow(String url) {
        // Corrected: Use setProperty to set the ChromeDriver path.
        // This line tells Selenium where to find the browser's executable file.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\Drivers\\chromedriver-win64\\chromedriver.exe");

        // Initialize a new ChromeDriver instance.
        driver = new ChromeDriver();

        // Navigate to the specified URL.
        driver.get(url);

        // Maximize the browser window for better visibility and consistent tests.
        driver.manage().window().maximize();
    }

    // Method to close the browser.
    // It's good practice to have a null check here to prevent NullPointerException
    // in case the driver was not initialized.
    static void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Method to click a web element.
    public static void clickElement(By locator) {
        findElement(locator).click();
    }

    // Method to clear text from an input field.
    static void clearText(By locator) {
        findElement(locator).clear();
    }

    // Method to enter text into an input field.
    // It takes a By locator and the text to be entered as parameters.
    static void enterText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    // Method to check if an element is displayed on the webpage.
    static boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    // Method to check if an element is enabled for user interaction.
    static boolean isEnabled(By locator) {
        return findElement(locator).isEnabled();
    }

    // Method to submit a form. This method works only on elements within a <form> tag.
    static void submit(By locator) {
        findElement(locator).submit();
    }

    // Method to get the visible text of an element.
    static String getText(By locator) {
        return findElement(locator).getText();
    }

    // Method to get the tag name of an element (e.g., "div", "a", "legend").
    static String getTagName(By locator) {
        return findElement(locator).getTagName();
    }

    // Method to get the CSS property value of an element.
    static String getCSS(By locator, String cssProperty) {
        return findElement(locator).getCssValue(cssProperty);
    }

    // Method to get the value of a specific attribute of an element (e.g., "id", "class", "value").
    static String getAttributeValue(By locator, String attribute) {
        return findElement(locator).getAttribute(attribute);
    }

    // Method to get the size (height and width) of an element.
    static Dimension elementSize(By locator) {
        return findElement(locator).getSize();
    }

    // Method to get the location (X and Y coordinates) of an element on the page.
    static Point elementLocation(By locator) {
        return findElement(locator).getLocation();
    }
}
