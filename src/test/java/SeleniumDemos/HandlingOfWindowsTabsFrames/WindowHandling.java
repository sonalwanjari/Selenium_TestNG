package SeleniumDemos.HandlingOfWindowsTabsFrames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) {

                // Set ChromeDriver path
        System.getProperty("webdriver.chrome.driver","C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver(); // Open Chrome Browser


        // Open practice site
                driver.get("https://rahulshettyacademy.com/AutomationPractice/");

                // Store parent window handle
                String parentWindow = driver.getWindowHandle();

                // Click on link to open new window
                driver.findElement(By.id("openwindow")).click();

                // Switch to child window
                Set<String> handles = driver.getWindowHandles();

                for (String childHandle : handles) {
                    if (!childHandle.equals(parentWindow)) {
                        driver.switchTo().window(childHandle);
                        System.out.println("Child Window Title: " + driver.getTitle());
                        driver.close(); // Close child window
                    }
                }

                // Again back to parent window
                driver.switchTo().window(parentWindow);
                System.out.println("Back to Parent Window Title: " + driver.getTitle());

                driver.quit();
            }
        }
