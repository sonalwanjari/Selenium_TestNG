package SeleniumDemos.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPositionIndex {
    public static void main(String[] args) {
        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\IdeaProjects\\chromedriver-win64.zip");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        try {
            // First input element
            driver.findElement(By.xpath("//input)[1]"));
            System.out.println("First input element found");

            // Third div element
            driver.findElement(By.xpath("(//div)[3]"));
            System.out.println("Div[3] element found");

            // Last table row
            driver.findElement(By.xpath("(//tr)[last()]"));
            System.out.println("Last table row found");

        } catch (RuntimeException e) {
            System.out.println("Web ELement not found");
        }
            driver.quit();
        }
    }

