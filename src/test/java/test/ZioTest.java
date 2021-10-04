package test;
import Common.SysUtil;
import Config.Hooks;
import Pages.ZIO.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import DataTest.DataProvaiders;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import static Common.ConstanData.*;
import org.testng.asserts.SoftAssert;
import static Common.SysUtil.*;


public class ZioTest extends Hooks {

    @Test(testName = "test001", dataProvider = "dataTest001", dataProviderClass = DataProvaiders.class)
    public void loginSuccess(String client, String device, String name, String description) throws IOException {
        SoftAssert softAssertion= new SoftAssert();
        ExtentTest test = extentReports.createTest(name,description);
        SysUtil util = new SysUtil();
        LoginPage loginPage = new LoginPage();
        test.log(Status.INFO, "Test started");
        loginPage.doLogin(EMAIL, PASS);
        PinPage pinPage = new PinPage();
        if(pinPage.isPresent()){
            util.getScreenshot(driver);
            pinPage.setNip(PIN);
        }
        DashboardPage dashboardPage = new DashboardPage();
        test.log(Status.INFO, "Do login successful");
        dashboardPage.goPatients();
        util.getScreenshot(driver);
        PatientsPage patientsPage = new PatientsPage();
        patientsPage.setSearch(client);
        PatientProfilePage profile = new PatientProfilePage();
        test.log(Status.PASS, "Patient Info");
        String nameDevice = profile.getNameDevice();
        String[] data = nameDevice.split(" ");
        if(data[1].equals(device)){
            test.log(Status.PASS, "Correct device");
        } else {
            test.log(Status.ERROR, "Incorrect device");
        }
        util.getScreenshot(driver);
        profile.getBack();
        patientsPage.getBack();
        dashboardPage.goSettings();
        dashboardPage.logOut();
        softAssertion.assertTrue(loginPage.validationLogin(), "The logout was done");
        test.log(Status.PASS, "Logout successful");
        util.getScreenshot(driver);
        test.log(Status.PASS, "Test completed");
        softAssertion.assertAll();
    }


}
