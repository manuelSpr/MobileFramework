package Pages.API;

import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccessibilityPage extends Hooks {

    SysUtil util;
    public AccessibilityPage(){
        this.util = new SysUtil();
    }

    @AndroidFindBy(id = "android:id/text1")
    private AndroidElement btnNavigationOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Accessibility Service']")
    private AndroidElement btnAccessibilityService;

    public void navegationTo(String option){
        util.waitElement(driver, btnAccessibilityService);
        util.goSection(option, driver, "android:id/text1");
    }



}
