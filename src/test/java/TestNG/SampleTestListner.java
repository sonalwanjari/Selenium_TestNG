package TestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// Attach the listener class
@Listeners(TestNG.MyTestListener.class)
public class SampleTestListner {

    @Test
    public void testPass() {
        System.out.println("Running testPass");
        Assert.assertTrue(true);  // This will pass
    }

    @Test
    public void testFail() {
        System.out.println("Running testFail");
        Assert.assertTrue(false); // This will fail - first this will run as per the alphabetical order
    }

    @Test(dependsOnMethods = "testFail")
    public void testSkip() {
        System.out.println("Running testSkip");
        // This will be skipped because testFail fails
    }
}
