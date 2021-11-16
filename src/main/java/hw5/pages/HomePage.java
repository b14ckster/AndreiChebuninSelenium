package hw5.pages;

import hw5.pageComponents.Benefit;
import hw5.pageComponents.Frame;
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
