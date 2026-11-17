package Test;
import org.testng.annotations.Test;

import POM.LoginPage;
import base.BaseTest;

public class LoginTest extends BaseTest {

            //A simple Login test
    @Test
        public void loginTest() throws InterruptedException {
        LoginPage LoginPageMethods =new LoginPage(super.driver);
        driver.get(HOMEPAGE);
        LoginPageMethods.enterUsername("");
        LoginPageMethods.enterPassword("");
        LoginPageMethods.clickLogin();
        LoginPageMethods.assertWeAreLogged();
        LoginPageMethods.logOut();
    }
}
