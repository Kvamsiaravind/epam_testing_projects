package gprecwebdriverdemo;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GPRECWebDriverDemo {
    public WebDriver driver;

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsi_Kuruva\\Documents\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testVerifyGprecPage() {
        driver.get("https://www.gprec.ac.in/");

        driver.manage().window().maximize();
        WebElement student = driver.findElement(By.xpath("//div[@class='menu-footer-menu-container']/ul/li[2]/a"));
        student.click();

        WebElement username = driver.findElement(By.xpath("//div[@id='ContentHolder']/div/div[2]/div[2]/input"));
        username.sendKeys("199X1A0596");

        WebElement password = driver.findElement(By.xpath("//div[@id='ContentHolder']/div/div[3]/div[2]/input"));
        password.sendKeys("06062001");

        WebElement getDetails = driver.findElement(By.xpath("//div[@id='ContentHolder']/div/div[4]/div[1]/input"));
        getDetails.click();

        WebElement logout = driver.findElement(By.xpath("//div[@id='ContentHolder']/div/div//input"));
        logout.click();
    }

    @AfterTest
    public void testClose() {
        driver.close();
    }

    @AfterSuite
    public void tearUp() {
        driver.quit();
    }
}