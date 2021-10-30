package hw1;

import hw1.AbstractCalculatorTest;
import hw1.DataProvidersTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplyTest extends AbstractCalculatorTest {
    @Test(dataProvider = "doubleNumbers", dataProviderClass = DataProvidersTest.class)
    public void multiplyDoubleTest(double first, double second){
        Assert.assertEquals(calculator.mult(first, second), Math.floor(first * second));
    }

    @Test(dataProvider = "longNumbers", dataProviderClass = DataProvidersTest.class)
    public void multiplyLongTest(double first, double second){
        Assert.assertEquals(calculator.mult(first, second), Math.floor(first * second));
    }
}
