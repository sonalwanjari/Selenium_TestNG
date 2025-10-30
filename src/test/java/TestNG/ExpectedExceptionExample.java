package TestNG;

import org.testng.annotations.Test;

public class ExpectedExceptionExample {

    // Example 1: Single exception
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        int x = 6 / 0;  // Throws ArithmeticException
        System.out.println("This line will not execute");
    }

    // Example 2: Multiple possible exceptions
    @Test(expectedExceptions = {NullPointerException.class, IllegalArgumentException.class})
    public void testMultipleExceptions() {
        throw new NullPointerException("Null value found");
        // Test passes since NullPointerException is listed
    }
}
