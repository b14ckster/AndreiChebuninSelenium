package hw2.ex2;

import hw2.BaseClassTest;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DifferentElementsTest extends BaseClassTest {

    private static final String DIFFERENT_ELEMENTS_URL = "https://jdi-testing.github.io/jdi-light/different-elements.html";

    private static final List<String> CHECKBOX = new ArrayList<>(
            List.of("Water", "Earth", "Wind", "Fire")
    );
    private static final String CHECKBOX_LOG =
            ": condition changed to true";

    private static final List<String> RADIO = new ArrayList<>(
            List.of("Gold", "Silver", "Bronze", "Selen")
    );

    private static final String RADIO_LOG =
            "metal: value changed to ";

    private static final List<String> DROPDOWN = new ArrayList<>(
            List.of("Red", "Green", "Blue", "Yellow")
    );

    private static final String DROPDOWN_LOG =
            "Colors: value changed to ";

    private static final List<String> EXPECTED_LOG = new ArrayList<>(
            List.of(DROPDOWN_LOG + DROPDOWN.get(3),
                    RADIO_LOG + RADIO.get(3),
                    CHECKBOX.get(2) + CHECKBOX_LOG,
                    CHECKBOX.get(0) + CHECKBOX_LOG
            )
    );

    //utility method for finding a web-element
    public WebElement getItem(List<WebElement> itemList, String name) {
        return itemList
                .stream()
                .filter(item -> item.getText().contains(name))
                .findFirst()
                .map(webElement -> webElement.findElement(By.tagName("input")))
                .orElse(null);
    }

    @Test
    public void checkDifferentElementsTest() {

        //1. Open test site by URL
        webDriver.navigate().to(BASE_URL);

        //2. Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(BROWSER_TITLE);

        //3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys(USERNAME);
        webDriver.findElement(By.id("password")).sendKeys(PASS);
        webDriver.findElement(By.id("login-button")).click();

        //4. Assert User name in the left-top side of screen that user is loggined
        WebElement user = webDriver.findElement(By.id("user-name"));
        Assertions.assertThat(user.isDisplayed()).isTrue();
        Assertions.assertThat(user.getText()).isEqualTo(EXPECTED_USERNAME);

        //5. Open through the header menu Service -> Different Elements Page
        WebElement serviceDropdown = webDriver.findElement(By.className("dropdown-toggle"));
        serviceDropdown.click();
        serviceDropdown.findElement(By.xpath("//li[8]")).click();

        Assertions.assertThat(webDriver.getCurrentUrl()).isEqualTo(DIFFERENT_ELEMENTS_URL);

        //6. Select checkboxes
        List<WebElement> checkbox = webDriver.findElements(By.className("label-checkbox"));
        WebElement checkboxWater = new DifferentElementsTest().getItem(checkbox, CHECKBOX.get(0));
        WebElement checkboxWind = new DifferentElementsTest().getItem(checkbox, CHECKBOX.get(2));
        checkboxWater.click();
        checkboxWind.click();

        softAssertions.assertThat(checkboxWater.isSelected()).isTrue();
        softAssertions.assertThat(checkboxWind.isSelected()).isTrue();

        //7. Select radio
        List<WebElement> radio = webDriver.findElements(By.className("label-radio"));
        WebElement radioSelen = new DifferentElementsTest().getItem(radio, RADIO.get(3));
        radioSelen.click();

        softAssertions.assertThat(radioSelen.isSelected()).isTrue();

        //8. Select in dropdown
        Select dropdown = new Select(webDriver.findElement(By.tagName("select")));
        dropdown.selectByVisibleText(DROPDOWN.get(3));

        softAssertions.assertThat(dropdown.getFirstSelectedOption().getText()).isEqualTo(DROPDOWN.get(3));

        //9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.

        List<WebElement> actualLog = webDriver.findElements(By.cssSelector("ul.panel-body-list.logs li"));
        softAssertions.assertThat(actualLog.isEmpty()).isFalse();

        for (int i = 0; i < EXPECTED_LOG.size(); i++) {
            softAssertions.assertThat(actualLog.get(i).getText()).contains(EXPECTED_LOG.get(i));
        }

        //Assert All
        softAssertions.assertAll();
    }
}
