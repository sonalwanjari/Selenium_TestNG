package SeleniumDemos.August19;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    // Launch Browser
    public static void launchBrowser(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("Browser launched with URL: " + url);
    }

    // Close Browser
    public static void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed.");
    }

    public void handlePromptAlert(String text, boolean accept) throws InterruptedException {
        Alert alert = driver.switchTo().alert();
        System.out.println("Prompt AlertTest Text: " + alert.getText());
        alert.sendKeys(text);
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        Thread.sleep(1000);
    }
}
