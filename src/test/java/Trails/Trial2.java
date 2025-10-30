package Trails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class Trial2 {
    public static void main(String[] args) {

        // System.getProperty("webdriver.chrome.driver","C:\Users\sonal\IdeaProjects\Drivers\chromedriver-win64.zip\chromedriver-win64")

        System.setProperty("webdriver.edge.driver", "C:\\Users\\sonal\\IdeaProjects\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        WebDriver objDriver = new EdgeDriver();

        objDriver.get("https://www.makemytrip.com/");

        objDriver.findElement(By.xpath("//label[@for='fromCity']"));

        objDriver.manage().deleteAllCookies();

        objDriver.manage().window().maximize();



    }
}

//            objDriver.get("https://www.makemytrip.com/"); // Opens the URL mentioned - Make My Trip
//
//            String getTitle = objDriver.getTitle();  // Gets the title of the Web Page
//            System.out.println("Title of page - "+getTitle);
//
//            String currURL = objDriver.getCurrentUrl(); // Gets current URL where user is currently on
//            System.out.println("Current URL of page - "+currURL);
//
//            objDriver.quit(); // quits/closes the browser
//
//            System.out.println("Code Executed"); // Prints statement

