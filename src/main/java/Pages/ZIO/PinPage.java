package Pages.ZIO;

import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PinPage extends Hooks {

    SysUtil util;
    public PinPage(){
        this.util = new SysUtil();
    }

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/nextButton")
    private AndroidElement btnNext;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/pinEntryPrompt")
    private AndroidElement lblMessagePin;



}
