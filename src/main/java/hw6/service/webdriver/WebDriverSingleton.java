package hw6.service.webdriver;

import java.util.Locale;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebDriverSingleton {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            String driverType = System.getProperty("driver.type", "local");
            String browserName = System.getProperty("browser.name", "chrome");

            webDriver = WebDriverFactory.createWebDriver(driverType,
                Browser.valueOf(browserName.toUpperCase(Locale.ROOT)));
        }
        return webDriver;
    }

    public static void closeWebDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
