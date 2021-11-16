package hw5.steps;

import hw5.context.TestContext;
import hw5.pages.DifferentElementsPage;
import hw5.pages.HomePage;
import hw5.pages.UserTablePage;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected WebDriver webDriver;
    protected PropertiesConfiguration properties;

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public AbstractStep() {
        webDriver = TestContext.getInstance().getTestObject("webDriver");
        properties = TestContext.getInstance().getTestObject("properties");

        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
    }
}
