//package SeleniumDemos.WebDrivers;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Point;
//
//public class Test extends BaseTest {
//    public static void main(String[] args) throws InterruptedException {
//        Test.openWindow("https://rahulshettyacademy.com/AutomationPractice/");
//
//        // Corrected: Removed invalid clearText call on radio button.
//        Test.clickElement(By.xpath("//input[@name='radioButton' and @value ='radio3']"));
//
//        Test.enterText(By.id("autocomplete"), "Sonal Wanjari");
//
//        Test.clickElement(By.xpath("//input[@id='checkBoxOption2' and @value='option2']"));
//
//        boolean display = Test.isDisplayed(By.xpath("//img[@src='images/rs_logo.png']"));
//        System.out.println("Verifying logo: " + display);
//
//        boolean enabled = Test.isEnabled(By.id("alertbtn"));
//        System.out.println("Verify button: " + enabled);
//
//        // Corrected: Used CSS Selector for multiple classes.
//        // There is no submit button with this class, this is an example of correct syntax.
//        // Test.submit(By.cssSelector(".btn-style.class1.class2"));
//
//        // Corrected: Use getAttribute("value") for input field text
//        String attributeValue = Test.getAttributeValue(By.id("autocomplete"), "value");
//        System.out.println("Text entered in autocomplete: " + attributeValue);
//
//        // Corrected: Changed locator and print statement
//        String tag = Test.tagName(By.tagName("legend"));
//        System.out.println("The tag name is: " + tag);
//
//        String text = Test.getText(By.tagName("legend"));
//        System.out.println("The legend's text is: " + text);
//
//        String css = Test.getCSS(By.id("opentab"), "background-color");
//        System.out.println("Open Tab background color: " + css);
//
//        String attribute = Test.getAttributeValue(By.id("displayed-text"), "name");
//        System.out.println("Attribute is: " + attribute);
//
//        Dimension size = Test.elementSize(By.className("table-display"));
//        System.out.println("Size of Table: " + size);
//
//        Point location = Test.elementLocation(By.id("dropdown-class-example"));
//        System.out.println("Location of element: " + location);
//
//        Test.clickElement(By.id("checkBoxOption3"));
//
//        Thread.sleep(2000); // Added a wait to see the final state
//
//        Test.quitBrowser();
//    }
//}