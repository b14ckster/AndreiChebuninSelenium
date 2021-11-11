package hw1.tests;

import hw1.dataProviders.DataProvidersMultiplyTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplyTest extends AbstractCalculatorTest {
    @Test(dataProvider = "doubleNumbers", dataProviderClass = DataProvidersMultiplyTest.class)
    public void multiplyDoubleTest(double first, double second, double result) {
        Assert.assertEquals(calculator.mult(first, second), result, DELTA);
    }

    @Test(dataProvider = "longNumbers", dataProviderClass = DataProvidersMultiplyTest.class)
    public void multiplyLongTest(long first, long second, long result) {
        Assert.assertEquals(calculator.mult(first, second), result);
    }
}
