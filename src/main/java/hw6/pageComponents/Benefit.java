package hw6.pageComponents;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Benefit extends AbstractComponent {

    @FindBy(css = "span[class^=\"icons-benefit\"]")
    private List<WebElement> benefitIcons;

    @FindBy(css = "span[class=\"benefit-txt\"]")
    private List<WebElement> benefitTexts;

    public Benefit(WebDriver webDriver) {
        super(webDriver);
    }

    public int getNumberOfBenefitIcons() {
        return benefitIcons.size();
    }

    public int getNumberOfBenefitTexts() {
        return benefitTexts.size();
    }

    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    public List<WebElement> getBenefitTexts() {
        return benefitTexts;
    }

    public List<String> getBenefitTextsTexts() {
        return benefitTexts
               .stream()
               .map(WebElement::getText)
               .collect(Collectors.toList());
    }
}
