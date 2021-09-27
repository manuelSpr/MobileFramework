package test;
import Config.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.API.*;

public class ApiTest extends Hooks {

    @Test(testName = "test_001", description = "Validation of accessibility menu")
    public void AccessibilityTest(){
        MainPage mainPage = new MainPage();
        mainPage.navigationTo("Accessibility");
        AccessibilityPage accessibilityPage = new AccessibilityPage();
        accessibilityPage.navegationTo("Accessibility Service");
        AccessibilityContentPage content = new AccessibilityContentPage();
        Assert.assertTrue(content.validation());
    }

}
