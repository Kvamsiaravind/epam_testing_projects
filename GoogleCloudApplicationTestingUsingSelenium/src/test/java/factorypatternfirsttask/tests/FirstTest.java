package factorypatternfirsttask.tests;

import factorypatternfirsttask.basetest.Configuration;
import firsttask.homepages.HomePage;
import org.testng.annotations.Test;


public class FirstTest extends Configuration {

    private HomePage homePage;

    @Test
    public void testFactoryPattern() {
        homePage = new HomePage(driver);
    }
}
