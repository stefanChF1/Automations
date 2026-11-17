package POM;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    Logger log;
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver,Logger log) {
        this.driver = driver;
        this.log = log;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }
    public void goToCart() {
        WebElement cart = driver.findElement(By.id("shopping_cart_container"));
        cart.click();
    }
}
