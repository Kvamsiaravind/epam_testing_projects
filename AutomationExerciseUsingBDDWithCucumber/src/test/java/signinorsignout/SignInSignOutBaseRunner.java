package signinorsignout;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "stepdefs",
        features = {"src/test/resources/features/SignInOrSignOut.feature"},
        tags = "@positive"
)
public class SignInSignOutBaseRunner extends AbstractTestNGCucumberTests {

}
