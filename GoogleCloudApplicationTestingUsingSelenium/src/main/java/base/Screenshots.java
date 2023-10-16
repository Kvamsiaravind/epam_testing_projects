package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots {

    protected static WebDriver driver;

    public void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String timestamp = dateFormat.format(new Date());
        String destination = "C://Users//kvams//VAMSI_KURUVA//epam_rd_2023//epam_testing_projects//GoogleCloudApplicationTestingUsingSelenium//src//test//resources//screenshots/" + screenshotName + "_" + timestamp + ".png";
        File fileDestination = new File(destination);
        FileUtils.copyFile(source, fileDestination);
    }
}
