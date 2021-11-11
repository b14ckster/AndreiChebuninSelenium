package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProvidersSumTest {
    @DataProvider
    public static Object[][] doubleNumbers() {
        return new Object[][]{
                {7.01, -17.8, -10.79},
                {0.01, 0.99, 1.0},
                {128768.1, 9812.2, 138580.3},
                {-98.2, -98.2, -196.4},
                {0.0, 76.9, 76.9},
                {0.0, 0.0, 0.0},
                {6.99, 0.0, 6.99},
                {-3.4, 3.4, 0.0}
        };
    }

    @DataProvider
    public static Object[][] longNumbers() {
        return new Object[][]{
                {7L, -17L, -10L},
                {0L, -0L, 0L},
                {128768L, 9812L, 138580L},
                {-98L, -98L, -196L},
                {0L, 76L, 76L},
                {0L, 0L, 0L},
                {6L, 0L, 6L},
                {-3L, 3L, 0L}
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
