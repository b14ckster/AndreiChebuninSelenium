package hw3.pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractComponent {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    protected AbstractComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10).toSeconds());
        PageFactory.initElements(webDriver, this);
    }
}
