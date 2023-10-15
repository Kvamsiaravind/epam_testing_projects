package testngtask;

import calculatortask.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

@Test(singleThreaded = true)
public class Parameterized extends Configurations {

    Calculator calculator = new Calculator();

    @Test(dataProviderClass = DataProviderForParameterized.class, dataProvider = "testSubtractionDataUsingDataProvider")
    public void testSubtractionDataUsingDataProvider(long firstNumber, long secondNumber, long expectedResult) {
        System.out.println("Thread " + Thread.currentThread().threadId());
        Assert.assertEquals(calculator.sub(firstNumber, secondNumber), expectedResult, "test case passed");
    }

    @Test(dataProviderClass = DataProviderForParameterized.class, dataProvider = "testPerformAddUsingDataProvider")
    public void testPerformAddUsingDataProvider(long firstNumber, long secondNumber, long expectedResult) {
        System.out.println("Thread " + Thread.currentThread().threadId());
        Assert.assertEquals(calculator.sum(firstNumber, secondNumber), expectedResult, "test case passed");
    }


}
