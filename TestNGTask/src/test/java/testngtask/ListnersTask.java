package testngtask;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersTask implements ITestListener {
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("status using Listeners " + iTestResult.getStatus());
    }
}
