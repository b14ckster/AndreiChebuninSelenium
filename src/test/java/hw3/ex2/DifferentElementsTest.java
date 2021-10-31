package hw3.ex2;

import static hw3.DataClassTest.*;
import hw3.BaseClassTest;
import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Radio;

import java.util.ArrayList;
import java.util.List;

public class DifferentElementsTest extends BaseClassTest {

    @Test
    public void checkDifferentElementsTest() {

        //1. Open test site by URL
        HomePage homePage = new HomePage(webDriver, BASE_URL);

        //2. Assert Browser title
        softAssertions
                .assertThat(homePage.getTitle())
                .isEqualTo(BROWSER_TITLE);

        //3. Perform login
        homePage.getHeader().signIn(
                properties.getString("login"),
                properties.getString("pass")
        );

        //4. Assert User name in the left-top side of screen that user is loggined

        softAssertions
                .assertThat(homePage.getHeader().isUsernameDisplayed())
                .isTrue();

        softAssertions
                .assertThat(homePage.getHeader().getUsername())
                .isEqualTo(properties.getString("username"));

        //5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage =
                homePage.getHeader().clickDifferentElements();

        softAssertions
                .assertThat(differentElementsPage.getUrl())
                .isEqualTo(DIFFERENT_ELEMENTS_URL);

        //6. Select checkboxes
        CheckBox checkBoxWater =
                differentElementsPage
                .getDifferentElements()
                .getCheckbox(CHECKBOX.get(0));

        CheckBox checkBoxWind =
                differentElementsPage
                .getDifferentElements()
                .getCheckbox(CHECKBOX.get(2));

        softAssertions
                .assertThat(checkBoxWater)
                .isNotNull();
        softAssertions
                .assertThat(checkBoxWind).
                isNotNull();

        checkBoxWater.click();
        checkBoxWind.click();

        softAssertions
                .assertThat(checkBoxWater.isSelected())
                .isTrue();
        softAssertions
                .assertThat(checkBoxWind.isSelected())
                .isTrue();

        //7. Select radio
        Radio radio = differentElementsPage
                .getDifferentElements()
                .getRadioButton(RADIO.get(3));

        softAssertions.
                assertThat(radio).
                isNotNull();

        radio.click();

        softAssertions
                .assertThat(radio.isSelected())
                .isTrue();

        //8. Select in dropdown
       Select select = differentElementsPage
               .getDifferentElements()
               .getDropdown(DROPDOWN.get(3));

       softAssertions
               .assertThat(select)
               .isNotNull();

       softAssertions
               .assertThat(select.getFirstSelectedOption().getText())
               .isEqualTo(DROPDOWN.get(3));

        //9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.

        List<String> expectedLog = new ArrayList<>(
                List.of(
                        DROPDOWN_LOG + DROPDOWN.get(3),
                        RADIO_LOG + RADIO.get(3),
                        CHECKBOX.get(2) + CHECKBOX_LOG,
                        CHECKBOX.get(0) + CHECKBOX_LOG
                )
        );

        expectedLog.forEach (log ->
                        softAssertions
                                .assertThat(differentElementsPage.getLogPanel().findLog(log))
                                .isNotNull()
                );

        //Assert All
        softAssertions.assertAll();
    }
}
