package SeleniumDemos.August19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest extends BaseTest {

    // Generic Function for Dropdown
    public static void chooseOption(String optionText) {
        WebElement drop = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(drop);
        select.selectByVisibleText(optionText);
        System.out.println("Dropdown option selected: " + optionText);
    }

    public static void main(String[] args) {
        launchBrowser("https://rahulshettyacademy.com/AutomationPractice/");

        chooseOption("Option2");
        chooseOption("Option3");

        closeBrowser();
    }
}
