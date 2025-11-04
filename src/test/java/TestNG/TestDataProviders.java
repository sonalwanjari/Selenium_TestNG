package TestNG;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "externalData")
    public static Object[][] externalData() {
        return new Object[][] {
            {"externalValue1"},
            {"externalValue2"}
        };
    }
}
