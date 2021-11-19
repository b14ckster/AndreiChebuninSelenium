package hw6.pages;

import hw6.pageComponents.Header;
import hw6.pageComponents.SidebarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public WebDriver webDriver;
    private final Header header;
    private final SidebarMenu sidebarMenu;

    public AbstractPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(webDriver);
        sidebarMenu = new SidebarMenu(webDriver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public Header getHeader() {
        return header;
    }

    public SidebarMenu getSidebarMenu() {
        return sidebarMenu;
    }

    public AbstractPage open(String url) {
        webDriver.get(url);
        return this;
    }
}
