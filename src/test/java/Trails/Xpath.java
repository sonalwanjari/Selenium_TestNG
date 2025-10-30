package Trails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
    public static void main(String[] args) {

        System.getProperty("webdriver.chrome.driver","C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver(); // Open Chrome Browser

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        try{
            driver.findElement(By.xpath("//input")).click();
            System.out.println("Web element found");

            driver.findElement(By.xpath("//input[@value='radio1']"));
            System.out.println("Web element found");


        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


    }
}
