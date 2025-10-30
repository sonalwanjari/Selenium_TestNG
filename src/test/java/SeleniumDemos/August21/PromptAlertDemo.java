package SeleniumDemos.August21;

import SeleniumDemos.August19.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PromptAlertDemo extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        // Launch browser
        launchBrowser("https://the-internet.herokuapp.com/javascript_alerts");

        // Click button to trigger Prompt AlertTest
        WebElement promptAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        promptAlertBtn.click();

        // Handle the prompt alert
        BaseTest base = new BaseTest();
        base.handlePromptAlert("Sonal Wanjari", true); // true = accept alert

        // Verify result text
        WebElement resultElement = driver.findElement(By.id("result"));
        System.out.println("Result text = 'Sonal Wanjari");
        // Close browser
       closeBrowser();
    }
}
