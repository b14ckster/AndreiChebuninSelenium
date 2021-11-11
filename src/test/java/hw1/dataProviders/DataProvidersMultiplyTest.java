package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProvidersMultiplyTest {
    @DataProvider
    public static Object[][] doubleNumbers() {
        return new Object[][]{
                {7.01, -17.8, -125.0},
                {0.01, 0.99, 0.0},
                {128768.1, 9812.2, 1.26349835E9},
                {-98.2, -98.2, 9643.},
                {0.0, 76.9, 0.0},
                {0.0, 0.0, 0.0},
                {6.99, 0.0, 0.0},
                {-3.4, 3.4, -12.0}
        };
    }

    @DataProvider
    public static Object[][] longNumbers() {
        return new Object[][]{
                {7L, -17L, -119L},
                {0L, -0L, 0L},
                {-98L, -98L, 9604L},
                {0L, 76L, 0L},
                {0L, 0L, 0L},
                {6L, 0L, 0L},
                {-3L, 3L, -9L}
        };
    }
}
