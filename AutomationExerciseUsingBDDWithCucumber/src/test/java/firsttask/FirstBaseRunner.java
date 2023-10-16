package firsttask;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "stepdefs",
        features = {"src/test/resources/features/CucumberFirstTask.feature"})
public class FirstBaseRunner extends AbstractTestNGCucumberTests {

}
