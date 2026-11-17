package base;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    //URLs
    public static final String PRODUCTION_URL = "https://www.saucedemo.com/";
    public static final String TESTING_URL = "https://www.saucedemoTestEnv.com/"; //for different environments
    protected WebDriver driver;
    protected Logger log;

    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, Method method) {
        base.BrowserDriverFactory factory = new base.BrowserDriverFactory(browser, log);
        driver = factory.createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}