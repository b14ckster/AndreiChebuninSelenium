package hw1.tests;

import hw1.dataProviders.DataProvidersSqrtTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SqrtTest extends AbstractCalculatorTest {

    @Test(dataProvider = "doubleSqrt", dataProviderClass = DataProvidersSqrtTest.class)
    public void sqrtDoubleTest(double a, double result) {
        Assert.assertEquals(calculator.sqrt(a), result, DELTA);
    }
}
