<<<<<<< HEAD:src/test/java/hw4/BaseClassTest.java
package hw4;

import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
=======
package hw3;

>>>>>>> master:src/test/java/hw3/BaseClassTest.java
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassTest {
    protected WebDriver webDriver;
    protected Configuration properties;
    private final String pathToProperties = "src/test/resources/hw3Properties/pageData.properties";

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass
    public void setUp(ITestContext testContext) throws ConfigurationException {
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
    
}

