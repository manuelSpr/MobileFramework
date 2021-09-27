package Pages.API;

import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccessibilityContentPage extends Hooks {

    public AccessibilityContentPage(){}

    @AndroidFindBy(id = "android:id/text1")
    private AndroidElement btnNavigationOption;

    public boolean validation(){
        return btnNavigationOption.isDisplayed();
    }

}
