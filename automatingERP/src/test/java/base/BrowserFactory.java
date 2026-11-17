package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;


    public BrowserFactory(String browser) {
        this.browser = browser.toLowerCase();
    }
    public WebDriver createDriver() {

        switch (browser) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            default:
                driver.set(new ChromeDriver());
                break;
        }
        return driver.get();
    }
}