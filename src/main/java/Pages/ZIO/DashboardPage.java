package Pages.ZIO;

import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Hooks {

    SysUtil util;
    public DashboardPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.util = new SysUtil();
    }

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/title")
    private AndroidElement lblTitle;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/patientList")
    private AndroidElement btnPatients;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/settings")
    private AndroidElement btnSettings;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/logout")
    private AndroidElement btnLogOut;

    public void logOut(){
        util.waitElement(driver, btnLogOut);
        btnLogOut.click();
    }

    public void goPatients(){
        util.waitElement(driver, btnPatients);
        util.waitElement(driver, lblTitle);
        btnPatients.click();
    }

    public void goSettings(){
        util.waitElement(driver, btnSettings);
        btnSettings.click();
    }

}
