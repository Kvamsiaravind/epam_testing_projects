package locatorshometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static utilities.Utility.*;
import static waitsforselenium.Waits.*;

public class LocatorWebElements {

    protected WebDriver driver;
    private static final String BASE_URL = "http://the-internet.herokuapp.com";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsi_Kuruva\\Documents\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testCheckboxes() {
        driver.get(BASE_URL + "/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        clickOnFields(driver, firstCheckbox, 5);
        WebElement secondCheckbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        clickOnFields(driver, secondCheckbox, 5);
    }

    @Test
    public void testDynamicContent() {
        driver.get(BASE_URL + "/dynamic_content");
        String textBeforeClick = driver.findElement(By.xpath("//div[@class='large-10 columns']")).getText();
        WebElement clickHere = driver.findElement(By.linkText("click here"));
        clickOnFields(driver, clickHere, 5);
        String textAfterClick = driver.findElement(By.xpath("//div[@class='large-10 columns']")).getText();
        Assert.assertNotEquals(textBeforeClick, textAfterClick);
    }

    @Test
    public void testWindows() {
        driver.get(BASE_URL + "/windows");
        WebElement clickHere = driver.findElement(By.partialLinkText("Click Here"));
        clickOnFields(driver, clickHere, 5);
        String mainWindowId = driver.getWindowHandle();
        Set<String> newWindowIds = driver.getWindowHandles();
    }

    @Test
    public void testAlerts() {
        driver.get(BASE_URL + "/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickOnFields(driver, jsAlert, 5);
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String resultAfterText = result.getText();
        Assert.assertEquals(resultAfterText, "You successfully clicked an alert");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickOnFields(driver, jsConfirm, 5);
        driver.switchTo().alert().dismiss();
        String resultAfterJsConfirm = result.getText();
        Assert.assertEquals(resultAfterJsConfirm, "You clicked: Cancel");
        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickOnFields(driver, jsPrompt, 5);
        driver.switchTo().alert().sendKeys("jsPrompt alert clicked ok.");
        driver.switchTo().alert().accept();
        String resultAfterJsPrompt = result.getText();
        Assert.assertEquals(resultAfterJsPrompt, "You entered: jsPrompt alert clicked ok.");
    }

    @Test
    public void testInputs() {
        driver.get(BASE_URL + "/inputs");
        WebElement inputNumber = driver.findElement(By.xpath("//input[@type='number']"));
        sendKeysIntoField(driver, inputNumber, "11111");
    }

    @Test
    public void testDropdowns() {
        driver.get(BASE_URL + "/dropdown");
        Select select = new Select(driver.findElement(By.xpath("//*[@id='dropdown']")));

        if (select.isMultiple()) {
            select.selectByIndex(1);
            select.selectByVisibleText("Option 2");
        }
        select.selectByIndex(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
    }

    @Test
    public void testNestedFrames() {
        driver.get(BASE_URL + "/nested_frames");
        WebElement bottomFrame = driver.findElement(By.name("frame-bottom"));
        WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topFrame);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(bottomFrame);
        String bottomFrameName = driver.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(bottomFrameName, "BOTTOM");
        driver.switchTo().parentFrame();
        driver.switchTo().frame(topFrame);
        WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(leftFrame);
        String leftFrameName = driver.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(leftFrameName, "LEFT");
        driver.switchTo().parentFrame();
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(middleFrame);
        String middleFrameName = driver.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(middleFrameName, "MIDDLE");
        driver.switchTo().parentFrame();
        WebElement rightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));
        driver.switchTo().frame(rightFrame);
        String rightFrameName = driver.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(rightFrameName, "RIGHT");
    }

    @Test
    public void testTinymce() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(BASE_URL + "/tinymce");
        waitUntilFrameToBeAvailable(driver, By.id("mce_0_ifr"), 5);
        WebElement content = waitUntilVisible(driver, By.id("tinymce"), 5);
        clearTheContent(driver, content, 5);
        content.sendKeys("This is first statement");
        driver.switchTo().parentFrame();
        WebElement italicButton = driver.findElement(By.xpath("//button[@aria-label='Italic']"));
        waitUntilClick(driver, italicButton, 5);
        WebElement alignCenter = driver.findElement(By.xpath("//button[@title='Align center']"));
        waitUntilClick(driver, alignCenter, 5);
        WebElement undoButton = driver.findElement(By.xpath("//button[@aria-label='Undo']"));
        waitUntilClick(driver, undoButton, 5);
    }

    @Test
    public void testTables() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(BASE_URL + "/tables");
        List<WebElement> firstRowBeforeEmailSort = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        List<String> firstRowDetailsBeforeEmailSort = getDataFromWebElements(firstRowBeforeEmailSort);
        WebElement emailButton = driver.findElement(By.xpath("//table[@id='table1']/thead//th/span[contains(text(),'Email')]"));
        clickOnFields(driver, emailButton, 5);
        List<WebElement> firstRowAfterEmailSort = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        List<String> firstRowDetailsAfterEmailSort = getDataFromWebElements(firstRowAfterEmailSort);
        sortEmployeeData(firstRowDetailsAfterEmailSort, firstRowDetailsBeforeEmailSort);
        Assert.assertNotEquals(firstRowDetailsBeforeEmailSort, firstRowAfterEmailSort);
    }

    @Test
    public void testPainter() {
        driver.get("https://www.youidraw.com/apps/painter/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement whiteBoard = driver.findElement(By.xpath("//canvas[@id='painter']"));
        actions.moveToElement(whiteBoard)
                .clickAndHold()
                .moveByOffset(0, 100)
                .moveByOffset(-150, 100)
                .pause(Duration.ofSeconds(5))
                .moveByOffset(200, -100)
                .moveByOffset(0, -100)
                .release()
                .build()
                .perform();
    }

    @AfterTest
    public void tearUp() {
        driver.close();
    }

    @AfterSuite
    public void tearUpQuit() {
        driver.quit();
    }

}
