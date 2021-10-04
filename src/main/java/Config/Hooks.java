package Config;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.android.AndroidElement;
import java.io.IOException;
import java.net.MalformedURLException;
import static Common.ConstanData.*;

public class Hooks {

    public static AndroidDriver<AndroidElement> driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public Hooks(){ }

    @BeforeSuite
    public void reportSetup(){
        htmlReporter = new ExtentHtmlReporter("ReportTest.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
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

    @AfterSuite
    public void reportTearDown(){
        extentReports.flush();
    }

}
