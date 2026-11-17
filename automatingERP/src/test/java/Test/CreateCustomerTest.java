package Test;

import org.testng.annotations.Test;

import POM.CustomersPage;
import POM.LoginPage;
import base.BaseTest;

public class CreateCustomerTest extends BaseTest {

            //this test is designed to validate creation of a customer
    @Test
        public void createCustomerTest() throws InterruptedException {
        LoginPage LoginPageMethods = new LoginPage(super.driver);
        driver.get(HOMEPAGE);
        LoginPageMethods.enterUsername("");
        LoginPageMethods.enterPassword("");
        LoginPageMethods.clickLogin();

        CustomersPage customersPageMethods = new CustomersPage(super.driver);

        customersPageMethods.clickCustomers();
        customersPageMethods.customerAddNew();
        customersPageMethods.fillCompanyName();
        customersPageMethods.selectTitleCustomer();
        customersPageMethods.enterFirstName("Nikki");
        customersPageMethods.enterLastName("Minaj");
        customersPageMethods.enterJobTitle("Dancer");
        customersPageMethods.enterPhoneNum("052634796");
        customersPageMethods.enterMobileNum("+888123123");
        customersPageMethods.enterEmail("stefan@stefan.bg");
        customersPageMethods.enterAddress("kap.Petko Voivoda");
        customersPageMethods.enterAddress2("fake address to fool people");
        customersPageMethods.enterTown("Hull");
        customersPageMethods.enterCounty("Dont know what this is");
        customersPageMethods.enterPostCode("9000");
        customersPageMethods.selectCountry();
        customersPageMethods.enterCustomerDiscount("23");
        customersPageMethods.selectPriceList();
   //     customersPageMethods.selectDefCurrency();   //method is disabled because the default currency is GBP, all automated cases run in GBP
        customersPageMethods.selectTaxRate();
        customersPageMethods.selectTaxNumber("5");
        customersPageMethods.selectPaymentTerms();
        customersPageMethods.saveCustomer();
        customersPageMethods.dataSavedPopUp();
        Thread.sleep(5000); // this is because sometimes you need a second save to register the user in Xero/QB
        customersPageMethods.saveCustomer();
        customersPageMethods.checkForXeroRef();     //check for Xero account ref
        customersPageMethods.clickCustomers();
        customersPageMethods.enterCustomer();
        customersPageMethods.checkCustomerResult();
    }
}

