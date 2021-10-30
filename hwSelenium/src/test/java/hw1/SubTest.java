package hw1;

import hw1.AbstractCalculatorTest;
import hw1.DataProvidersTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubTest extends AbstractCalculatorTest {

    @Test(dataProvider = "doubleNumbers", dataProviderClass = DataProvidersTest.class)
    public void subDoubleTest(double first, double second){
        Assert.assertEquals(calculator.sub(first, second), first - second);
    }

    @Test(dataProvider = "longNumbers", dataProviderClass = DataProvidersTest.class)
    public void subLongTest(double first, double second){
        Assert.assertEquals(calculator.sub(first, second), first - second);
    }
}
