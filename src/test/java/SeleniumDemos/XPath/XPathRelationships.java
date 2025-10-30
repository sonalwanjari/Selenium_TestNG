package SeleniumDemos.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathRelationships {
    public static void main(String[] args) {
        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        try {
            // Parent of first checkbox
            driver.findElement(By.xpath("//input[@id='checkBoxOption1']/.."));
            System.out.println("Parent of checkbox 1 found");

            // Child - first checkbox inside the section
            driver.findElement(By.xpath("//fieldset/input"));
            System.out.println("Child fieldset found");

        } catch (RuntimeException e) {
            System.out.println("Web Element not found ");
        }
            driver.quit();
        }
    }
