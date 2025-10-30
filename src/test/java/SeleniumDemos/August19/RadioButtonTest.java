package SeleniumDemos.August19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButtonTest extends BaseTest {

    // Generic Function for Radio Button
    public static void selectRadio(String radioValue) {
        WebElement radio = driver.findElement(By.xpath("//input[@value='" + radioValue + "']"));
        if (!radio.isSelected()) {
            radio.click();
        }
        System.out.println("Radio button selected: " + radioValue);
    }

    public static void main(String[] args) {
        launchBrowser("https://rahulshettyacademy.com/AutomationPractice/");

        selectRadio("radio2");
        selectRadio("radio3");

        closeBrowser();
    }
}
