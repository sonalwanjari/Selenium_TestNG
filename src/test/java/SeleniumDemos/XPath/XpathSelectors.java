package SeleniumDemos.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathSelectors {

        public static void main(String[] args) {

            System.getProperty("webdriver.chrome.driver","C:\\Users\\sonal\\IdeaProjects\\Drivers\\chromedriver-win64\\chromedriver");

            WebDriver driver = new ChromeDriver(); // Open Chrome Browser

            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            try{
                driver.findElement(By.xpath("//input"));
                System.out.println("By Tag name Web element found");

                driver.findElement(By.xpath("//input[@value='radio1']"));
                System.out.println("By Attribute Web element found");


            } catch (RuntimeException e) {
                System.out.println("Element not found ");
            }


        }
    }
