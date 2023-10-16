package firsttask.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import utilities.BrowserDrivers;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class MyEdgeDriver implements BrowserDrivers {

    @Override
    public WebDriver setUpBrowser() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        return new EdgeDriver(edgeOptions);
    }
}
