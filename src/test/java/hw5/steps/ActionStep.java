package hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ActionStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.open(BASE_URL);
    }

    @When("I login as user {string}")
    public void performLogin(String user) {
        homePage.getHeader().signIn(properties.getString("login"), properties.getString("pass"));
    }

    @When("I click on {string} button in Header")
    public void clickOnButtonInHeader(String buttonName) {
        homePage.getHeader().getHeaderElement(buttonName).click();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOmButtonInServiceDropdown(String buttonName) {
        homePage.getHeader().getDropdownElement(buttonName).click();
    }

    @When("I select checkboxes")
    public void selectCheckboxes(List<String> checkboxNames) {
        checkboxNames.forEach(checkbox ->
            differentElementsPage
                .getDifferentElements()
                .getCheckbox(checkbox)
                .click());
    }

    @When("I select radio button {string}")
    public void selectRadio(String radio) {
        differentElementsPage
            .getDifferentElements()
            .getRadioButton(radio)
            .click();
    }

    @When("I select dropdown {string}")
    public void selectInDropdown(String dropdown) {
        differentElementsPage
            .getDifferentElements()
            .getDropdown(dropdown);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckboxForUser(String username) {
        userTablePage.getUserTable().getUserTableWithReplace().forEach(line -> {
            if (line.get(1).equals(username)) {
                WebElement checkbox = userTablePage.getUserTable().getCheckboxForUser(Integer.parseInt(line.get(0)));
                checkbox.click();
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }
            }
        );
    }
}
