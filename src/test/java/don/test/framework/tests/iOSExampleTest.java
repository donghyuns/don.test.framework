package don.test.framework.tests;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import don.test.framework.library.TestNGMobile;

public class iOSExampleTest extends TestNGMobile {
    @Test (groups = {"template_mobile"})
    public void verifyLogin() {
        IOSDriver driver = (IOSDriver) getDriver();
        try{
            System.out.println("Test Example run");
            Thread.sleep(5000);
            /*
            WebElement fieldEmail = driver.findElement(AppiumBy.xpath("//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField"));
            fieldEmail.sendKeys("automated.test@3i.ai");
            WebElement fieldPassword = driver.findElement(AppiumBy.xpath("//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField"));
            fieldPassword.sendKeys("3iDev8593");
            WebElement btnLogin = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='로그인']"));
            btnLogin.click();
            */
            Thread.sleep(10000);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            Assert.fail("Login Fail");
        }

    }

}
