package SeleniumDemos.August25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class Listerner2 {

    public static void main(String[] args) {
        WebDriver d = new ChromeDriver();

        // Attach custom listener
        WebDriverListener myListener = new Listner();
        EventFiringDecorator decorator = new EventFiringDecorator(myListener);
        WebDriver dDecor = decorator.decorate(d);

        // Use the decorated driver
        dDecor.get("https://rahulshettyacademy.com/AutomationPractice/");
        //WebElement link = dDecor.findElement(By.id("autocomplete"));
        WebElement alButton = dDecor.findElement(By.id("alertbtn"));
        alButton.click();

        dDecor.switchTo().alert().accept();
    }
}
