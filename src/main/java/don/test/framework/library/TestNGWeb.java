package don.test.framework.library;

import org.testng.annotations.*;

public class TestNGWeb extends CoreSelenium {

    //public WebDriver driver;
    /*
        To-Do : Any config for Remote Selenium Server in @BeforeTest
     */
    @Parameters({ "configfile" })
    @BeforeSuite(groups = { "abstract_web" })
    public void initFramework(@Optional("src/test/resources/config.properties") String configfile) throws Exception {
        initConfigurations(configfile);
    }
    @BeforeTest(groups = { "abstract_web" })
    public void initTests() throws Exception{
        // Start Selenium Server
        //super.startSeleniumServer();
    }

    // Create global WebDriver
    @BeforeMethod(groups = { "abstract_web", "non-grid" })
    public void setUpTests() {
        //WebDriver driver;
        try {
            super.launchBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Close WebDriver
    @AfterMethod(groups = { "abstract_web", "non-grid" })
    public void tearDownTests() throws Exception{
        try {
            super.closeBrowser();
        } catch (Exception e) {
            //
        }
    }

    // Create global WebDriver in Grid Mode
    @BeforeMethod(groups = { "abstract_web", "grid" })
    public void setUpTestsInGrid() {
        //WebDriver driver;
        try {
            super.openBrowserInGrid();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Close WebDriver in Grid Mode
    @AfterMethod(groups = { "abstract_web", "grid" })
    public void tearDownTestsInGrid() throws Exception{
        try {
            super.closeBrowserInGrid();
        } catch (Exception e) {
            //
        }
    }

    @AfterTest(groups = { "abstract_web" })
    public void cleanUp() {
        try {


        } catch (Exception e) {

        }
    }
/*
    public WebDriver getDriver() {
        return driver; // static handle to Selenium object
    }
*/

}
