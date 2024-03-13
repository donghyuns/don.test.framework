package don.test.framework.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
public class CoreAppium extends CoreCommon {
    private static AppiumDriverLocalService service;
    public static AppiumDriver driver;

    public void startAppiumServer() {
        try {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void stopAppiumServer() {
        try {
            if (service != null) service.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startSession() throws Exception {
        String deviceName = config.getString("DEVICENAME");
        System.out.println(deviceName);
        //deviceName = "EMPTY";
        String capabilityName = (deviceName.replace(" ", "")).toLowerCase();
        System.out.println(capabilityName);
        try {
            DesiredCapabilities capabilities = CapabilitiesReader.getDesiredCapabilities(capabilityName);
            System.out.println("getDesiredCapabilities");
            switch (capabilityName.substring(0, 6)) {
                case "iphone": // iOS driver 시작
                    try {
                        System.out.println("iOS");
                        driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), capabilities);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "galaxy": // Android driver 시작
                    try {
                        System.out.println("Android");
                        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("There is no device set up");
                    break;
            }
        }catch (Exception e) {
            System.out.println("There is no device set up");

        }

    }

    public void endSession() {
        if (driver != null) {
            driver.quit();
        }
    }
}
