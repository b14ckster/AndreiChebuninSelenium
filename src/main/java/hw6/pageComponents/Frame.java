package hw6.pageComponents;

import hw6.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frame extends AbstractComponent {

    private final AbstractPage parent;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public Frame(AbstractPage parent) {
        super(parent.webDriver);
        this.parent = parent;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public boolean isFrameDisplayed() {
        return frame.isDisplayed();
    }

    public boolean isFrameButtonDisplayed() {
        return frameButton.isDisplayed();
    }

    public AbstractPage switchToDefault() {
        parent.webDriver.switchTo().parentFrame();
        return parent;
    }
}
