package hw5.steps;

import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep {

    public static void checkNumberAndVisibilityOfElements(List<WebElement> elements, int expectedSize) {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions
            .assertThat(elements.size())
            .isEqualTo(expectedSize);

        elements.forEach(element ->
            softAssertions
                .assertThat(element.isDisplayed())
                .isTrue()
        );
    }

    @Then("{string} page should be opened")
    public void checkPageTitle(String title) {
        Assertions.assertThat(webDriver.getTitle())
            .isEqualTo(title);
    }

    @Then("Username should be {string}")
    public void checkUsername(String expectedUsername) {
        Assertions
            .assertThat(homePage.getHeader().isUsernameDisplayed())
            .isTrue();
        Assertions
            .assertThat(homePage.getHeader().getUsername())
            .isEqualTo(expectedUsername);
    }

    @Then("I see in log section:")
    public void checkLogPanel(List<String> expectedLog) {
        SoftAssertions softAssertions = new SoftAssertions();
        expectedLog.forEach(log ->
            softAssertions
                .assertThat(differentElementsPage.getLogPanel().findLog(log))
                .contains(log)
        );
        softAssertions.assertAll();
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberTypeDropdowns(int expectedNumber) {
        checkNumberAndVisibilityOfElements(
            userTablePage.getUserTable().getNumberTypeDropdowns(),
            expectedNumber
        );
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkNumberAndVisibilityUsernames(int expectedNumber) {
        checkNumberAndVisibilityOfElements(
            userTablePage.getUserTable().getUsernames(),
            expectedNumber
        );
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkNumberAndVisibilityDescriptionsUnderImages(int expectedNumber) {
        checkNumberAndVisibilityOfElements(
            userTablePage.getUserTable().getDescriptionsUnderImages(),
            expectedNumber
        );
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkNumberAndVisibilityCheckboxes(int expectedNumber) {
        checkNumberAndVisibilityOfElements(
            userTablePage.getUserTable().getCheckboxes(),
            expectedNumber
        );
    }

    @Then("User table should contain following values:")
    public void checkUserTableValues(List<List<String>> userTable) {
        userTable.remove(0);
        Assertions
            .assertThat(userTablePage.getUserTable().getUserTableWithReplace())
            .isEqualTo(userTable);
    }

    @Then("dropList should contain values in column Type for user {string}")
    public void checkDropListValues(String username, List<String> dropdownValues) {
        List<String> cloneDropdownValues = new ArrayList<>(dropdownValues);
        cloneDropdownValues.remove(0);

        userTablePage.getUserTable().getUserTableWithReplace().forEach(line -> {
                if (line.get(1).equals(username)) {
                    Assertions
                        .assertThat(userTablePage
                            .getUserTable()
                            .getDropdownOptionForUser(Integer.parseInt(line.get(0))))
                        .isEqualTo(cloneDropdownValues);
                }
            }
        );
    }

    @Then("1 log row has {string} text in log section")
    public void checkLogRowHasProperTextInLogSection(String expectedText) {
        Assertions
            .assertThat(userTablePage.getLogPanel().findLog(expectedText))
            .contains(expectedText);
    }
}
