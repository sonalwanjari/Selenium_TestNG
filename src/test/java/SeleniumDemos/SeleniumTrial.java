package SeleniumDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTrial {

    public static void main(String[] args) {

        System.getProperty("webdriver.chrome.driver","C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver objDriver = new ChromeDriver(); // Open Chrome Browser

        objDriver.get("https://www.makemytrip.com/"); // Opens the URL mentioned - Make My Trip

        String getTitle = objDriver.getTitle();  // Gets the title of the Web Page
        System.out.println("Title of page - "+getTitle);

        String currURL = objDriver.getCurrentUrl(); // Gets current URL where user is currently on
        System.out.println("Current URL of page - "+currURL);

        objDriver.quit(); // quits/closes the browser

        System.out.println("Code Executed"); // Prints statement

    }

}
