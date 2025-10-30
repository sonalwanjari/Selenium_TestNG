package Trails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrialForAlertsBaseTest {

    public static WebDriver d;

    public static void openBrowser(String path) {
        d = new ChromeDriver();
        d.get(path);
        d.manage().window().maximize();
        System.out.println("launched");
    }

}
