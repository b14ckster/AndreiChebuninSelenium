package hw1;

import hw1.AbstractCalculatorTest;
import hw1.DataProvidersTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SumTest extends AbstractCalculatorTest {

   @Test(dataProvider = "doubleNumbers", dataProviderClass = DataProvidersTest.class)
    public void sumDoubleTest(double first, double second){
        Assert.assertEquals(calculator.sum(first, second), first + second);
    }

    @Test(dataProvider = "longNumbers", dataProviderClass = DataProvidersTest.class)
    public void sumLongTest(double first, double second){
        Assert.assertEquals(calculator.sum(first, second), first + second);
    }
}
