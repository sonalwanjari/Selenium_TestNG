package TestNG;

import org.testng.annotations.Factory;

public class FactoryDemo {

    @Factory
    public Object[] factoryMethod() {
        return new Object[] {
                new SampleTest(1),
                new SampleTest(2),
                new SampleTest(3)
        };
    }
}
