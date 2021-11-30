package hw1.tests;

import hw1.dataProviders.DataProvidersSumTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumTest extends AbstractCalculatorTest {

    @Test(dataProvider = "doubleNumbers", dataProviderClass = DataProvidersSumTest.class)
    public void sumDoubleTest(double first, double second, double result) {
        Assert.assertEquals(calculator.sum(first, second), result, DELTA);
    }

    @Test(dataProvider = "longNumbers", dataProviderClass = DataProvidersSumTest.class)
    public void sumLongTest(long first, long second, long result) {
        Assert.assertEquals(calculator.sum(first, second), result);
    }
}
