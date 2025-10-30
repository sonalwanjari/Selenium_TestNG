package SeleniumDemos.August20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/");

        driver.switchTo().frame(0);

     //   WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
        WebElement slider2 = driver.findElement(By.cssSelector(".ui-slider-handle"));

        Actions act = new Actions(driver);
        act.clickAndHold(slider2).moveByOffset(80,0).release().perform();

        System.out.println("Slider moved successfully.");

        driver.quit();
    }
}
