package TestNG;

import org.testng.annotations.Test;

public class SampleTest {
    int param;

    public SampleTest(int param) {
        this.param = param;
    }

    @Test
    public void testMethod() {
        System.out.println("Running test with param: " + param);
    }
}
