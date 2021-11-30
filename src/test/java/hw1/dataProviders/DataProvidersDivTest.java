package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProvidersDivTest {
    @DataProvider
    public static Object[][] doubleNumbers() {
        return new Object[][]{
                {7.01, -17.8, -0.393820225},
                {0.01, 0.99, 0.01010101},
                {128768.1, 9812.2, 13.12326491},
                {-98.2, -98.2, 1.0},
                {0.0, 76.9, 0.0},
                {2.0, 0.2, 10.0},
                {6.99, 10.8, 0.64722222},
                {-3.4, 3.4, -1.0}
        };
    }

    @DataProvider
    public static Object[][] longNumbers() {
        return new Object[][]{
                {7L, -17L, -0L},
                {128L, -100L, -1L},
                {-98L, -98L, 1L},
                {0L, 76L, 0L},
                {2L, 4L, 0L},
                {6L, -1L, -6L},
                {-3L, 3L, -1L}
        };
    }
}
