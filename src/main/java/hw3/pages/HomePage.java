package hw3.pages;

import hw3.pageComponents.Benefit;
import hw3.pageComponents.Frame;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{

    private final Frame frame = new Frame(this);
    private final Benefit benefit = new Benefit(webDriver);

    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
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
