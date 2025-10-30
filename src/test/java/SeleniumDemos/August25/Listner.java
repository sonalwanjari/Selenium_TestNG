package SeleniumDemos.August25;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Listner implements WebDriverListener {

    public void beforeClick (WebElement element){
        System.out.println("Before Click " +element);
    }
    public void afterClick (WebElement element){
        System.out.println("After Click " +element);
    }
}
