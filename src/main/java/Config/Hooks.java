package Config;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import Config.AndroidConfig;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks {

    public static AndroidDriver<AndroidElement> driver;
    public Hooks(){

    }

    @BeforeMethod
    public void initializeDriver() throws IOException {
        driver = new AndroidConfig().setDriver();
    }

    @AfterClass
    public void closeDriver()
    {
        this.driver.quit();
    }


}
