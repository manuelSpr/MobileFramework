package Pages.ZIO;

import Common.SysUtil;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PatientProfilePage {

    SysUtil util;
    public PatientProfilePage(){
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

}
