package SeleniumDemos.August19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBoxTest extends BaseTest {

    // Generic Function for Checkbox
    public static void selectCheck(String checkValue) {
        WebElement check = driver.findElement(By.xpath("//input[@value='" + checkValue + "']"));
        if (!check.isSelected()) {
            check.click();
        }
        System.out.println("Checkbox selected: " + checkValue);
    }

    public static void main(String[] args) {
        launchBrowser("https://rahulshettyacademy.com/AutomationPractice/");

        selectCheck("option1");
        selectCheck("option2");

        closeBrowser();
    }
}
