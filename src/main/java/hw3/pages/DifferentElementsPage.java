package hw3.pages;

import hw3.pageComponents.DifferentElements;
import hw3.pageComponents.LogPanel;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPage extends AbstractPage{

    private final DifferentElements differentElements = new DifferentElements(webDriver);
    private final LogPanel logPanel = new LogPanel(webDriver);

    public DifferentElementsPage(WebDriver driver){
        super(driver);
    }

    public DifferentElements getDifferentElements() {
        return differentElements;
    }

    public LogPanel getLogPanel() {
        return logPanel;
    }
}
