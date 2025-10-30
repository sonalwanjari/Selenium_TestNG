package SeleniumDemos.WebDrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static SeleniumDemos.WebDrivers.BaseTest.driver;

public class CallingWebDrivers {
    public static void main(String[] args) {
        // Set the path to ChromeDriver
        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\Drivers\\chromedriver-win64\\chromedriver.exe");

        // Launch the browser
        WebDriver open = new ChromeDriver();

        open.get("https://rahulshettyacademy.com/AutomationPractice/");
        open.getTitle(); open.manage().window().maximize();

        WebElement radioBtn = open.findElement(By.xpath("//input[@name='radioButton' and @value ='radio3']"));
        WebElement check = open.findElement(By.xpath("//input[@id='checkBoxOption2' and @value='option2']"));
        radioBtn.click(); check.click();

        driver.quit();











































    }
}
