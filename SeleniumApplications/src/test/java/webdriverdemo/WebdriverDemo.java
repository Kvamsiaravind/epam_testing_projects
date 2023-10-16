package webdriverdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebdriverDemo {

    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }

    @Test
    public void testVerifyFunctionality() throws InterruptedException {
        driver.get("https://www.selenium.dev/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.selenium.dev/documentation/");

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);
    }

    @Test
    public void testLocateWebElements() throws InterruptedException {
        driver.get("https://www.selenium.dev");
        driver.manage().window().maximize();

        WebElement search = driver.findElement(By.xpath("//div[@id='docsearch']/button/span/span"));
        search.click();

        WebElement searchInput = driver.findElement(By.id("docsearch-input"));
        searchInput.click();

        searchInput.sendKeys("selenium");
        Thread.sleep(5000);
        searchInput.submit();
    }

    @Test
    public void testUsingLocators() throws InterruptedException {

        driver.get("https://www.hackerrank.com/auth/login");

        WebElement email = driver.findElement(By.id("input-1"));
        email.sendKeys("kvamsiaravind@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Vamsi@06");

        WebElement login = driver.findElement(By.xpath("//div[@class='form-item clearfix']/button/div/span"));
        login.click();


        List<WebElement> loginButton = driver.findElements(By.tagName("button"));
        for (WebElement button : loginButton) {
            if (button.getText().equalsIgnoreCase("Log In")) {
                button.click();
            }
        }

        driver.get("https://www.google.com/");
        Thread.sleep(5000);

        WebElement pricingSection = driver.findElement(By.partialLinkText("mail"));
        pricingSection.click();
        Thread.sleep(5000);


        driver.findElement(By.linkText("Downloads")).click();
        Thread.sleep(5000);
    }

    @Test
    public void testUsingSomeMethods() {
        driver.get("https://www.hackerrank.com/");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        WebElement logIn = driver.findElement(By.linkText("pricing"));
        logIn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(driver.getCurrentUrl());
    }

    @AfterTest
    public void close() {
        driver.close();
    }

    @AfterSuite
    public void quit() {
        driver.quit();
    }
}
