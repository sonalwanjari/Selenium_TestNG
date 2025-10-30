package TestNG;

import org.testng.Assert;
import org.testng.annotations.*;
public class DemoAllAttributes {

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("Start Testing");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.print(" ");
    }

    // 1 description and priority
    @Test(description = "simple sanity test check", priority = 1, groups = {"Sanity1"})
    public void sanityTest() {
        System.out.println("Running sanity test");
        Assert.assertTrue(false); //try with false too
    }

    // 2 timeOut
    @Test(description = "this test must finish within 1500 ms", timeOut = 1500, priority = 2)
    public void quickTimeoutTest() throws InterruptedException { //because we are using thread.sleep
        System.out.println("Running timeout test (must finish in 1.5 seconds)");
        Thread.sleep(200); // short sleep, still within timeout
        System.out.println(" Timeout test finished successfully");
        Assert.assertTrue(true);
    }

    // 3 groups and priority
    @Test(description = "grouped regression test", groups = {"Regression"}, priority = 3)
    public void regressionTest() {
        System.out.println("Running regression test");
    }

    // 4 dependsOnMethods
    @Test(description = "depends on sanityTest", dependsOnMethods = {"sanityTest"}, priority = 4)
    public void dependentOnSanity() {
        System.out.println("Running dependent test (executed after sanityTest)");
    }

    // 5 enabled false to skip
    @Test(description = "this test is disabled and will be skipped", enabled = false)
    public void skippedTest() {
        System.out.println("You should NOT see this message if test is disabled");
    }

    // 6 alwaysRun with a valid existing dependency (sanityTest)
    @Test(description = "always run even if sanityTest fails", dependsOnMethods = {"sanityTest"}, alwaysRun = true)
    public void alwaysRunExample() {
        System.out.println("Running alwaysRunExample (will run even if sanityTest fails)");
    }

    // 7 DataProvider example
    @DataProvider(name = "users")
    public Object[][] userData() {
        return new Object[][] {
                {"Chandler", "pass12345"},
                {"Joey", "pass09876"}
        };
    }

    @Test(description = "data driven login test", dataProvider = "users", priority = 5)
    public void loginSimulation(String user, String pass) {
        System.out.println("Running login with \n username: " + user + " \n and password: " + pass);
        //Assertions are checkpoints in your test → they verify the actual result matches the expected result.
        Assert.assertNotNull(user);
        Assert.assertNotNull(pass);
    }

    // 8 Parameters example
    @Parameters({"username", "password"})
    @Test(description = "Login test using parameters") // Runs first
    public void loginTest(String user,String pass) {
        System.out.println("Parameter Test >>Logging in with: \n > Username = " + user + " \n> Password = " + pass);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.print(" ");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println(">>> Test completed.");
    }
}
