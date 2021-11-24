package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassTest {
    protected WebDriver webDriver;
    protected SoftAssertions softAssertions;

    protected static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String BROWSER_TITLE = "Home Page";
    protected static final String USERNAME = "Roman";
    protected static final String PASSWORD = "Jdi1234";
    protected static final String EXPECTED_USERNAME = "ROMAN IOVLEV";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        softAssertions = new SoftAssertions();
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}

