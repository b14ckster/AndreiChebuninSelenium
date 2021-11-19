package hw6.pageComponents;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Radio;

@FindBy(className = "main-content-hg")
public class DifferentElements extends AbstractComponent {

    public DifferentElements(WebDriver webDriver) {
        super(webDriver);
    }

    private static final By inputInLabelLocator = By.tagName("input");

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtons;

    @FindBy(tagName = "select")
    private WebElement dropdown;

    public Select getDropdown(String text) {
        Select dropdownSelect = new Select(dropdown);
        dropdownSelect.selectByVisibleText(text);
        return dropdownSelect;
    }

    public CheckBox getCheckbox(String text) {
        return checkboxes
                .stream()
                .filter(item -> item.getText().contains(text))
                .findFirst()
                .map(webElement -> webElement.findElement(inputInLabelLocator))
                .map(CheckBox::new)
                .orElse(null);
    }

    public Radio getRadioButton(String text) {
        return radioButtons
                .stream()
                .filter(item -> item.getText().contains(text))
                .findFirst()
                .map(webElement -> webElement.findElement(inputInLabelLocator))
                .map(Radio::new)
                .orElse(null);
    }

    public void clickOnCheckbox(String checkbox) {
        getCheckbox(checkbox).click();
    }

    public void clickOnRadioButton(String radio) {
        getRadioButton(radio).click();
    }
}
