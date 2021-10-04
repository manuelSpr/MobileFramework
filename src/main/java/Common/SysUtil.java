package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import static Common.ConstanData.*;

public class SysUtil {

    public SysUtil(){}

    public void waitElement(AndroidDriver<AndroidElement> driver, AndroidElement element)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_SHORT);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception ex) {
            Reporter.log("++ error: "+ex);
        }
    }

    public void goSection(String title, AndroidDriver<AndroidElement> driver, String base){
        List<AndroidElement> options = driver.findElementsByClassName(base);
        for(AndroidElement element : options){
            if(element.getText().equals(title)){
                element.click();
            }
        }
    }

    public void getScreenshot(AppiumDriver<AndroidElement> driver) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmmss");
        Date date = new Date();
        String name = formatter.format(date).toString();
        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrfile, new File(PATH_SCREENSHOT+name+".jpg"));
    }



}
