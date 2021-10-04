package Pages.ZIO;

import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PinPage extends Hooks {

    SysUtil util;
    public PinPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.util = new SysUtil();
    }

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/nextButton")
    private AndroidElement btnNext;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/pinEntryPrompt")
    private AndroidElement lblMessagePin;

    @AndroidFindBy(className = "android.widget.EditText")
    private AndroidElement txtPin;

    @AndroidFindBy(className = "android.widget.TextView")
    private AndroidElement lblConfirmPin;

    public boolean isPresent(){
        util.waitElement(driver, btnNext);
        return btnNext.isDisplayed();
    }

    public void setNip(String pin){
        util.waitElement(driver, btnNext);
        btnNext.click();
        util.waitElement(driver, txtPin);
        txtPin.sendKeys(pin);
        util.waitElement(driver, lblConfirmPin);
        for(int contador = 0; contador<=5; contador++){
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        }
    }

}
