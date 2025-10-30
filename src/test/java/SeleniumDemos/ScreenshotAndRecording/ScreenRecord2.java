package SeleniumDemos.ScreenshotAndRecording;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ScreenRecord2 {
    public static void main(String[] args) throws Exception {
        // Start screen recording
        RecordingUtilityClass.recordingDemo();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement radio2 = driver.findElement(By.cssSelector("input[value='radio2']"));
        radio2.click();

        driver.findElement(By.id("checkBoxOption3")).click();

        driver.findElement(By.id("alertbtn")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys("Sonal Recording");

        Thread.sleep(5000);

        driver.quit();

        // Stop recording
        RecordingUtilityClass.stopRecording();
        System.out.println("Recording has been saved successfully.");
    }
}
