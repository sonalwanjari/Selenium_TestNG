package TestNG;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class CustomReporter implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for (ISuite suite : suites) {
            String suiteName = suite.getName();
            Map<String, ISuiteResult> results = suite.getResults();

            for (ISuiteResult sr : results.values()) {
                ITestContext tc = sr.getTestContext();
                System.out.println("Suite: " + suiteName);
                System.out.println("Passed: " + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed: " + tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped: " + tc.getSkippedTests().getAllResults().size());
            }
        }
    }
}
