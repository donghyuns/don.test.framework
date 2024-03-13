package don.test.framework.tests;

import don.test.framework.library.TestNGWeb;
import don.test.framework.pages.WebExamplePage;

import don.test.framework.library.ThreadSafeWebDriverStorage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.time.Duration;

import static org.testng.Assert.*;

public class WebExampleTest extends TestNGWeb {
    @Test (groups = { "template_web" })
    public void verifyBeamoPortalLandingPage() {
        WebDriver driver = ThreadSafeWebDriverStorage.getDriver();
        //Page loading timeout (10s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            // Add test scripts here
            WebExamplePage pLogin = new WebExamplePage(driver);
            String loginTitle = pLogin.getPageTitle();

            // Add Assertion
            assertEquals(loginTitle, "Beamo - Accounts");

        } catch (Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
    }

}
