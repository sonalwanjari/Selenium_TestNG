package TestNG;

import org.testng.annotations.*;

public class Testing3 {
    @BeforeTest
    public void beforeTest(){
        System.out.println("This is a before test method, it will be executed before all @test method");
    }

    @Test
    public void testcase1(){
        System.out.println("Test Case 1");
    }

    @Test
    public void testcase2(){
        System.out.println("Test Case 2");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("This is a Afer test method, it will be executed after all @test method");
    }
    }
