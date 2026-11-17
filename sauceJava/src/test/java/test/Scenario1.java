package test;
import POM.BasePage;
import POM.LoginPage;
import POM.ProductsPage;
import base.BaseTest;
import org.testng.annotations.Test;

public class Scenario1 extends BaseTest {

    @Test(groups = "e2e")
    public void testScenario1(){
        LoginPage loginPageMethods = new LoginPage(super.driver,log);
        driver.get(PRODUCTION_URL);
        loginPageMethods.enterUsernameByIndex(1);
        loginPageMethods.enterPassword();
        loginPageMethods.clickLoginButton();

        ProductsPage productsPageMethods = new ProductsPage(driver, log);
        productsPageMethods.getNumberButton();
        var arrLi = productsPageMethods.getNumberButton();
        productsPageMethods.addProduct(arrLi.indexOf(arrLi.getFirst()), arrLi);
        productsPageMethods.addProduct(arrLi.indexOf(arrLi.getLast()), arrLi);
        productsPageMethods.removeProduct(arrLi.indexOf(arrLi.getLast()), arrLi);
        productsPageMethods.addProduct(arrLi.size()-2,arrLi);

        BasePage basePageMethods = new BasePage(driver, log);
        basePageMethods.goToCart();
        productsPageMethods.clickCheckOut();
        productsPageMethods.enterFirstName("Stefan");
        productsPageMethods.enterLastName("Stoyanov");
        productsPageMethods.enterPostCode("9000");
        productsPageMethods.enterDetailsContinueButton();
        productsPageMethods.finishOrderButton();
        productsPageMethods.verifyOrderWasSent();
        basePageMethods.goToCart();
        productsPageMethods.verifyCartIsEmpty();
        productsPageMethods.openNavBarMenu();
        productsPageMethods.clickLogout();
    }
}
