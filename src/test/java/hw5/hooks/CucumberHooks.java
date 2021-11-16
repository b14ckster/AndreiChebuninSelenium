package hw5.hooks;


import hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {

    private WebDriver webDriver;
    private final String pathToProperties = "src/test/resources/hw3Properties/pageData.properties";

    @Before
    public void setUp() throws ConfigurationException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TestContext.getInstance()
                .setTestObject("webDriver", webDriver)
                .setTestObject("properties", new PropertiesConfiguration(pathToProperties));
    }

    @After
    public void tearDown() {
        webDriver = TestContext.getInstance().getTestObject("webDriver");
        if (webDriver != null) {
            webDriver.quit();
        }
        TestContext.getInstance().clearContext();
    }
}
