package TestNG;

import org.testng.annotations.Test;

public class Grouping {

    @Test(groups = {"regression"})
    public void registrationTest() {
        System.out.println("Registration testing group");
    }

    @Test(groups = {"smoke"})
    public void loginTest() {
        System.out.println("Login test - Smoke Testing Group");
    }

    @Test(groups = {"smoke" , "regression"})
    public void SRTest() {
        System.out.println("S.R test - Belongs to Smoke & Regression");
    }
}

