package POM;
import junit.framework.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//button[contains(@type,'submit')]")
    private WebElement logInButton;
    @FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul[1]/li[2]/a")
    private WebElement logOutButton;
    @FindBy(xpath = "//span[contains(@class,'text-bold')]")
    private WebElement logInSign;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickLogin(){
        logInButton.click();
    }
    public void assertWeAreLogged(){
        try {
            Assert.assertTrue("Logout button is not visible!", logOutButton.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Logout button is not visible — element not found in DOM!");
        }
    }
    public void logOut(){
        logOutButton.click();
        String logInSignHP = logInSign.getText();
        boolean weAreLoggedOff = logInSignHP.equals("Login");
        Assert.assertTrue("We are not logged out!", weAreLoggedOff);
    }
}

