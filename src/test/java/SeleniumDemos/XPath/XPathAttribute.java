package SeleniumDemos.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAttribute {
    public static void main(String[] args) {

        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        try{
            driver.findElement(By.xpath("//input[contains(@id,'auto')]"));
            System.out.println("Web element found");

            driver.findElement(By.xpath("//div[starts-with(@id,'check')]"));
            System.out.println("Web element found");


        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
driver.quit();
    }

}
