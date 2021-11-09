package hw4.tests.ex2;

import static hw4.DataClassTest.BASE_URL;
import static hw4.DataClassTest.BROWSER_TITLE;
import static hw4.DataClassTest.CHECKBOX;
import static hw4.DataClassTest.CHECKBOX_LOG;
import static hw4.DataClassTest.DROPDOWN;
import static hw4.DataClassTest.DROPDOWN_LOG;
import static hw4.DataClassTest.RADIO;
import static hw4.DataClassTest.RADIO_LOG;

import hw4.BaseClassTest;
import hw4.listeners.AllureListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
@Story("On Different Elements Page User should be able to select (click) checkboxes, radio buttons, "
    + "options in dropdown and see actions in log panel")
@Feature("Elements on Different Elements Page are clickable and log panel shows users actions")
public class DifferentElementsTest extends BaseClassTest {

    @Test(description = "Test clickable elements on Different Elements Page")
    public void checkDifferentElementsTest() {

        //1. Open test site by URL
        actionStep.openHomePage(BASE_URL);

        //2. Assert Browser title
        assertionStep.checkBrowserTitle(BROWSER_TITLE);

        //3. Perform login
        actionStep.performLogin(properties.getString("login"), properties.getString("pass"));

        //4. Assert User name in the left-top side of screen that user is loggined
        assertionStep.checkUsername(properties.getString("username"));

        //5. Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();

        //6. Select checkboxes
        actionStep.selectCheckbox(CHECKBOX.get(0));
        actionStep.selectCheckbox(CHECKBOX.get(2));

        assertionStep.checkCheckboxIsSelected(CHECKBOX.get(0));
        assertionStep.checkCheckboxIsSelected(CHECKBOX.get(2));

        //7. Select radio
        actionStep.selectRadio(RADIO.get(3));
        assertionStep.checkRadioIsSelected(RADIO.get(3));

        //8. Select in dropdown
        actionStep.selectInDropdown(DROPDOWN.get(3));
        assertionStep.checkDropdownIsSelected(DROPDOWN.get(3));

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

        assertionStep.checkLogPanel(expectedLog);
    }
}
