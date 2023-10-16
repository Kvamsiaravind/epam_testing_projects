package listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.screenshots.Screenshots;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenersTestNG extends Screenshots implements ITestListener {
    private static final Logger logger = LogManager.getLogger(ListenersTestNG.class);

    public void onTestStart(ITestResult result) {
        logger.info("Test started " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test success " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("Test skipped :" + result.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            try {
                takeScreenshot(driver, iTestResult.getName());
            } catch (IOException ie) {
                throw new RuntimeException(ie);
            }
        }
    }
}
