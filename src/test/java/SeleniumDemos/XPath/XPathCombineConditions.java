package SeleniumDemos.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathCombineConditions {
    public static void main(String[] args) {
        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        try {
            // Using AND
            driver.findElement(By.xpath("//input[@type='checkbox' and @id='checkBoxOption1']"));
            System.out.println("Element found using AND condition");

            // Using OR
            driver.findElement(By.xpath("//input[@type='text' or @id='autocomplete']"));
            System.out.println("Element found using OR condition");

        } catch (RuntimeException e) {
            System.out.println("Web ELement not found");
        }
        driver.quit();
    }
    }

