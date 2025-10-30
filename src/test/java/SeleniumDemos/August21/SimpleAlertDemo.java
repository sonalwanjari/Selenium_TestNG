package SeleniumDemos.August21;

import SeleniumDemos.August19.BaseTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class SimpleAlertDemo extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        // Launch browser using BaseTest method
        launchBrowser("https://the-internet.herokuapp.com/javascript_alerts");

        // Click button for Simple AlertTest
        driver.findElement(By.xpath("//button[text()='Click for JS AlertTest']")).click();

        // Switch to alert
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple AlertTest Text: " + alert.getText());

        // Accept alert
        alert.accept();

        Thread.sleep(1000);

        // Close browser using BaseTest method
        closeBrowser();
    }
}
