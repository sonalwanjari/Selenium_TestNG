package SeleniumDemos.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathSiblings {
    public static void main(String[] args) {
        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        try {
             //Descendant
        WebElement desc = driver.findElement
                (By.xpath("//label/descendant::input"));
        System.out.println("Descendant element found");

            // Following sibling
            WebElement siblings = driver.findElement
                    (By.xpath("//label/following-sibling::label"));
            System.out.println("Sibling element found");
        } catch (RuntimeException e) {
            System.out.println("Web element not found");
        }
        driver.quit();
    }
}
