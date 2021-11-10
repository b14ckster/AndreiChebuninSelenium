package hw4.pageComponents;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(css = "ul.logs")
public class LogPanel extends AbstractComponent {

    public LogPanel(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(tagName = "li")
    private List<WebElement> logList;

    public String findLog(String text) {
        return logList
            .stream()
            .map(WebElement::getText)
            .filter(log -> log.contains(text))
            .findFirst()
            .toString();
    }
}


