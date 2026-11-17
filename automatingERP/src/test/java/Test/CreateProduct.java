package Test;

import org.testng.annotations.Test;

import POM.LoginPage;
import POM.ProductsPage;
import base.BaseTest;

public class CreateProduct extends BaseTest {
        //This test is designed to create a product

    @Test
    public void createProductTest() throws InterruptedException {
        LoginPage LoginPageMethods = new LoginPage(super.driver);
        driver.get(HOMEPAGE);
        LoginPageMethods.enterUsername("");
        LoginPageMethods.enterPassword("");
        LoginPageMethods.clickLogin();


        ProductsPage productPageMethods = new ProductsPage(super.driver);
//        productPageMethods.scrollToElement();
        productPageMethods.openProductCatalogue();
        productPageMethods.selectProducts();
        productPageMethods.addNewProduct();
        productPageMethods.enterItemCode();
        productPageMethods.selectSellTax();
        productPageMethods.enterDefSellPrice("190");
        productPageMethods.enterOverrideCostPrice("192");
        productPageMethods.enterAdditionalCosts("15");
        productPageMethods.selectUnitOfMeasure();
        productPageMethods.enterProductDescription();
        productPageMethods.selectCategory();
        productPageMethods.selectSubCategory();
        productPageMethods.enterLeadTime("5");
        productPageMethods.enterProductWeight("1500");
        productPageMethods.enterProdVolume("0.5");
        productPageMethods.enterProdDimensions("2", "2" , "5");
        productPageMethods.enterMinStockQt("10");
        productPageMethods.enterMaxStockQt("101");
//        productPageMethods.enterMinPurchaseQt(); //Set to 1 by default
        productPageMethods.saveProduct();
        productPageMethods.addCustomer();
        productPageMethods.searchForTheProduct();
        productPageMethods.checkSearchResult();
        Thread.sleep(5000);
    }
}
