package hw1;

import org.testng.annotations.DataProvider;

public class DataProvidersTest {
    @DataProvider
    public static Object[][] doubleNumbers(){
        return new Object[][]{
                {7.01, -17.8},
                {0.01, 0.99},
                {128768.1, 9812.2},
                {-98.2, -98.2},
                {0, 76.9},
                {0, 0},
                {6.99, 0},
                {-3.4, 3.4},
                {Double.MIN_VALUE, Double.MAX_VALUE}
        };
    }
    @DataProvider
    public static Object[][] longNumbers() {
        return new Object[][]{
                {7L, -17L},
                {0L, -0L},
                {128768L, 9812L},
                {-98L, -98L},
                {0L, 76L},
                {0L, 0L},
                {6L, 0L},
                {-3L, 3L},
                {Long.MIN_VALUE, Long.MAX_VALUE}
        };
    }
    @DataProvider
    public static Object[][] doubleSqrt() {
        return new Object[][]{
                {7.01},
                {0.01},
                {128768.1},
                {-98.2},
                {0},
                {6.99},
                {25},
                {Double.MIN_VALUE},
                {Double.MAX_VALUE}
        };
    }
}
