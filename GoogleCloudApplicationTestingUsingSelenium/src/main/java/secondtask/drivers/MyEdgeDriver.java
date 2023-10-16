package secondtask.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.BrowserDrivers;

public class MyEdgeDriver implements BrowserDrivers {
    @Override
    public WebDriver setUpBrowser() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
