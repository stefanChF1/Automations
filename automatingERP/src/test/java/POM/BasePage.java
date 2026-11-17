package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    @FindBy(id = "dataEntrySaveSuccess")
    private WebElement customerSavedPopUp;


    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void scrollToElement(){
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();
    }
    public void dataSavedPopUp(){
            customerSavedPopUp.isDisplayed();
        }
    }

