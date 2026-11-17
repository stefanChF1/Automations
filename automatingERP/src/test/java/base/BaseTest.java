package base;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

public class BaseTest {
    //URLs
    public static final String HOMEPAGE = "";
    protected WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, Method method) {
        base.BrowserFactory factory = new base.BrowserFactory(browser);
        driver = factory.createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

    }
    //This method gets all values for a dropdown and creates array all options
    public static String getRandomValue(Select opt) {
        List<WebElement> options = opt.getOptions();

        String[] values = options.stream()
                .map(o -> o.getAttribute("value"))
                .toArray(String[]::new);
        return values[ThreadLocalRandom.current().nextInt(values.length)];
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}