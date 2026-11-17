package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static base.BaseTest.getRandomValue;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@data-target,'#nav-sidebar-collapse-1009')]")
    private WebElement productsCatalogDropdown;
    @FindBy(xpath = "//a[normalize-space()='Products']")
    private WebElement selectProductsFromDropdown;
    @FindBy(xpath = "//a[normalize-space()='Add New']")
    private WebElement addNewProductButton;
    @FindBy(id = "1099item_code")
    private WebElement itemCode;
    @FindBy(xpath = "//*[@id=\"1100product_desc\"]")
    private WebElement productDescription;
    @FindBy(id = "1440sell_tax_rate_id")
    private WebElement sellTaxRateDropDown;
    @FindBy(id = "1102sell_price")
    private WebElement defaultSellPrice;
    @FindBy(id = "2003override_cost_price")
    private WebElement overrideCostPrice;
    @FindBy(id = "1966additional_costs")
    private WebElement additionalCosts;
    @FindBy(id = "1722unit_of_measure")
    private WebElement unitOfMeasureDropdown;
    @FindBy(id = "saveButton")
    private WebElement saveButton;
    @FindBy(id = "1483product_category")
    private WebElement productCategoryDropdown;
    @FindBy(id = "1839product_subcategory")
    private WebElement subCategoryDropdown;
    @FindBy(id = "2458lead_time_weeks")
    private WebElement leadTimeWeeksField;
    @FindBy(id = "1834gross_weight")
    private WebElement grossProductWeight;
    @FindBy(id = "1977product_volume")
    private WebElement productVolumeField;
    @FindBy(id = "1978product_dimensions")
    private WebElement productDimensions;
    @FindBy(id = "1489min_stock_qty")
    private WebElement minStockQty;
    @FindBy(id = "1490max_stock_qty")
    private WebElement maxStockQty;
    @FindBy(id = "3043min_purchase_qty")
    private WebElement minPurchaseQty;
    @FindBy(id = "tableSearch")
    private WebElement productSearch;
    @FindBy(xpath = "/html/body/div[4]/div/div[3]/div[5]/div/div[1]/table/tbody/tr/td[1]")
    private WebElement searchResult;
    @FindBy(xpath = "//*[@id=\"1060SysDetailTableDiv\"]/div[1]")
    private WebElement supplierDropdownCollapse;
    @FindBy(id = "1060addNew")
    private WebElement addNewSupplier;
    @FindBy(id = "1638supplier_id")
    private WebElement modalSupplierField;
    @FindBy(id = "1441purchase_tax_rate_id")
    private WebElement modalTaxRate;
    @FindBy(id = "1491purchase_currency")
    private WebElement modalCurrency;
    @FindBy(id = "1101cost_price")
    private WebElement modalCostPrice;
    @FindBy(id = "saveModalButton")
    private WebElement modalSave;

    String generatedItemCode;
    int randomNum;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        randomNum = (int) (Math.random() * 10001);
    }

    public void scrollToElement() {
        new Actions(driver)
                .scrollToElement(productsCatalogDropdown)
                .perform();
    }

    public void openProductCatalogue() {
        productsCatalogDropdown.click();
    }

    public void selectProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(selectProductsFromDropdown));
        selectProductsFromDropdown.click();
    }

    public void addNewProduct() {
        addNewProductButton.click();
    }

    public void enterItemCode() {
        generatedItemCode = "prod" + randomNum;
        itemCode.sendKeys(generatedItemCode);
    }

    public String getItemCode() {
        return generatedItemCode;
    }

    public void enterProductDescription() throws InterruptedException {
        productDescription.sendKeys("This is the product description");
    }

    public void selectSellTax() {
        Select taxDrop = new Select(sellTaxRateDropDown);
        taxDrop.selectByValue("4");
    }

    public void enterDefSellPrice(String num) {
        defaultSellPrice.sendKeys(num);
    }

    public void enterOverrideCostPrice(String numb) {
        overrideCostPrice.sendKeys(numb);
    }

    public void enterAdditionalCosts(String addCosts) {
        additionalCosts.sendKeys(addCosts);
    }

    public void selectUnitOfMeasure() {
        Select uni = new Select(unitOfMeasureDropdown);
        uni.selectByValue("1404");
    }

    public void saveProduct() {
        saveButton.click();
    }

    public void selectCategory() {
        Select prodCat = new Select(productCategoryDropdown);
        String randomProdCat = getRandomValue(prodCat);
        prodCat.selectByValue(randomProdCat);
    }

    public void selectSubCategory() {
        Select subCat = new Select(subCategoryDropdown);
        String randomProdCat = getRandomValue(subCat);
        subCat.selectByValue(randomProdCat);
    }

    public void enterLeadTime(String leadWeeks) {
        leadTimeWeeksField.sendKeys(leadWeeks);
    }

    public void enterProductWeight(String prodWeight) {
        grossProductWeight.sendKeys(prodWeight);
    }

    public void enterProdVolume(String prodVolume) {
        productVolumeField.sendKeys(prodVolume);
    }

    public void enterProdDimensions(String a , String b ,String c) {
        productDimensions.sendKeys(a , b ,c);
    }

    public void enterMinStockQt(String minStock) {
        minStockQty.sendKeys(minStock);
    }

    public void enterMaxStockQt(String maxStock) {
        maxStockQty.sendKeys(maxStock);
    }

    public void enterMinPurchaseQt() {
        minPurchaseQty.sendKeys("1");
    }

    public void searchForTheProduct() throws InterruptedException {
        Thread.sleep(2000);
        selectProductsFromDropdown.click();
        String item = getItemCode();
        productSearch.sendKeys(item);
        Thread.sleep(5000);
    }

    public void checkSearchResult() {
        String actualItem = searchResult.getText();
        String item = getItemCode();
        Assert.assertEquals(actualItem, item);

        if (actualItem.equals(item)) {
            System.out.println("Found " + item);
        } else {
            System.out.println("Did not find" + item + ", Found: " + actualItem);
        }
    }

    public void addCustomer(){
        supplierDropdownCollapse.click();
        addNewSupplier.click();
        Select sup = new Select(modalSupplierField);
        String randomSupplier = getRandomValue(sup);
        sup.selectByValue(randomSupplier);
        Select tax = new Select(modalTaxRate);
        String randomTax = getRandomValue(tax);
        tax.selectByValue(randomTax);
        //this is disabled because every Supplier has default currency and it is autopopulated
//        Select cur = new Select(modalCurrency);
//        String randomCurr = getRandomValue(cur);
//        cur.selectByValue(randomCurr);
        modalCostPrice.sendKeys("222");
        modalSave.click();

    }
}

