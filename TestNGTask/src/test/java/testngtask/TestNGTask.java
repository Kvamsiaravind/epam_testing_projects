package testngtask;

import calculatortask.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestNGTask {
    Calculator calculator = new Calculator();

    @Test(groups = {"pass"})
    public void add() {
        System.out.println("positive unit test using add()");
        System.out.println(System.currentTimeMillis());
        System.out.println(Thread.currentThread().threadId());
        Assert.assertEquals(calculator.sum(1, 2), 3);
    }

    @Test(groups = {"pass"})
    public void subt() {
        System.out.println("positive unit test using subt()");
        System.out.println(System.currentTimeMillis());
        System.out.println(Thread.currentThread().threadId());
        Assert.assertEquals(calculator.sub(2, 1), 1);
    }

    @Test(groups = {"pass"})
    public void mult() {
        System.out.println("positive unit test using mult()");
        System.out.println(Thread.currentThread().threadId());
        System.out.println(System.currentTimeMillis());

        Assert.assertEquals(calculator.mult(5, 6), 30);
    }

    @Test(groups = {"pass"})
    public void divide() {
        System.out.println("positive unit test using divide()");
        System.out.println(Thread.currentThread().threadId());
        System.out.println(System.currentTimeMillis());

        Assert.assertEquals(calculator.div(35, 5), 7);
    }

    @Test(groups = {"pass"})
    public void power() {
        System.out.println("positive unit test using pow()");
        System.out.println(Thread.currentThread().threadId());
        System.out.println(System.currentTimeMillis());

        Assert.assertEquals(calculator.pow(2, 5), 32);
    }


    @Test(groups = "fail", dependsOnGroups = "pass")
    public void addition() {
        System.out.println("negative unit test using addition()");
        Assert.assertFalse(calculator.sum(1, -2)== 1);
    }

    @Test(groups = "fail", dependsOnGroups = "pass")
    public void subtraction() {
        System.out.println("negative unit test using subtraction()");
        Assert.assertFalse(calculator.sub(1, 1)== 2);
    }

    @Test(groups = "fail", dependsOnGroups = "pass")
    public void multiplication() {
        System.out.println("negative unit test using multiplication()");
        Assert.assertFalse(calculator.mult(5, 6)== 40);
    }

    @Test(groups = "fail", dependsOnGroups = "pass")
    public void dividing() {
        System.out.println("negative unit test using dividing()");
        Assert.assertFalse(calculator.div(5, -5)== 7);
    }

    @Test(groups = "fail", dependsOnGroups = "pass")
    public void square() {
        System.out.println("negative unit test using square()");
        Assert.assertFalse(calculator.pow(2, 5)== 64);
    }


}
