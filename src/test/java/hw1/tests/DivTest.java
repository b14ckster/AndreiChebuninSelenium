package hw1.tests;

import hw1.dataProviders.DataProvidersDivTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends AbstractCalculatorTest {

    @Test(dataProvider = "doubleNumbers", dataProviderClass = DataProvidersDivTest.class)
    public void divDoubleTest(double first, double second, double result) {
        Assert.assertEquals(calculator.div(first, second), result, DELTA);
    }

    @Test(dataProvider = "longNumbers", dataProviderClass = DataProvidersDivTest.class)
    public void divLongTest(long first, long second, long result) {
        Assert.assertEquals(calculator.div(first, second), result);
    }
}
