package Trails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CSSSelectorTrials {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\sonal\\IdeaProjects\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        WebDriver cssDriver = new EdgeDriver();

        cssDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        try {
            cssDriver.findElement(By.cssSelector("#dropdown-class-example")).click();
            System.out.println("Web element found");

            cssDriver.findElement(By.cssSelector(".cen-left-align")).click();
            System.out.println("Web element found - by class ");

            cssDriver.findElement(By.cssSelector("input")).click();
            System.out.println("Web element found - by NAME ");
        } catch (Exception e) {
            System.out.println("Web element not found");

        }
// --------------------- SPECIFIC ATTRIBUTE ----------------------------------
        try{
            cssDriver.findElement(By.cssSelector("input[value='option2']")).click();
            System.out.println("Web element found - by Attribute ");

            cssDriver.findElement(By.cssSelector("input[value='AlertTest'][type='submit']")).click();
            System.out.println("Web element found - by Multiple Attribute");
        } catch (Exception e) {
            System.out.println("Web element not found");
        }

        // --------------------- COMBINATOR SELECTOR ----------------------------------
        try {
            // Descendant selector (space)
            cssDriver.findElement(By.cssSelector("fieldset input"));
            System.out.println("Descendant combinator found");

            // Child selector (>) - find only direct children
            cssDriver.findElement(By.cssSelector("fieldset > input"));
            System.out.println("Found first direct child");

            // Adjacent sibling selector (+)
            cssDriver.findElement(By.cssSelector("#checkbox-example input + label"));
            cssDriver.findElement(By.cssSelector("#alertbtn + input"));
            System.out.println("Found label using adjacent sibling selector");
            // General sibling selector (~) - find all labels after a given input
            cssDriver.findElement(By.cssSelector("#alertbtn ~ input"));
            System.out.println("Found labels using general sibling selector");

        } catch (Exception e) {
            System.out.println("One or more combinator selectors did not match any element.");
        }
        // --------------------- ADVANCED ATTRIBUTE SELECTOR =--------------------

        try{
            cssDriver.findElement(By.cssSelector("input[name^='check'] ")).click();
            System.out.println("Starts With (^=) Found ");

            cssDriver.findElement(By.cssSelector("(link[href$= '.png']")).click();
            System.out.println("Ends With ($=) Found ");

            cssDriver.findElement(By.cssSelector("link[href*='.png']")).click();
            System.out.println("Contains (*=) Found");
        } catch (Exception e) {
           System.out.println("Web element not found");
        }

//  Pseudo-Classes & Pseudo-Elements

try {
    cssDriver.findElement(By.cssSelector("table[name='courses'] tr:last-child"));
    System.out.println("Table element found ");

    cssDriver.findElement(By.cssSelector("table[name='courses'] tr:first-child"));
    System.out.println("Table element found ");

    cssDriver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(4)"));
    System.out.println("Table element found ");


} catch (Exception e) {
    System.out.println("Web element not found");
}

try{
    cssDriver.findElement(By.cssSelector("#mousehover.btn.btn-primary")).click();
}
catch (Exception e){
    System.out.println("Web element found");
        }


    }
}
