package POM;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static base.BaseTest.getRandomValue;

public class CustomerOrderPage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Customer Orders']")
    private WebElement selectCustomerOrder;
    @FindBy(xpath = "//a[normalize-space()='Add New']")
    private WebElement addNewCustomerOrder;
    @FindBy(id = "1166customer_id")
    private WebElement chooseCustomer;
    @FindBy(id = "saveButton")
    private WebElement saveButton;
    @FindBy(id = "1011addNew")
    private WebElement addNewOrderDetail;
    @FindBy(id = "1103product_id")
    private WebElement modalEnterProductField;
    @FindBy(id = "2179order_source")
    private WebElement orderSource;
    @FindBy(id = "1185customer_ref")
    private WebElement customerRef;
    @FindBy(id = "1692order_discount")
    private WebElement discount;
    @FindBy(id = "1438tax_rate_id")
    private WebElement taxRateDropdown;
    @FindBy(id = "1506despatch_location")
    private WebElement selectDespatchStockLocation;
    @FindBy(id = "1419required_by_date")
    private WebElement requiredDByDate;
    @FindBy(id = "1104order_quantity")
    private WebElement modalQuantityField;
    @FindBy(id = "1148list_price")
    private WebElement modalUnitListPriceField;
    @FindBy(id = "1147discount_pct")
    private WebElement modalDiscountField;
    @FindBy(id = "1106sell_price")
    private WebElement modalUnitSellPriceField;
    @FindBy(id = "1156tax_rate_id")
    private WebElement modalProdTaxRateField;
    @FindBy(id = "saveModalButton")
    private WebElement modalSaveButton;
    @FindBy(id = "dataEntrySaveSuccess")
    private WebElement successMessage;
    @FindBy(id = "modalSaveSuccess")
    private WebElement modalSuccessMessage;
    @FindBy(id = "1016addNew")
    private WebElement addNewInvoiceOrder;
    @FindBy(id = "1138customer_id")
    private WebElement invoiceCustomer;

    String randomCustomer;

    public CustomerOrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        int randomNum = (int) (Math.random() * 10001);
    }
    public void openCoModule() {
        selectCustomerOrder.click();
    }
    public void createCo(){
        addNewCustomerOrder.click();
    }
    public void selectCustomer(){
        Select sup = new Select(chooseCustomer);
        String randomCustomer = getRandomValue(sup);
        sup.selectByValue(randomCustomer);
    }
    public String getCustomer(){
        return randomCustomer;
    }
    public void selectOrderSource(){
        Select from = new Select(orderSource);
        String whereFrom = getRandomValue(from);
        from.selectByValue(whereFrom);
    }
    public void selectRequiredByDate(){
        requiredDByDate.sendKeys("11-11-2026");
    }
    public void enterCustomerRef(){
        customerRef.sendKeys("warranty 20.01.2027");
    }
    public void enterDiscount(){
        discount.sendKeys("5");
    }
    public void saveCustomerOrder(){
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.getText().contains("Customer Orders record saved"));
    }
    public void orderDetailAddNew(){
        addNewOrderDetail.click();
    }
    public void chooseProduct(){
        Select prod = new Select(modalEnterProductField);
        String randomProd = getRandomValue(prod);
        prod.selectByValue(randomProd);
    }
    public void enterQuantity(String Qty){
        modalQuantityField.sendKeys(Qty);
    }
    public void enterUnitListPrice(String listPr){
        modalUnitListPriceField.sendKeys(listPr);
    }
    public void enterDiscount(String discount){
        modalDiscountField.sendKeys(discount);
    }
    public void chooseTaxRate(){
        Select tax = new Select(modalProdTaxRateField);
        String randomTax = getRandomValue(tax);
        tax.selectByValue(randomTax);;
    }
    public void saveOrderDetail(){
        modalSaveButton.click();
        wait.until(ExpectedConditions.visibilityOf(modalSuccessMessage));
        Assert.assertTrue(modalSuccessMessage.getText().contains("Order Detail detail record saved"));
        }
    public void enterSellPrice(String sellPrice){
        modalUnitSellPriceField.sendKeys(sellPrice);
        }
        public void createInvoice(){
            addNewInvoiceOrder.click();
    }
}
