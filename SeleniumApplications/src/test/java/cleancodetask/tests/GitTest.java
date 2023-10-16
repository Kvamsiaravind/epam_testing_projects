package cleancodetask.tests;


import cleancodetask.pages.HomePage;
import cleancodetask.pages.SignInPage;
import cleancodetask.pages.StartPage;
import org.testng.annotations.Test;

public class GitTest extends ConfigurationTest {

    private SignInPage signInPage;

    @Test
    public void testGitHub() throws Exception {
        startPage = new StartPage(driver);
        startPage.open();
        startPage.invokeSignIn();
        signInPage.enterDetails();
    }
}
