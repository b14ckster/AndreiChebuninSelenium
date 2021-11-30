package hw4.pageComponents;

import hw4.pages.DifferentElementsPage;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(tagName = "header")
public class Header extends AbstractComponent {

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(css = "ul.nav>li")
    private List<WebElement> navigationElements;

    @FindBy(css = "a.dropdown-toggle")
    private WebElement serviceDropdown;

    @FindBy(css = "ul[role=\"menu\"]>li>a[href=\"different-elements.html\"]")
    private WebElement differentElements;

    public Header inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public Header inputLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public Header clickLoginButton() {
        loginButton.click();
        return this;
    }

    public String getUsername() {
        return username.getText();
    }

    public boolean isUsernameDisplayed() {
        return username.isDisplayed();
    }

    public Header signIn(String login, String password) {
        userIcon.click();
        inputLogin(login);
        inputPassword(password);
        clickLoginButton();
        return this;
    }

    public List<String> getNavigationElementsTexts() {
        return navigationElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public DifferentElementsPage clickDifferentElements() {
        serviceDropdown.click();
        differentElements.click();
        return new DifferentElementsPage(webDriver);
    }
}
