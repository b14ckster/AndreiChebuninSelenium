package hw6.steps;


import hw6.pages.DifferentElementsPage;
import hw6.pages.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected WebDriver webDriver;

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver webDriver) {
        this.webDriver = webDriver;
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }
}
