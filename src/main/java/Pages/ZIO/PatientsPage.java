package Pages.ZIO;

import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PatientsPage extends Hooks {

    SysUtil util;
    public PatientsPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.util = new SysUtil();
    }

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/title")
    private AndroidElement lblTitle;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/search")
    private AndroidElement btnSearch;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/search_src_text")
    private AndroidElement txtSearch;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/name")
    private AndroidElement lblNamePatient;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private AndroidElement btnBack;

    public void setSearch(String search){
        util.waitElement(driver, lblTitle);
        btnSearch.click();
        txtSearch.sendKeys(search);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        util.waitElement(driver, lblNamePatient);
        lblNamePatient.click();
    }

    public void getBack(){
        util.waitElement(driver, btnBack);
        btnBack.click();
    }

}
