package SeleniumDemos.ScreenshotAndRecording;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class Screenshot {
    public static void main(String[] args) throws IOException {
        WebDriver browser = new ChromeDriver();
        browser.get("https://rahulshettyacademy.com/AutomationPractice/");
        File getSS = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(getSS, new File("C:\\STAD Solutions\\Selenium\\Screenshots\\SS1.png"));
        System.out.println("Screenshot is added to the location");

        WebElement iFrame = browser.findElement(By.xpath("//*[@id=\"courses-iframe\"]"));
        File getIframeSS = iFrame.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(getIframeSS, new File("C:\\STAD Solutions\\Selenium\\Screenshots\\SS2.png"));
        System.out.println("Screenshot of iFrame added to the location");

        WebElement table = browser.findElement(By.xpath("/html/body/div[3]/div[2]/fieldset[2]/div[1]"));
        File getTableSS = table.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(getTableSS, new File("C:\\STAD Solutions\\Selenium\\Screenshots\\SS3.png"));
        System.out.println("Screenshot of table added to the location");



    }
}
