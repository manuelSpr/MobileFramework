package Pages.ZIO;

import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PatientProfilePage extends Hooks {

    SysUtil util;
    public PatientProfilePage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.util = new SysUtil();
    }

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/title")
    private AndroidElement lblTitle;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/mainTitle")
    private AndroidElement lblPatientName;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/heading")
    private AndroidElement lblDeviceName;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private AndroidElement btnBack;

    public String getNameDevice(){
        util.waitElement(driver, lblDeviceName);
        return lblDeviceName.getText();
    }

    public void getBack(){
        util.waitElement(driver, btnBack);
        btnBack.click();
    }

}
