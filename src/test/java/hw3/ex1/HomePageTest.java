package hw3.ex1;

import static hw3.DataClassTest.BASE_URL;
import static hw3.DataClassTest.BENEFIT_TEXTS;
import static hw3.DataClassTest.BROWSER_TITLE;
import static hw3.DataClassTest.HEADER_ITEMS_NAMES;
import static hw3.DataClassTest.ITEMS_IN_SIDEBAR_MENU;
import static hw3.DataClassTest.NUMBER_OF_BENEFIT_IMAGES_AND_TEXTS;

import hw3.BaseClassTest;
import hw3.pageComponents.Frame;
import hw3.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClassTest {

    @Test
    public void checkElementsTest() {
        //1. Open test site by URL
        HomePage homePage = new HomePage(webDriver, BASE_URL);

        //2. Assert Browser title
        softAssertions.assertThat(homePage.getTitle()).isEqualTo(BROWSER_TITLE);

        //3. Perform login
        homePage.getHeader().signIn(properties.getString("login"), properties.getString("pass"));

        //4. Assert Username is loggined
        softAssertions
                .assertThat(homePage.getHeader().isUsernameDisplayed())
                .isTrue();
        softAssertions
                .assertThat(homePage.getHeader().getUsername())
                .isEqualTo(properties.getString("username"));

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssertions
                .assertThat(homePage.getHeader().getNavigationElementsTexts())
                .hasSize(HEADER_ITEMS_NAMES.size());

        softAssertions
                .assertThat(homePage.getHeader().getNavigationElementsTexts())
                .isEqualTo(HEADER_ITEMS_NAMES);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssertions
                .assertThat(homePage.getBenefit().getNumberOfBenefitIcons())
                .isEqualTo(NUMBER_OF_BENEFIT_IMAGES_AND_TEXTS);

        homePage.getBenefit().getBenefitIcons()
                .forEach(icon ->
                        softAssertions
                                .assertThat(icon.isDisplayed())
                                .isTrue());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssertions
                .assertThat(homePage.getBenefit().getNumberOfBenefitTexts())
                .isEqualTo(NUMBER_OF_BENEFIT_IMAGES_AND_TEXTS);

        softAssertions
                .assertThat(homePage.getBenefit().getBenefitTextsTexts())
                .isEqualTo(BENEFIT_TEXTS);

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(homePage.getFrame().getFrame()).isNotNull();
        softAssertions.assertThat(homePage.getFrame().isFrameDisplayed()).isTrue();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        Frame frame = homePage.switchToFrame();

        softAssertions.assertThat(frame.getFrameButton()).isNotNull();
        softAssertions.assertThat(frame.isFrameButtonDisplayed()).isTrue();

        //10. Switch to original window back
        homePage = (HomePage) frame.switchToDefault();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssertions
               .assertThat(homePage.getSidebarMenu().getNumberOfSidebar())
               .isEqualTo(ITEMS_IN_SIDEBAR_MENU.size());

        homePage.getSidebarMenu().getSidebarMenu()
                        .forEach(el ->
                                softAssertions
                                        .assertThat(el.isDisplayed())
                                        .isTrue());

        softAssertions
                .assertThat(homePage.getSidebarMenu().getSidebarMenuTexts())
                .isEqualTo(ITEMS_IN_SIDEBAR_MENU);

        //Assert All
        softAssertions.assertAll();
    }
}
