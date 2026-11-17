package POM;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement logInButton;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }
    public void enterUsernameByIndex(int index){
        WebElement allAvailableUsers = driver.findElement(By.id("login_credentials"));
        String usersArr = allAvailableUsers.getText();
        String[] arrayUsers = usersArr.split("\n");
        usernameField.sendKeys(arrayUsers[index]);
    }
    public void enterPassword(){
        WebElement availablePassword = driver.findElement(By.xpath("//div[contains(@class,'login_password')]"));
        String passwordArr = availablePassword.getText();
        String[] password = passwordArr.split("\n");
        passwordField.sendKeys(password[1]);
    }
    public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
    }
}

