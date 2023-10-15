package testngtask;

import org.testng.annotations.DataProvider;


public class DataProviderForParameterized {

    @DataProvider(name = "testSubtractionDataUsingDataProvider")
    public Object[][] dataProviderForSub() {
        return new Object[][]{
                {2, -1, 3},
                {4, 3, 1},
                {-21, 1, -22},
                {12, -13, 25},
                {11, 1, 10},
                {-12, -12, 0}
        };
    }

    @DataProvider(name = "testPerformAddUsingDataProvider")
    public Object[][] dataProviderForAdd() {
        return new Object[][]{
                {2, 1, 3},
                {4, 3, 7},
                {0, 0, 0},
                {12, 13, 25},
                {11, 1, 12},
                {10, 2, 12}
        };
    }

    @DataProvider(name = "testDataForBugTests")
    public Object[][] dataProviderForBugTest() {
        return new Object[][]{
                {2.1, 1.1, 3},
                {4.2, 3.5, 7},
        };
    }

    @DataProvider(name = "dataForBugTests")
    public Object[][] testDataForBugTest() {
        return new Object[][]{
                {9.0, 3.1, 9},
                {4.2, 3.5, 7},
        };
    }

    @DataProvider(name = "testPowerData")
    public Object[][] getDoublePowerData() {
        return new Object[][]{{2.4, 3.9, Math.pow(2.4, 3.9)},
                {7.13, 3.4, Math.pow(7.13, 3.4)},
                {9.2, 2.5, Math.pow(9.2, 2.5)}};
    }

    @DataProvider(name = "testSqrtData")
    public Object[][] getDoubleSqrtData() {
        return new Object[][]{
                {-4.4, Math.sqrt(-4.4)},
                {-9.0, Math.sqrt(-9.0)},
                {-5.6, Math.sqrt(-5.6)}
        };
    }

    @DataProvider(name = "testTanData")
    public Object[][] getDoubleTgData() {
        return new Object[][]{
                {4.4, Math.tan(4.4)},
                {-4.4, Math.tan(-4.4)},
                {-90.0, Math.tan(-90.0)},
                {0.0, Math.tan(0.0)}};
    }


    @DataProvider(name = "testCosData")
    public Object[][] getDoubleCosData() {
        return new Object[][]{
                {4.4, Math.cos(4.4)},
                {-4.4, Math.cos(-4.4)},
                {-90.0, Math.cos(-90.0)},
                {0.0, Math.cos(0.0)},
                {9.2, Math.cos(9.2)}};
    }
}
