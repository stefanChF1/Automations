package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CustomersPage extends BasePage {
    @FindBy(xpath = "//a[normalize-space()='Customers']")
    private WebElement customers;
    @FindBy(xpath = "//a[contains(@class,'btn btn-success pull-right margin-left')]")
    private WebElement buttonAddNewCustomer;
    @FindBy(id = "1313company_name")
    private WebElement companyName;
    @FindBy(id = "2132title")
    private WebElement titleDropDown;
    @FindBy(id = "1314contact_first_name")
    private WebElement customerFirstName;
    @FindBy(id = "1315contact_last_name")
    private WebElement customerLastName;
    @FindBy(id = "1416job_title")
    private WebElement jobTitleField;
    @FindBy(id = "1316phone")
    private WebElement phoneNumField;
    @FindBy(id = "1317mobile")
    private WebElement mobileNumField;
    @FindBy(id = "1318email")
    private WebElement emailField;
    @FindBy(id = "1319address1")
    private WebElement addressField;
    @FindBy(id = "1320address2")
    private WebElement addressField2;
    @FindBy(id = "1321town")
    private WebElement townField;
    @FindBy(id = "1322county")
    private WebElement countyField;
    @FindBy(id = "1323postcode")
    private WebElement postCodeField;
    @FindBy(xpath= "//button[contains(@data-id,'1325country')]")
    private WebElement countryDropDown;
    @FindBy(id = "1325country")
    private WebElement countrySelectorValue;
    @FindBy(xpath = "//input[contains(@name,'1501customer_discount')]")
    private WebElement discountField;
    @FindBy(id = "1733default_currency")
    private WebElement defaultCurrencyField;
    @FindBy(id = "1474price_list_id")
    private WebElement priceListField;
    @FindBy(id = "1436default_tax_rate")
    private WebElement defaultTaxRateField;
    @FindBy(id = "1498tax_number")
    private WebElement taxNumberField;
    @FindBy(id = "1500payment_terms")
    private WebElement paymentTermsField;
    @FindBy(id = "1326xero_ref")
    private WebElement xeroRef;
    @FindBy(id = "saveButton")
    private WebElement saveButtonCustomer;
    @FindBy(id = "tableSearch")
    private WebElement searchForCustomer;
    @FindBy(xpath = "//*[@id=\"1032Table\"]/tbody/tr/td[1]")
    private WebElement searchResult;

    String newCustomerId;
    int randomNum;
    public CustomersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        randomNum = (int)(Math.random() * 10001);
    }

    public void scrollToElement() {
        new Actions(driver)
                .scrollToElement(customers)
                .perform();
    }
    public void clickCustomers(){
        customers.click();
    }
    public void customerAddNew(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddNewCustomer));
        buttonAddNewCustomer.click();
    }
    public void fillCompanyName(){
        newCustomerId = "customer" + randomNum;
        companyName.sendKeys(newCustomerId);
    }
    public String getCustomer(){
        return newCustomerId;
    }
    public void selectTitleCustomer(){
        Select titleDrop = new Select(titleDropDown);
        titleDrop.selectByValue("1002");
    }
    public void enterFirstName(String firstName){
        customerFirstName.sendKeys(firstName + randomNum);
    }
    public void enterLastName(String lastName){
        customerLastName.sendKeys(lastName + randomNum);
    }
    public void enterJobTitle(String jobTitle){
        jobTitleField.sendKeys(jobTitle);
    }
    public void enterPhoneNum(String phoneNum){
        phoneNumField.sendKeys(phoneNum);
    }
    public void enterMobileNum(String mobileNum){
        mobileNumField.sendKeys(mobileNum);
    }
    public void enterEmail(String email){
        emailField.sendKeys(randomNum + email);
    }
    public void enterAddress(String address){
        addressField.sendKeys(address);
    }
    public void enterAddress2(String address){
        addressField2.sendKeys(address);
    }
    public void enterTown(String town){
        townField.sendKeys(town);
    }
    public void enterCounty(String county){
        countyField.sendKeys(county);
    }
    public void enterPostCode(String postCode){
        postCodeField.sendKeys(postCode);
    }
    public void selectCountry(){
        Select countryOfResidence = new Select(countrySelectorValue);
        countryOfResidence.selectByValue("1186");
    }
    public void enterCustomerDiscount(String discount){
        discountField.sendKeys(discount);
    }
    public void selectPriceList(){
        Select priceListValue = new Select(priceListField);
        priceListValue.selectByValue("2");
    }
    public void selectDefCurrency(){
        Select defCurrencySelect = new Select(defaultCurrencyField);
        defCurrencySelect.selectByValue("1398");
    }
    public void selectTaxRate(){
        Select defTax = new Select(defaultTaxRateField);
        defTax.selectByValue("9");
    }
    public void selectTaxNumber(String taxNumber){
        taxNumberField.sendKeys(taxNumber);
    }
    public void selectPaymentTerms(){
        Select paymentTermsDays = new Select(paymentTermsField);
        paymentTermsDays.selectByValue("3");
    }
    public void checkForXeroRef() {
        String xeroRefNumber = xeroRef.getAttribute("data-wh-initial-value");
        if (xeroRefNumber == null || xeroRefNumber.isEmpty()) {
            System.out.print("User does not have Xero ref!");
        } else {
            System.out.print("User has Xero ref: " + xeroRefNumber);
        }
    }
    public void saveCustomer(){
        saveButtonCustomer.click();
    }
    public void dataSavedPopUp(){
    }
    public void enterCustomer() throws InterruptedException {
        String customer = getCustomer();
        searchForCustomer.sendKeys(customer);
        Thread.sleep(5000);
    }
    public void checkCustomerResult(){
        String actualCustomer = searchResult.getText();
        String customer = getCustomer();
        Assert.assertEquals(actualCustomer, customer);
        if (actualCustomer.equals(customer)){
            System.out.println("Found customer" + customer);
        } else {
            System.out.println("Did not find" + customer + "Found" + actualCustomer);
        }
    }
}
