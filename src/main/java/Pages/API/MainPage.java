package Pages.API;
import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Hooks{

    SysUtil util;
    //public AndroidDriver<AndroidElement> driver;
    public MainPage(){
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //this.driver = driver;
        this.util = new SysUtil();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Accessibility']")
    private AndroidElement btnAccessibility;

    public void navigationTo(String option){
        util.waitElement(driver, btnAccessibility);
        util.goSection(option, driver, "android.widget.TextView");
    }
    //android:id/text1
}
