package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProvidersSubTest {
    @DataProvider
    public static Object[][] doubleNumbers() {
        return new Object[][]{
                {7.01, -17.8, 24.81},
                {0.01, 0.99, -0.98},
                {128768.1, 9812.2, 118955.9},
                {-98.2, -98.2, 0.0},
                {0.0, 76.9, -76.9},
                {0.0, 0.0, 0.0},
                {6.99, 0.0, 6.99},
                {-3.4, 3.4, -6.8}
        };
    }

    @DataProvider
    public static Object[][] longNumbers() {
        return new Object[][]{
                {7L, -17L, 24L},
                {0L, -0L, 0L},
                {128768L, 9812L, 118956L},
                {-98L, -98L, 0L},
                {0L, 76L, -76L},
                {0L, 0L, 0L},
                {6L, 0L, 6L},
                {-3L, 3L, -6L}
        };
    }
}
