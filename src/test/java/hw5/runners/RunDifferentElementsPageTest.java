package hw5.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5Features/DifferentElementsTest.feature"},
        glue = {"hw5.steps", "hw5.hooks"}
)
public class RunDifferentElementsPageTest extends AbstractTestNGCucumberTests {
}
