package hw6.service.exceptions;

import hw6.service.webdriver.Browser;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class BrowserNameException extends RuntimeException {

    public BrowserNameException() {
        super(
            String.format(
                "Unsupported browser name. Supported browsers are %s",
                Arrays
                    .stream(Browser.values())
                    .map(browser -> browser.name().toLowerCase(Locale.ROOT))
                    .collect(Collectors.joining(", "))
            )
        );
    }
}
