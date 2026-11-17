package test;
import POM.LoginPage;
import POM.ProductsPage;
import base.BaseTest;
import org.testng.annotations.Test;
public class Scenario2 extends BaseTest {

    @Test(groups = "sanity")
    public void testScenario2(){
        LoginPage loginPageMethods = new LoginPage(super.driver,log);
        driver.get(PRODUCTION_URL);
        loginPageMethods.enterUsernameByIndex(1);
        loginPageMethods.enterPassword();
        loginPageMethods.clickLoginButton();

        ProductsPage productsPageMethods = new ProductsPage(driver, log);
        productsPageMethods.selectFilterHighToLow();
        productsPageMethods.verifyPricesHighToLow();
        productsPageMethods.openNavBarMenu();
        productsPageMethods.clickLogout();
    }
}
