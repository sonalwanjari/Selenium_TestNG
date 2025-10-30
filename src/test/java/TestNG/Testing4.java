package TestNG;

import org.testng.annotations.*;

public class Testing4 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest: Runs once before all test methods");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod: Runs before each test method");
    }

    @Test
    public void testMethod1() {
        System.out.println("Executing Test Method 1");
    }

    @Test
    public void testMethod2() {
        System.out.println("Executing Test Method 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod : Runs after each test method");
    }


    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest: Runs once after all test methods");
    }

}

