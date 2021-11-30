<<<<<<< HEAD:src/test/java/hw4/BaseClassTest.java
package hw4;

import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
=======
package hw3;

>>>>>>> master:src/test/java/hw3/BaseClassTest.java
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
<<<<<<< HEAD:src/test/java/hw2/BaseClassTest.java
=======
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
<<<<<<< HEAD:src/test/java/hw4/BaseClassTest.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
=======
>>>>>>> master:src/test/java/hw3/BaseClassTest.java
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
>>>>>>> master:src/test/java/hw3/BaseClassTest.java
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassTest {
    protected WebDriver webDriver;
<<<<<<< HEAD:src/test/java/hw4/BaseClassTest.java
=======
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
>>>>>>> master:src/test/java/hw3/BaseClassTest.java
    protected Configuration properties;
    private final String pathToProperties = "src/test/resources/hw3Properties/pageData.properties";

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass
<<<<<<< HEAD:src/test/java/hw4/BaseClassTest.java
    public void setUp(ITestContext testContext) throws ConfigurationException {
=======
    public void setUp() throws ConfigurationException {
>>>>>>> master:src/test/java/hw3/BaseClassTest.java
>>>>>>> master:src/test/java/hw3/BaseClassTest.java
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        properties = new PropertiesConfiguration(pathToProperties);

        actionStep = new ActionStep(webDriver);
        assertionStep = new AssertionStep(webDriver);

        testContext.setAttribute("webDriver", webDriver);
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
<<<<<<< HEAD:src/test/java/hw2/BaseClassTest.java
=======
    
>>>>>>> master:src/test/java/hw3/BaseClassTest.java
}

