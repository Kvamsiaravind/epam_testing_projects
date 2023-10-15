package testngtask;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGSampleTests {
    @Test
    public void testVerifyTwoIntegers() {
        System.out.println(System.currentTimeMillis());
        System.out.println("sample test integers --> " + Thread.currentThread().threadId());
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testVerifyTwoChars() {
        System.out.println(System.currentTimeMillis());

        System.out.println("sample test chars  --> " + Thread.currentThread().threadId());
        Assert.assertEquals('c', 'c');
    }

    @Test
    public void testVerifyTwoStrings() {
        System.out.println(System.currentTimeMillis());

        System.out.println("sample test strings  --> " + Thread.currentThread().threadId());
        Assert.assertEquals("gouse", "gouse");
    }
}
