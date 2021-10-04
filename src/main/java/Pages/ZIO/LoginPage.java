package Pages.ZIO;

import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends Hooks {

    SysUtil util;
    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.util = new SysUtil();
    }

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/signInButton")
    private AndroidElement btnLogIn;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/textLayout")
    private AndroidElement txtEmail;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/password")
    private AndroidElement txtPassword;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/logo")
    private AndroidElement imgLogo;

    public void doLogin(String email, String pass){
        util.waitElement(driver, btnLogIn);
        List<AndroidElement> txtFields = driver.findElementsByClassName("android.widget.EditText");
        txtFields.get(0).click();
        txtFields.get(0).sendKeys(email);
        txtFields.get(1).click();
        txtFields.get(1).sendKeys(pass);
        btnLogIn.click();
    }

    public boolean validationLogin(){
        util.waitElement(driver, btnLogIn);
        return btnLogIn.isDisplayed();
    }

}
