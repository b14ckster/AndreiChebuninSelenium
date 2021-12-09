package hw6.service.webdriver;

import hw6.service.exceptions.BrowserNameException;
import hw6.service.exceptions.WebDriverTypeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebDriverFactory {

    public static final String REMOTE_DRIVER_TYPE = "remote";
    public static final String LOCAL_DRIVER_TYPE = "local";

    private static WebDriver webDriver;

    public static WebDriver createWebDriver(final String driverType, final Browser browser) {
        if (LOCAL_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            webDriver = createLocalWebDriver(browser);
        } else if (REMOTE_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            webDriver = createRemoteWebDriver(browser);
        } else {
            throw new WebDriverTypeException();
        }
        return webDriver;
    }

    /* local web driver creation */
    private static WebDriver createLocalWebDriver(final Browser browser) {
        switch (browser) {
            case CHROME:
                webDriver = createChromeDriver();
                break;

            case FIREFOX:
                webDriver = createFirefoxDriver();
                break;

            default:
                throw new BrowserNameException();
        }
        return webDriver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /* remote web driver creation */
    private static WebDriver createRemoteWebDriver(final Browser browser) {
        Capabilities capabilities;
        switch (browser) {
            case CHROME:
                capabilities = createChromeCapabilities();
                break;

            case FIREFOX:
                capabilities = createFirefoxCapabilities();
                break;

            default:
                throw new BrowserNameException();
        }

        try {
            webDriver = new RemoteWebDriver(new URL("http://192.168.0.106:4444"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }

        return webDriver;
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
    }
}
