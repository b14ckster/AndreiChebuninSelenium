package hw2.ex1;

import hw2.BaseClassTest;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClassTest {

    private static final List<String> HEADER_SECTION_ITEMS_NAMES = new ArrayList<>(
            List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

    private static final int NUMBER_OF_IMAGES_AND_TEXTS = 4;

    private static final List<String> ITEMS_IN_LEFT_SECTION = new ArrayList<>(
            List.of("Home", "Contact form", "Service", "Metals & Colors",
                    "Elements packs")
    );

    private static final List<String> TEXTS_UNDER_IMAGES = new ArrayList<>(
        List.of(
            "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project",

            "To be flexible and\n"
                + "customizable",

            "To be multiplatform",

            "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…"
        )
    );

    @Test
    public void checkElementsTest() {
        //1. Open test site by URL
        webDriver.navigate().to(BASE_URL);

        //2. Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(BROWSER_TITLE);

        //3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(USERNAME);
        webDriver.findElement(By.id("password")).sendKeys(PASSWORD);
        webDriver.findElement(By.id("login-button")).click();

        //4. Assert Username is loggined
        WebElement user = webDriver.findElement(By.id("user-name"));
        Assertions.assertThat(user.isDisplayed()).isTrue();
        Assertions.assertThat(user.getText()).isEqualTo(EXPECTED_USERNAME);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerSectionItemsNames =  webDriver.findElements(By.xpath("//header/div/nav/ul[1]/li/a"));
        softAssertions.assertThat(headerSectionItemsNames.size()).isEqualTo(HEADER_SECTION_ITEMS_NAMES.size());

        for (int i = 0; i < HEADER_SECTION_ITEMS_NAMES.size(); i++) {
            softAssertions.assertThat(headerSectionItemsNames.get(i).isDisplayed()).isTrue();
            softAssertions.assertThat(headerSectionItemsNames.get(i).getText())
                    .isEqualTo(HEADER_SECTION_ITEMS_NAMES.get(i));
        }

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> pageImages = webDriver.findElements(By.className("benefit-icon"));
        softAssertions.assertThat(pageImages.size()).isEqualTo(NUMBER_OF_IMAGES_AND_TEXTS);

        for (int i = 0; i < NUMBER_OF_IMAGES_AND_TEXTS; i++) {
            softAssertions.assertThat(pageImages.get(i).isDisplayed()).isTrue();
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textsUnderImages = webDriver.findElements(By.className("benefit-txt"));
        softAssertions.assertThat(textsUnderImages.size()).isEqualTo(NUMBER_OF_IMAGES_AND_TEXTS);

        for (int i = 0; i < NUMBER_OF_IMAGES_AND_TEXTS; i++) {
            softAssertions.assertThat(textsUnderImages.get(i).isDisplayed()).isTrue();
            softAssertions.assertThat(textsUnderImages.get(i).getText())
                    .isEqualTo(TEXTS_UNDER_IMAGES.get(i));
        }

        //8. Assert that there is the iframe with “Frame Button” exist
        List<WebElement> iframeElements = webDriver.findElements(By.id("frame"));
        softAssertions.assertThat(iframeElements.isEmpty()).isFalse();

        WebElement iframe = iframeElements.get(0);
        softAssertions.assertThat(iframe.isDisplayed()).isTrue();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(iframe);
        WebElement frameButton = webDriver.findElement(By.id("frame-button"));
        softAssertions.assertThat(frameButton.isDisplayed()).isTrue();

        //10. Switch to original window back
        webDriver.switchTo().parentFrame();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> itemsInLeftSection = webDriver.findElements(
                By.cssSelector("ul[class=\"sidebar-menu left\"]>li"));
        softAssertions.assertThat(itemsInLeftSection.size()).isEqualTo(ITEMS_IN_LEFT_SECTION.size());

        for (int i = 0; i < ITEMS_IN_LEFT_SECTION.size(); i++) {
            softAssertions.assertThat(itemsInLeftSection.get(i).isDisplayed()).isTrue();
            softAssertions.assertThat(itemsInLeftSection.get(i).getText())
                    .isEqualTo(ITEMS_IN_LEFT_SECTION.get(i));
        }

        //Assert All
        softAssertions.assertAll();
    }
}
