package testngtask;

import calculatortask.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BugTest {

    Calculator calculator = new Calculator();


    @Test(groups = "bugsGroup", dataProviderClass = DataProviderForParameterized.class, dataProvider = "testDataForBugTests")
    public void testLongVerify(double firstNumber, double secondNumber, double expected) {
        Assert.assertEquals(calculator.sum(firstNumber, secondNumber), expected);
    }

    @Test(groups = "bugsGroup", dataProviderClass = DataProviderForParameterized.class, dataProvider = "testPowerData")
    void testDoublePower(Double x, Double y, Double expected) {
        Assert.assertEquals(calculator.pow(x, y), expected);
    }

    @Test(groups = "bugsGroup", dataProviderClass = DataProviderForParameterized.class, dataProvider = "testCosData")
    public void testDoubleCos(Double x, Double expected) {
        Assert.assertEquals(calculator.cos(x), expected);
    }

    @Test(groups = "bugsGroup", dataProviderClass = DataProviderForParameterized.class, dataProvider = "testSqrtData")
    void testDoubleSqrt(Double x, Double expected) {
        Assert.assertEquals(calculator.sqrt(x), expected);
    }

    @Test(groups = "bugsGroup", dataProviderClass = DataProviderForParameterized.class, dataProvider = "testTanData")
    void testDoubleTg(Double x, Double expected) {
        Assert.assertEquals(calculator.tg((Double) x), expected);
    }
}
