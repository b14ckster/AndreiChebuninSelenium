package hw1.tests;

import hw1.dataProviders.DataProvidersSubTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubTest extends AbstractCalculatorTest {

    @Test(dataProvider = "doubleNumbers", dataProviderClass = DataProvidersSubTest.class)
    public void subDoubleTest(double first, double second, double result) {
        Assert.assertEquals(calculator.sub(first, second), result, DELTA);
    }

    @Test(dataProvider = "longNumbers", dataProviderClass = DataProvidersSubTest.class)
    public void subLongTest(long first, long second, long result) {
        Assert.assertEquals(calculator.sub(first, second), result);
    }
}
