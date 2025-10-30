package TestNG;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SampleTestReporter {
        @Test
        public void reporterPass() {
            System.out.println("Running reporterPass");
            Assert.assertEquals(1, 1); // will pass
        }

        @Test
        public void reporterFail() {
            System.out.println("Running reporterFail");
            Assert.assertEquals(1, 2); // will fail
        }

        @Test(dependsOnMethods = "reporterFail") //Only run this test if reporterFail passes successfully. Otherwise, skip it.
        public void reporterSkip() {
            System.out.println("Running reporterSkip");
            // This will be skipped because reporterFail fails
        }
    }
