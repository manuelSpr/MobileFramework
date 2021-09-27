package Pages.ZIO;

import Common.SysUtil;
import Config.Hooks;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends Hooks {

    SysUtil util;
    public LoginPage(){
        this.util = new SysUtil();
    }

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/systemButton")
    private AndroidElement btnLogIn;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/systemButton")
    private AndroidElement txtEmail;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/systemButton")
    private AndroidElement txtPassword;

    @AndroidFindBy(id = "com.irhythm.ziomd.qa:id/logo")
    private AndroidElement imgLogo;

    public void doLogin(String user, String pass){
        util.waitElement(driver, btnLogIn);
        txtEmail.sendKeys(user);
        txtPassword.sendKeys(pass);
        btnLogIn.click();
    }

}
