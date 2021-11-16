package hw5.pageComponents;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Select;

@FindBy(css = "table#user-table")
public class UserTable extends AbstractComponent {

    public UserTable(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> userTable;

    @FindBy(xpath = "//tr/td[1]")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "td>select")
    private List<WebElement> dropdowns;

    @FindBy(css = "td>a")
    private List<WebElement> usernames;

    @FindBy(css = "td>div>span")
    private List<WebElement> descriptionsUnderImages;

    @FindBy(css = "td>div>input")
    private List<WebElement> checkboxes;

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getDropdowns() {
        return dropdowns;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getDescriptionsUnderImages() {
        return descriptionsUnderImages;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<List<String>> getUserTableWithReplace() {
        List<List<String>> userTable = new ArrayList<>();
        for (int i = 0; i < numberTypeDropdowns.size(); i++) {
            userTable.add(new ArrayList<>(
                List.of(
                    numberTypeDropdowns.get(i).getText(),
                    usernames.get(i).getText(),
                    descriptionsUnderImages.get(i).getText().replace("\n", " ")
                )));
        }
        return userTable;
    }

    public List<String> getDropdownOptionForUser(int userIndex) {
        Select select = new Select(dropdowns.get(userIndex));
        return select
                .getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getCheckboxForUser(int userIndex) {
        return checkboxes.get(userIndex);
    }

    public void clickOnCheckboxForUser(int userIndex) {
        getCheckboxForUser(userIndex).click();
    }
}
