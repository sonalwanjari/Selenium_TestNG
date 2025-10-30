package SeleniumDemos.August19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ParticularLinkTest extends BaseTest {

    // Generic Function to find one link
    public static void searchLink(String linkName) {
        try {
            WebElement link = driver.findElement(By.linkText(linkName));
            System.out.println("Link found: " + link.getText() + " --> " + link.getAttribute("href"));
        } catch (Exception e) {
            System.out.println("Link not found: " + linkName);
        }
    }

    public static void main(String[] args) {
        launchBrowser("https://rahulshettyacademy.com/AutomationPractice/");

        searchLink("Practice");
        searchLink("REST API");

        closeBrowser();
    }
}
