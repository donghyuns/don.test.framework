package don.test.framework.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class CoreSelenium extends CoreCommon {

    public static WebDriver driver;
    public static String SPACE_NAME = "d-";

    public void launchBrowser() {
        try {
            String browser = config.getString("BROWSER");

            String targetEnv = System.getProperty("environment");
            String baseurl = "https://accounts.beamo.dev/";
            if (targetEnv.contains("DEV")) {
                baseurl = config.getString("BASEURLDEV");
                SPACE_NAME = "d-";
            } else if (targetEnv.contains("STAG")) {
                baseurl = config.getString("BASEURLSTAG");
                SPACE_NAME = "s-";
            } else if (targetEnv.contains("LIVE")) {
                baseurl = config.getString("BASEURLLIVE");
                SPACE_NAME = "t";
            }
            //String baseurl = config.getString("BASEURL");

            /*
            //Temporarily added due to Chrome browser 115 issue
            String osType = System.getProperty("os.name").toLowerCase();
            String chromedriverpath = null;
            if (osType.contains("mac")) {
                chromedriverpath = "/Users/chromedriver";
            } else if (osType.contains("win")) {
                chromedriverpath = "C:/Selenium/chromedriver.exe";
            }
            */

            /* Local Mode*/
            // Support only Chrome browser
            switch (browser) {
                case "CH": case "": //Chrome
                    //System.setProperty("webdriver.chrome.driver", chromedriverpath);
                    /* Changed to Selenium 4.6: Selenium Manager
                        // String chromedriver = SeleniumManager.getInstance().getDriverPath("chromedriver");
                        // if (chromedriver == null) throw new Exception("No chromedriver found.");
                        // System.setProperty("webdriver.chrome.driver", chromedriver);
                     */
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--lang=en");
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                case "IE":
                    //driver = new InternetExplorerDriver();
                    break;
                case "FF":
                    //String ffdriver = SeleniumManager.getInstance().getDriverPath("geckodriver");
                    //if (ffdriver == null) throw new Exception("No geckodriver found.");
                    //System.setProperty("webdriver.gecko.driver", ffdriver);
                    driver = new FirefoxDriver();
                    break;
            }

            driver.get(baseurl);
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Grid Mode*/
    public void openBrowserInGrid() throws MalformedURLException {
        isRunningInGrid = true;
        String hubhost = config.getString("HUBHOST");
        String browser = config.getString("BROWSER");

        String targetEnv = System.getProperty("environment");
        String baseurl = "https://accounts.beamo.dev/";
        if (targetEnv.contains("DEV")) {
            baseurl = config.getString("BASEURLDEV");
            SPACE_NAME = "d-";
        } else if (targetEnv.contains("STAG")) {
            baseurl = config.getString("BASEURLSTAG");
            SPACE_NAME = "s-";
        } else if (targetEnv.contains("LIVE")) {
            baseurl = config.getString("BASEURLLIVE");
            SPACE_NAME = "t";
        }

        /* Selenium Grid Mode*/
        switch (browser) {
            case "CH": //Chrome
                //ChromeOptions chromeOptions = new ChromeOptions();
                ThreadSafeWebDriverStorage.startWebDriverSession(hubhost, browser, baseurl);
                break;
            case "IE":
                //driver = new InternetExplorerDriver();
                break;
            case "FF":
                //driver = new FirefoxDriver();
                break;
        }

        ThreadSafeWebDriverStorage.getDriver().manage().window().maximize();
    }

    public void closeBrowserInGrid() {
        try {
            ThreadSafeWebDriverStorage.closeWebDriverSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void startSeleniumServer() throws Exception {

    }

    public void stopSeleniumServer() {
        //seleniumServer.stop();
    }



}
