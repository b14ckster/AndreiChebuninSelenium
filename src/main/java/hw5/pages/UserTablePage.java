package hw5.pages;

import hw5.pageComponents.LogPanel;
import hw5.pageComponents.UserTable;
import org.openqa.selenium.WebDriver;

public class UserTablePage extends AbstractPage {

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    private final UserTable userTable = new UserTable(webDriver);
    private final LogPanel logPanel = new LogPanel(webDriver);


    public UserTable getUserTable() {
        return userTable;
    }

    public LogPanel getLogPanel() {
        return logPanel;
    }
}
