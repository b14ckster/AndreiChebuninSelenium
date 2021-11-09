package hw4.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Radio;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert Browser title equals to {title}")
    public void checkBrowserTitle(String title) {
        Assertions.assertThat(homePage.getTitle()).isEqualTo(title);
    }

    @Step("Assert Username is loggined by {expectedUsername}")
    public void checkUsername(String expectedUsername) {
        Assertions
                .assertThat(homePage.getHeader().isUsernameDisplayed())
                .isTrue();
        Assertions
                .assertThat(homePage.getHeader().getUsername())
                .isEqualTo(expectedUsername);
    }

    @Step("Assert that there are {expectedSize} items on the header section")
    public void checkNumberOfItemsOnHeader(int expectedSize) {
        Assertions
                .assertThat(homePage.getHeader().getNavigationElementsTexts())
                .hasSize(expectedSize);
    }

    @Step("Assert that items: {expectedItems} on the header section have proper texts")
    public void checkItemsIsDisplayed(List<String> expectedItems) {
        Assertions
                .assertThat(homePage.getHeader().getNavigationElementsTexts())
                .isEqualTo(expectedItems);
    }

    @Step("Assert that there are {expectedSize} images on the Index Page")
    public void checkNumberOfBenefitImages(int expectedSize) {
        Assertions
                .assertThat(homePage.getBenefit().getNumberOfBenefitIcons())
                .isEqualTo(expectedSize);
    }

    @Step("Assert that images on the Index Page are displayed")
    public void checkBenefitImagesIsDisplayed() {
        //We need to know how many images may not be displayed.
        SoftAssertions softAssertions = new SoftAssertions();
        homePage.getBenefit().getBenefitIcons()
                .forEach(icon ->
                        softAssertions
                                .assertThat(icon.isDisplayed())
                                .isTrue());
        softAssertions.assertAll();
    }

    @Step("Assert that there are {expectedSize} texts on the Index Page under icons and they have proper text")
    public void checkNumberOfBenefitTexts(int expectedSize) {
        Assertions
                .assertThat(homePage.getBenefit().getNumberOfBenefitTexts())
                .isEqualTo(expectedSize);
    }

    @Step("Assert that texts on the Index Page under icons have proper text: {expectedText}")
    public void checkBenefitTexts(List<String> expectedText) {
        Assertions
                .assertThat(homePage.getBenefit().getBenefitTextsTexts())
                .isEqualTo(expectedText);

    }

    @Step("Assert that there is the iframe with \"Frame Button\" exist")
    public void checkFrameExist() {
        Assertions.assertThat(homePage.getFrame().getFrame()).isNotNull();
        Assertions.assertThat(homePage.getFrame().isFrameDisplayed()).isTrue();
    }

    @Step("Switch to the iframe and check that there is \"Frame Button\" in the iframe")
    public void checkFrameButtonExist() {
        Assertions.assertThat(homePage.getFrame().getFrameButton()).isNotNull();
        Assertions.assertThat(homePage.getFrame().isFrameButtonDisplayed()).isTrue();
    }

    @Step("Assert that there are {expectedSize} items in the Left Section")
    public void checkNumberOfItemsInSidebar(int expectedSize) {
        Assertions
                .assertThat(homePage.getSidebarMenu().getNumberOfSidebar())
                .isEqualTo(expectedSize);
    }

    @Step("Assert that items in the Left Section are displayed")
    public void checkItemsInSidebarIsDisplayed() {
        SoftAssertions softAssertions = new SoftAssertions();
        homePage.getSidebarMenu().getSidebarMenu()
                .forEach(el ->
                        softAssertions
                                .assertThat(el.isDisplayed())
                                .isTrue());
        softAssertions.assertAll();
    }

    @Step("Assert that items in the Left Section have proper text: {expectedTexts}")
    public void checkItemsInSidebarTexts(List<String> expectedTexts) {
        Assertions
                .assertThat(homePage.getSidebarMenu().getSidebarMenuTexts())
                .isEqualTo(expectedTexts);
    }

    @Step("Assert that checkbox {checkbox} is selected")
    public void checkCheckboxIsSelected(String checkbox) {
        CheckBox checkBoxButton = differentElementsPage
                        .getDifferentElements()
                        .getCheckbox(checkbox);
        Assertions
                .assertThat(checkBoxButton.isSelected())
                .isTrue();

    }

    @Step("Assert that radio {radio} is selected")
    public void checkRadioIsSelected(String radio) {
        Radio radioButton = differentElementsPage
                .getDifferentElements()
                .getRadioButton(radio);
        Assertions
                .assertThat(radioButton.isSelected())
                .isTrue();
    }

    @Step("Assert that dropdown option {dropdown} is selected")
    public void checkDropdownIsSelected(String dropdown) {
        Select select = differentElementsPage
                .getDifferentElements()
                .getDropdown(dropdown);
        Assertions
                .assertThat(select.getFirstSelectedOption().getText())
                .isEqualTo(dropdown);
    }

    @Step("Assert that log panel contains logs: {expectedLogs}")
    public void checkLogPanel(List<String> expectedLog) {
        SoftAssertions softAssertions = new SoftAssertions();
        expectedLog.forEach(log ->
                softAssertions
                        .assertThat(differentElementsPage.getLogPanel().findLog(log))
                        .isNotNull()
        );
        softAssertions.assertAll();
    }
}
