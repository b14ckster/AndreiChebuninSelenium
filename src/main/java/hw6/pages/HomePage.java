package hw6.pages;

import hw6.pageComponents.Benefit;
import hw6.pageComponents.Frame;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    private final Frame frame = new Frame(this);
    private final Benefit benefit = new Benefit(webDriver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public Frame getFrame() {
        return frame;
    }

    public Frame switchToFrame() {
        webDriver.switchTo().frame(frame.getFrame());
        return new Frame(this);
    }
}
