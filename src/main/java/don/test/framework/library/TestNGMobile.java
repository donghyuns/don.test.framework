package don.test.framework.library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestNGMobile extends CoreAppium {

    @Parameters({ "configfile" })
    @BeforeSuite(groups = {"abstract_mobile"})
    public void globalSetup(@Optional("src/test/resources/config.properties") String configfile) {
        System.out.println("Starting Mobile BeforeSuite...");

        try {
            initConfigurations(configfile);
            super.startAppiumServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeTest(groups = { "abstract_mobile" })
    public void setUp() throws Exception {
        System.out.println("BeforeTest...");
        try {
            super.startSession();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterTest(groups = { "abstract_mobile" })
    public void tearDown() {
        System.out.println("AfterTest...");
        try {
            super.endSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterSuite(groups = { "abstract_mobile" })
    public void globalTearDown () {
        System.out.println("AfterSuite...");
        super.stopAppiumServer();
    }

    public static WebDriver getDriver() { return driver; }
}
