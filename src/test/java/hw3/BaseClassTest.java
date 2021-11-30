package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
<<<<<<< HEAD:src/test/java/hw2/BaseClassTest.java
=======
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
>>>>>>> master:src/test/java/hw3/BaseClassTest.java
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassTest {
    protected WebDriver webDriver;
    protected SoftAssertions softAssertions;
<<<<<<< HEAD:src/test/java/hw2/BaseClassTest.java

    protected static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String BROWSER_TITLE = "Home Page";
    protected static final String USERNAME = "Roman";
    protected static final String PASSWORD = "Jdi1234";
    protected static final String EXPECTED_USERNAME = "ROMAN IOVLEV";

    @BeforeClass
    public void setUp() {
=======
    protected Configuration properties;
    private final String pathToProperties = "src/test/resources/hw3Properties/pageData.properties";

    @BeforeClass
    public void setUp() throws ConfigurationException {
>>>>>>> master:src/test/java/hw3/BaseClassTest.java
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        properties = new PropertiesConfiguration(pathToProperties);
        softAssertions = new SoftAssertions();
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
<<<<<<< HEAD:src/test/java/hw2/BaseClassTest.java
=======
    
>>>>>>> master:src/test/java/hw3/BaseClassTest.java
}

