package SeleniumDemos.HandlingOfWindowsTabsFrames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class TabHandling {
    public static void main(String[] args) {
        // Set ChromeDriver path
        System.getProperty("webdriver.chrome.driver","C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver(); // Open Chrome Browser

        // Open practice site
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Store parent tab handle
        String parentTab = driver.getWindowHandle();

        // Click on link to open new tab
        driver.findElement(By.id("opentab")).click();

        // Switch to new tab and print title
        Set<String> allTabs = driver.getWindowHandles(); //here, allTabs will store both the parent tab and any child tab
        for (String tab : allTabs) {
            //for loop iterates through each String called tab in the collection allTabs,
            // handling the parent tab, then the child tab, and other tabs in order
            driver.switchTo().window(tab); //This changes the driver’s focus to whichever tab/window we are currently looping on
            System.out.println("Tab Title: " + driver.getTitle());
        }

        // Back to parent tab
        driver.switchTo().window(parentTab);
        System.out.println("Back to Parent Tab Title: " + driver.getTitle());

        driver.quit();
    }
}
