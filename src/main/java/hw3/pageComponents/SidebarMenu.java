package hw3.pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@FindBy(css = "ul.sidebar-menu")
public class SidebarMenu extends AbstractComponent {

    public SidebarMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "ul.sidebar-menu>li")
    private List<WebElement> sidebarMenu;

    public List<WebElement> getSidebarMenu(){
        return sidebarMenu;
    }

    public int getNumberOfSidebar(){
        return sidebarMenu.size();
    }

    public List<String> getSidebarMenuTexts() {
        return sidebarMenu
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
