package Test;

import org.testng.annotations.Test;

import POM.CustomerOrderPage;
import POM.InvoicePage;
import POM.LoginPage;
import base.BaseTest;

public class createCustomerOrder extends BaseTest {


    @Test
    public void createCustomerOrderTest() throws InterruptedException {
        CustomerOrderPage customerOrderPagePageMethods = new CustomerOrderPage(super.driver);
        driver.get(HOMEPAGE);

        InvoicePage invoicePageMethods = new InvoicePage(super.driver);


        LoginPage LoginPageMethods =new LoginPage(super.driver);
        driver.get(HOMEPAGE);

        LoginPageMethods.enterUsername("");
        LoginPageMethods.enterPassword("");
        LoginPageMethods.clickLogin();
        customerOrderPagePageMethods.openCoModule();
        customerOrderPagePageMethods.createCo();
        customerOrderPagePageMethods.selectCustomer();
        customerOrderPagePageMethods.selectOrderSource();
        customerOrderPagePageMethods.selectRequiredByDate();
        customerOrderPagePageMethods.enterCustomerRef();
        customerOrderPagePageMethods.enterDiscount();
        customerOrderPagePageMethods.saveCustomerOrder();
        customerOrderPagePageMethods.orderDetailAddNew();
        customerOrderPagePageMethods.chooseProduct();
        customerOrderPagePageMethods.enterQuantity("5");
        customerOrderPagePageMethods.enterUnitListPrice("20");
        customerOrderPagePageMethods.enterDiscount("12");
        customerOrderPagePageMethods.chooseTaxRate();
        customerOrderPagePageMethods.enterSellPrice("44");
        customerOrderPagePageMethods.saveOrderDetail();
        customerOrderPagePageMethods.createInvoice();
        invoicePageMethods.setPaymentTerms();
        invoicePageMethods.setDueDate("10-08-2026");
        invoicePageMethods.setDocumentComment("Document Comment");
        invoicePageMethods.setInternalNotes("Internal Notes");
        invoicePageMethods.setCurrency();
        invoicePageMethods.saveInvoice();
        invoicePageMethods.changeStatus();

    }
}
