package testngtask;

import calculatortask.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExceptionTest {
    Calculator calculator = new Calculator();

    @Test(expectedExceptions = NumberFormatException.class)
    public void testDivisionOfTwoNumber() {
        System.out.println("Expected exception ");

        long result = calculator.div(6, 0);
        System.out.println(result);
        Assert.assertEquals(result, 0);
    }
}
