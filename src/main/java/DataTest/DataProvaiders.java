package DataTest;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class DataProvaiders {

    @DataProvider(name = "dataTest001")
    public Object[][] dataTest() {
        return new Object[][] {{"ATESTRR936","AT", "test_01", "validation of device"},{"ATESTRR936","XT","test_02","validation of device"}};
    }

}
