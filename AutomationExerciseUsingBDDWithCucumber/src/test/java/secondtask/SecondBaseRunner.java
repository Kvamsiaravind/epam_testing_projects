package secondtask;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "stepdefs",
        features = {"src/test/resources/features/RegistrationCapability.feature"}
)
public class SecondBaseRunner extends AbstractTestNGCucumberTests {
}
