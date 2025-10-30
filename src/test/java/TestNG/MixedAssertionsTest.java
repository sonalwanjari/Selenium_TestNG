package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MixedAssertionsTest {

    @Test
    public void loginThenValidateUI() {
        System.out.println("Starting mixed assertion test");

        // Critical check use hard assertion
        boolean isLoggedIn = true; // change to false to see hard assertion fail
        Assert.assertTrue(isLoggedIn, "Login failed. Cannot continue further checks");

        // After login, run multiple soft checks on UI elements
        SoftAssert softAssert = new SoftAssert();

        String actualTitle = "Dashboard";
        String expectedTitle = "Dashboard";
        softAssert.assertEquals(actualTitle, expectedTitle, "Title mismatch");

        String currentUrl = "https://example.com/dashboard";
        softAssert.assertTrue(currentUrl.contains("dashboard"), "URL does not contain dashboard");

        String userName = "Admin";
        softAssert.assertEquals(userName, "Admin", "Username is not correct");

        System.out.println("All secondary checks done. Now calling assertAll to report any soft assertion failures");
        softAssert.assertAll();
        System.out.println("Mixed assertion test finished");
    }
}
