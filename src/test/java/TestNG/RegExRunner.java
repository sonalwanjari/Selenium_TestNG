package TestNG;

import org.testng.TestNG;

import java.util.Collections;

public class RegExRunner {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(Collections.singletonList("testing.xml"));
        testng.run();
    }
}
