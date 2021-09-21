package Config;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidConfig {

    public AndroidConfig(){}

    public AndroidDriver<AndroidElement> setDriver() throws MalformedURLException {
        File appDir = new File("src/assets");
        File appFile = new File(appDir, "ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4_API_27");
        capabilities.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
        io.appium.java_client.android.AndroidDriver<AndroidElement> driver = new io.appium.java_client.android.AndroidDriver<AndroidElement>(appiumServerURL, capabilities);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/decor_content_parent")));
            System.out.println("The application is ready");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }

}
