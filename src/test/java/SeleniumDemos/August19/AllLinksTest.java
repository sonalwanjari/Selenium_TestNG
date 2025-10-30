package SeleniumDemos.August19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AllLinksTest extends BaseTest {

    // Generic Function to print all links
    public static void showAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links on Page: " + links.size());

        for (WebElement link : links) {
            System.out.println(link.getText() + " --> " + link.getAttribute("href"));
        }
    }

    public static void main(String[] args) {
        launchBrowser("https://rahulshettyacademy.com/AutomationPractice/");

        showAllLinks();

        closeBrowser();
    }
}
