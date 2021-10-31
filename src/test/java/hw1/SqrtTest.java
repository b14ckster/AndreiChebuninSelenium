package hw1;

import hw1.AbstractCalculatorTest;
import hw1.DataProvidersTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SqrtTest extends AbstractCalculatorTest {

    @Test(dataProvider = "doubleSqrt", dataProviderClass = DataProvidersTest.class)
    public void SqrtDoubleTest (double a) {
        Assert.assertEquals(calculator.sqrt(a), Math.sqrt(Math.abs(a)));
    }
}
