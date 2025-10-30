package SeleniumDemos.ScreenshotAndRecording;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecordingClass {
    public static void main(String[] args) throws Exception {
        // Start recording
        RecordingUtilityClass.recordingDemo();

        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Interact with JS alerts
        By JSAlert = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
        browser.findElement(JSAlert).click();
        browser.switchTo().alert().accept();

        By JSConfirm = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
        browser.findElement(JSConfirm).click();
        browser.switchTo().alert().dismiss();

        // Keep browser open for a few seconds for recording
        Thread.sleep(5000);

        browser.quit();

        // Stop recording
        RecordingUtilityClass.stopRecording();
        System.out.println("Recording has been saved ");
    }
}
