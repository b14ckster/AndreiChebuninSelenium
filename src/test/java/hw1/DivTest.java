package hw1;

import hw1.AbstractCalculatorTest;
import hw1.DataProvidersTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends AbstractCalculatorTest {

    @Test(dataProvider = "doubleNumbers", dataProviderClass = DataProvidersTest.class)
    public void divDoubleTest(double first, double second) {
        Assert.assertEquals(calculator.div(first, second), first / second);
    }

    @Test(dataProvider = "longNumbers", dataProviderClass = DataProvidersTest.class)
    public void divLongTest(double first, double second) {
        Assert.assertEquals(calculator.div(first, second), first / second);
    }
}
