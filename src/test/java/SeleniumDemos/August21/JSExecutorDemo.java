package SeleniumDemos.August21;

import SeleniumDemos.August19.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutorDemo extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        // Launch browser
        launchBrowser("https://the-internet.herokuapp.com/");

        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down the page by 500 pixels
        js.executeScript("window.scrollBy(0,500);");
        Thread.sleep(1000);

        // Click on "A/B Testing" link using JS
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        js.executeScript("arguments[0].click();", abTestLink);
        Thread.sleep(1000);

        // Fetch page title using JS
        String title = js.executeScript("return document.title;").toString();
        System.out.println("Page Title: " + title);

        // Type text in login page without sendKeys()
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        js.executeScript("arguments[0].value='tomsmith';", username);
        js.executeScript("arguments[0].value='SuperSecretPassword!';", password);
        Thread.sleep(1000);

        // Refresh page using JS
        js.executeScript("history.go(0);");
        Thread.sleep(1000);

        // Close browser
        closeBrowser();
    }
}
