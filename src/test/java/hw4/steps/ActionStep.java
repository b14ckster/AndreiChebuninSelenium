package hw4.steps;

import hw4.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Radio;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open test site by URL {URL}")
    public void openHomePage(String url) {
        homePage.open(url);
    }

    @Step("Perform login using login {login} and password {password}")
    public void performLogin(String login, String password) {
        homePage.getHeader().signIn(login, password);
    }

    @Step("Switch to the iframe")
    public void switchToFrame() {
        homePage.switchToFrame();
    }

    @Step("Switch to original window back")
    public void switchToOriginalWindowBack() {
        homePage = (HomePage) homePage.getFrame().switchToDefault();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        differentElementsPage =
                homePage.getHeader().clickDifferentElements();
    }

    @Step("Select checkbox: {checkbox}")
    public void selectCheckbox(String checkbox) {
        CheckBox checkBoxButton = differentElementsPage
                        .getDifferentElements()
                        .getCheckbox(checkbox);
        checkBoxButton.click();
    }

    @Step("Select radio: {radio}")
    public void selectRadio(String radio) {
        Radio radioButton = differentElementsPage
                .getDifferentElements()
                .getRadioButton(radio);
        radioButton.click();
    }

    @Step("Select in dropdown: {dropdown}")
    public void selectInDropdown(String dropdown) {
        Select select = differentElementsPage
                .getDifferentElements()
                .getDropdown(dropdown);
    }
}
