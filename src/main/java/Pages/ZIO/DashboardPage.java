package Pages.ZIO;

import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DashboardPage extends Hooks {

    SysUtil util;
    public DashboardPage(){
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

}
