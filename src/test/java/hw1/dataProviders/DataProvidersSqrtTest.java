package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProvidersSqrtTest {

    @DataProvider
    public static Object[][] doubleSqrt() {
        return new Object[][]{
                {7.01, 2.64764046},
                {0.01, 0.1},
                {128768.1, 358.8427232},
                {-98.2, 9.90959131},
                {0.0, 0.0},
                {6.99, 2.64386081},
                {25.0, 5.0},
        };
    }
}
