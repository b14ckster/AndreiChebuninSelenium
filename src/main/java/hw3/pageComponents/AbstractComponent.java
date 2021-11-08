package hw3.pageComponents;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class AbstractComponent {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    protected AbstractComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10).toSeconds());
        PageFactory.initElements(webDriver, this);
    }
}
