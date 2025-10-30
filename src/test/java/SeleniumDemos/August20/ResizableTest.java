package SeleniumDemos.August20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizableTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/resizable/");

        driver.switchTo().frame(0);

        WebElement resizeHandle = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));

        Actions act = new Actions(driver);
        act.dragAndDropBy(resizeHandle, 120, 80).perform();

        System.out.println("Box resized successfully.");

        driver.quit();
    }
}
