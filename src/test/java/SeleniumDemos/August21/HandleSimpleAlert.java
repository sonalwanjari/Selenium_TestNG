package SeleniumDemos.August21;

import SeleniumDemos.August19.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

public class HandleSimpleAlert extends BaseTest {

    // Method to handle simple alert
    public void handleAlertOk() {
        Alert alertBox = driver.switchTo().alert();
        System.out.println("AlertTest message : " + alertBox.getText());
        alertBox.accept();   // Clicks OK
        System.out.println("AlertTest accepted!!!!!!");
    }

    public static void main(String[] args) throws InterruptedException {
        HandleSimpleAlert obj = new HandleSimpleAlert();

        // Call your BaseTest method
        launchBrowser("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("DemoUser");
        driver.findElement(By.id("alertbtn")).click();

        Thread.sleep(1234);

        obj.handleAlertOk();

        closeBrowser();
    }
}