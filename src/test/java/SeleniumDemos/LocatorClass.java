package SeleniumDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorClass {
    public static void main(String[] args) {

        // Set the path to ChromeDriver
        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\Drivers\\chromedriver-win64\\chromedriver.exe");

        // Launch the browser
        WebDriver loca = new ChromeDriver();

        // Maximize
        loca.manage().window().maximize();

        // Open Rahul Shetty Practice Page
        loca.get("https://rahulshettyacademy.com/AutomationPractice/");

        // ---------------------- Task 1: By ID ----------------------
        try {
            WebElement name = loca.findElement(By.id("name"));
            System.out.println("Web element found " + name);
            WebElement openWindow = loca.findElement(By.id("openwindow"));
            System.out.println("Web element found " + openWindow);

        } catch (Exception e) {
            System.out.println("Web element not found");
        }

        // ---------------------- Task 2: By Name ----------------------

        try {
            WebElement radioBtn = loca.findElement(By.name("radioButton"));
            System.out.println("Radio Button Found with element name -> " + radioBtn.getAttribute("name"));
            // search google for how to display name of an element!
            WebElement dropDown = loca.findElement(By.name("dropdown-class-example"));
            System.out.println("Drop down Found with element name -> " + dropDown.getAttribute("name"));
        }catch (Exception e) {
            System.out.println("Web element not found");
        }

        //        // ---------------------- Task 3: By Class Name ----------------------//

        try {
            WebElement className1 = loca.findElement(By.className("blinkingText"));
            WebElement className2 = loca.findElement(By.className("ui-autocomplete-input"));
            System.out.println("Class Name found with element name -> " + className1.getAttribute("class"));
            System.out.println("Class Name found with element name -> " + className2.getAttribute("class")); // search google for how to display name of an element!

        } catch (Exception e) {
            System.out.println("Web Element not found");
        }

        //---------------------- Task 4: By Tag Name ----------------------
        try {
            WebElement tagName = loca.findElement(By.tagName("div"));
            System.out.println("Web element found at -> " + tagName.getTagName());
            WebElement tagName2 = loca.findElement(By.tagName("button"));
            System.out.println("Web element found at -> " + tagName2.getTagName() + " at line " + tagName2.getLocation());
        } catch (Exception e) {
            System.out.println("Web Element Not Found");
        }

        // ---------------------- Task 5: By Link Text ----------------------

        WebElement homeLink = loca.findElement(By.linkText("Home"));
        System.out.println("Web Element found at -> : " + homeLink.getTagName() +" & Text -> " + homeLink.getText());
        System.out.println("Link Text: " + homeLink.getText());
        System.out.println("URL: " + homeLink.getAttribute("href")); // via Google

        // ---------------------- Task 6: By Partial Link Text ----------------------
        WebElement partialLink2 = loca.findElement(By.partialLinkText("You"));
        System.out.println("Web Element found of Text : " + partialLink2.getText());
        System.out.println("URL: " + partialLink2.getAttribute("href"));

        loca.quit();

    }}

