package Config;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import static Common.ConstanData.*;

public class AndroidConfig {

    public AndroidConfig(){}

    public AndroidDriver<AndroidElement> setDriver() throws IOException {

        File appDir = new File(PATH_APP);
        File appFile = new File(appDir, getPropertyValue(APP_TO_BE_TESTED));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getPropertyValue(DEVICE_NAME));
        capabilities.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getPropertyValue(AUTOMATION_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getPropertyValue(PLATFORM_NAME));
        URL appiumServerURL = new URL(URL.replace("$$$", getPropertyValue(APPIUM_PORT)));
        io.appium.java_client.android.AndroidDriver<AndroidElement> driver = new io.appium.java_client.android.AndroidDriver<AndroidElement>(appiumServerURL, capabilities);
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_SHORT);
            if(getPropertyValue(APP_TO_BE_TESTED).contains("Api")){
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ELEMENT_API)));
            } else if (getPropertyValue(APP_TO_BE_TESTED).contains("Zio")){
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ELEMENT_ZIO)));
            } else {

            }
            System.out.println("The application is ready");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }

    private static Properties getProperties() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+PATH_RESOURCE);
        Properties properties = new Properties();
        properties.load(file);
        return properties;
    }

    private static String getPropertyValue(String key) throws IOException {
        return getProperties().getProperty(key);
    }

}
