package testngtask;

import org.testng.annotations.*;

public class Configurations {
    @BeforeSuite
    public void setUp() {
        System.out.println("inside setUp");
    }

    @BeforeTest
    public void beforetest() {
        System.out.println("inside test");
    }

    @BeforeClass
    public void besideClass() {
        System.out.println("inside class");
    }

    @BeforeMethod
    public void besideMethod() {
        System.out.println("inside method");
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("outside method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("outside class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("outside test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("outside setUp");
    }
}
