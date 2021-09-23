package Common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;
import static Common.ConstanData.*;

public class SysUtil {

    public SysUtil(){}

    public void waitElement(AndroidDriver<AndroidElement> driver, AndroidElement element)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_SHORT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(String.format(element.toString()))));
        } catch (Exception ex) {
            Reporter.log("++ error: "+ex);
        }
    }

    public void goSection(String title, AndroidDriver<AndroidElement> driver, String base){
        List<AndroidElement> options = driver.findElementsByAndroidUIAutomator(base);
        for(AndroidElement element : options){
            if(element.getText().equals(title)){
                element.click();
            }
        }
    }

}
