package Config;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import Config.AndroidConfig;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks {

    public AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public AndroidDriver<AndroidElement> initializeDriver() throws IOException {
        return this.driver = new AndroidConfig().setDriver();
    }

    @AfterClass
    public void closeDriver()
    {
        this.driver.quit();
    }


}
