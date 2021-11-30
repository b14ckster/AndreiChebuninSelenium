package hw4.pages;

import hw4.pageComponents.Benefit;
import hw4.pageComponents.Frame;
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

    public HomePage open(String url) {
        webDriver.get(url);
        return this;
    }
}
