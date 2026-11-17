package POM;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class  ProductsPage extends BasePage {

    //Locators
    @FindBy(xpath = "//span[contains(@class,'shopping_cart_badge')])")
    private WebElement cartNumber;
    @FindBy(xpath = "//button[contains(@class,'btn')]")
    private WebElement button;
    @FindBy(id = "checkout")
    private WebElement checkOutButton;
    @FindBy(id = "first-name")
    private WebElement firstNameField;
    @FindBy(id = "last-name")
    private WebElement lastNameField;
    @FindBy(id = "postal-code")
    private WebElement postalCodeField;
    @FindBy(id = "continue")
    private WebElement continueCheckInfoButton;
    @FindBy(id = "finish")
    private WebElement finishOrderButton;
    @FindBy(xpath = "//h2[contains(@class, 'complete-header')]")
    private WebElement headerCompletedOrder;
    @FindBy(xpath = "//div[contains(@class, 'complete-text')]")
    private WebElement completedOrderText;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement navBarMenuButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public ProductsPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }
    public ArrayList getNumberButton() {
        List<WebElement> buttonsAdd = this.driver.findElements(By.xpath("//button[contains(@class,'btn')]"));
        return (ArrayList) buttonsAdd;
    }
    public void addProduct(int index, ArrayList allButtons) {
        if (index >= 0 && index < allButtons.size()) {
            WebElement button = (WebElement) allButtons.get(index);
            String actualText = button.getText();
            Assert.assertEquals(actualText, "Add to cart");
            button.click();
        }
    }
    public void removeProduct(int index, ArrayList allButtons) {
        if (index >= 0 && index < allButtons.size()) {
            this.wait.until(ExpectedConditions.visibilityOf(button));
            String actualText = button.getText();
            Assert.assertEquals(actualText, "Remove");
            button.click();
        }
    }
    public void clickCheckOut() {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        boolean checkOutButtonClickable = checkOutButton.isDisplayed();
        Assert.assertTrue(checkOutButtonClickable, "Checkout button not clickable!");
        checkOutButton.click();
    }
    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        boolean firstNameFieldVisible = firstNameField.isDisplayed();
        Assert.assertTrue(firstNameFieldVisible, "First name field is not visible!");
        firstNameField.sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        boolean lastNameFieldVisible = lastNameField.isDisplayed();
        Assert.assertTrue(lastNameFieldVisible, "Last name field is not visible!");
        lastNameField.sendKeys(lastName);
    }
    public void enterPostCode(String postalCode) {
        wait.until(ExpectedConditions.visibilityOf(postalCodeField));
        boolean postalCodeFieldVisible = postalCodeField.isDisplayed();
        Assert.assertTrue(postalCodeFieldVisible, "Postal code field is not visible!");
        postalCodeField.sendKeys(postalCode);
    }
    public void enterDetailsContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueCheckInfoButton));
        continueCheckInfoButton.click();
    }
    public void finishOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finishOrderButton));
        finishOrderButton.click();
    }
    public void verifyOrderWasSent() {
        String actualHeader = headerCompletedOrder.getText();
        Assert.assertEquals(actualHeader, "Thank you for your order!");
        String actualCompletedText = completedOrderText.getText();
        Assert.assertEquals(actualCompletedText,
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        System.out.println("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
    public void verifyCartIsEmpty() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'cart_item')]"));
        if (elements.isEmpty()) {
            System.out.println("Cart is empty!");
        } else {
            System.out.println("Cart not empty! WTF");
        }
    }
    public void openNavBarMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(navBarMenuButton));
        navBarMenuButton.click();
    }
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
        System.out.println("User logged out");
    }
    public void selectFilterHighToLow() {
        Select selectFilter = new Select(driver.findElement
                (By.xpath("//select[contains(@class,'product_sort_container')]")));
        selectFilter.selectByVisibleText("Price (high to low)");
    }
    public void verifyPricesHighToLow() {
        List<WebElement> priceElements =
                driver.findElements(By.xpath("//div[contains(@data-test, 'inventory-item-price')]"));
        double[] prices = priceElements.stream()
                .map(WebElement::getText)                  // Extract text
                .map(text -> text.replaceAll("[^0-9.]", "")) // Remove currency symbols, commas, etc.
                .mapToDouble(Double::parseDouble)         // Convert to double
                .toArray();                               // Convert to double array
        boolean isSorted = isSortedDescending(prices);
        //output
        System.out.println("Prices: " + Arrays.toString(prices));
        if (isSorted) {
            System.out.println("Prices filtered High to Low");
        } else {
            System.out.println("Filter is not applied");
        }

    }
    private boolean isSortedDescending(double[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) { //backwards check
                return false;
            }
        }
        return true;
    }
}





