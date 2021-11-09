package hw4.tests.ex1;

import static hw4.DataClassTest.BASE_URL;
import static hw4.DataClassTest.BENEFIT_TEXTS;
import static hw4.DataClassTest.BROWSER_TITLE;
import static hw4.DataClassTest.HEADER_ITEMS_NAMES;
import static hw4.DataClassTest.ITEMS_IN_SIDEBAR_MENU;
import static hw4.DataClassTest.NUMBER_OF_BENEFIT_IMAGES_AND_TEXTS;

import hw4.BaseClassTest;
import hw4.listeners.AllureListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
@Story("User should see all items in header section, benefits, frame with button, and items in left section")
@Feature("Home Page contains all items in header section, benefits, frame with button, and items in left section")
public class HomePageTest extends BaseClassTest {

    @Test(description = "Testing failure test")
    public void checkElementsTest() {
        //1. Open test site by URL
        actionStep.openHomePage(BASE_URL);

        //2. Assert Browser title
        assertionStep.checkBrowserTitle(BROWSER_TITLE);

        //3. Perform login
        actionStep.performLogin("Wrong login", "Wrong password");

        //4. Assert Username is loggined
        assertionStep.checkUsername(properties.getString("username"));

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.checkNumberOfItemsOnHeader(HEADER_ITEMS_NAMES.size());
        assertionStep.checkItemsInSidebarTexts(HEADER_ITEMS_NAMES);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.checkNumberOfBenefitImages(NUMBER_OF_BENEFIT_IMAGES_AND_TEXTS);
        assertionStep.checkBenefitImagesIsDisplayed();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.checkNumberOfBenefitTexts(NUMBER_OF_BENEFIT_IMAGES_AND_TEXTS);
        assertionStep.checkBenefitTexts(BENEFIT_TEXTS);

        //8. Assert that there is the iframe with “Frame Button” exist
        assertionStep.checkFrameExist();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToFrame();
        assertionStep.checkFrameButtonExist();

        //10. Switch to original window back
        actionStep.switchToOriginalWindowBack();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.checkNumberOfItemsInSidebar(ITEMS_IN_SIDEBAR_MENU.size());
        assertionStep.checkItemsInSidebarIsDisplayed();
        assertionStep.checkItemsInSidebarTexts(ITEMS_IN_SIDEBAR_MENU);
    }
}
