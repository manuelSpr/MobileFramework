package Pages.ZIO;

import Common.SysUtil;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PatientsPage {

    SysUtil util;
    public PatientsPage(){
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

}
