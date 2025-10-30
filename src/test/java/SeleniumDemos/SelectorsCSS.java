package SeleniumDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelectorsCSS {
    public static void main(String[] args) {

        // Set Edge WebDriver path
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\sonal\\IdeaProjects\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        WebDriver cssDriver = new EdgeDriver();

        // Open  site
        cssDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // --------------------- BASIC SELECTORS ---------------------
        try {
            // By ID
            cssDriver.findElement(By.cssSelector("#dropdown-class-example")).click();
            System.out.println("Dropdown found by ID");

            // By class
            cssDriver.findElement(By.cssSelector(".cen-left-align")).click();
            System.out.println("Element found by class");

            // By tag name (first matching element)
            cssDriver.findElement(By.cssSelector("input")).click();
            System.out.println("Element found by tag");
        } catch (Exception e) {
            System.out.println("Basic selector element not found");
        }

        // --------------------- SPECIFIC ATTRIBUTES ---------------------
        try {
            // Single attribute
            cssDriver.findElement(By.cssSelector("input[value='option2']")).click();
            System.out.println("Found by single attribute");

            // Multiple attributes
            cssDriver.findElement(By.cssSelector("input[value='AlertTest'][type='submit']")).click();
            System.out.println("Found by multiple attributes");
        } catch (Exception e) {
            System.out.println("Attribute-based element not found");
        }

        // --------------------- COMBINATOR SELECTORS ---------------------
        try {
            // Descendant selector (space) - matches any level child
            cssDriver.findElement(By.cssSelector("fieldset input"));
            System.out.println("Descendant combinator matched");

            // Child selector (>) - matches only direct children
            cssDriver.findElement(By.cssSelector("fieldset > input"));
            System.out.println("Direct child combinator matched");

            // Adjacent sibling (+) - matches the very next sibling
            cssDriver.findElement(By.cssSelector("#alertbtn + input"));
            System.out.println("Adjacent sibling matched");

            // General sibling (~) - matches all siblings after a given element
            cssDriver.findElement(By.cssSelector("#alertbtn ~ input"));
            System.out.println("General sibling matched");

        } catch (Exception e) {
            System.out.println("Combinator selector not matched");
        }


//        // --------------------- ADVANCED ATTRIBUTE SELECTORS ---------------------
        try {
            // Starts with (^=)
            cssDriver.findElement(By.cssSelector("input[name^='check']")).click();
            System.out.println("Starts-with attribute matched");

            // Ends with ($=)
            cssDriver.findElement(By.cssSelector("link[href$='.png']"));
            System.out.println("Ends-with attribute matched");

            // Contains (*=)
            cssDriver.findElement(By.cssSelector("link[href*='.png']"));
            System.out.println("Contains attribute matched");
        } catch (Exception e) {
            System.out.println("Advanced attribute selector not matched");
        }

        // --------------------- PSEUDO-CLASSES ---------------------
        try {
            cssDriver.findElement(By.cssSelector("table[name='courses'] tr:last-child"));
            System.out.println("Last row matched");

            cssDriver.findElement(By.cssSelector("table[name='courses'] tr:first-child"));
            System.out.println("First row matched");

            cssDriver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(4)"));
            System.out.println("4th row matched");
        } catch (Exception e) {
            System.out.println("Pseudo-class selector not matched");
        }

        // --------------------- MULTIPLE CLASSES ---------------------
        try {
            cssDriver.findElement(By.cssSelector("#mousehover.btn.btn-primary")).click();
            System.out.println("Element matched by multiple classes and ID");
        } catch (Exception e) {
            System.out.println("Multiple-class selector not matched");
        }

        //Close browser
        cssDriver.quit();
    }
}
