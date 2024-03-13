package don.test.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class WebExamplePage extends WebBasePage {

    public WebExamplePage(WebDriver driver) {
        super (driver);
    }

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[1]/*[1]")
    WebElement iconBeamo;

    public WebElement getIconBeamo() {
        return iconBeamo;
    }

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement fieldSpace;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/button[1]")
    WebElement btnSpaceContinue;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement fieldEmail;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/button[1]")
    WebElement btnEmailContinue;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement fieldPassword;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/button[1]")
    WebElement btnLogin;

    public String getPageTitle() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.getTitle();
    }

    public void inputSpaceId(String text) {
        clear(fieldSpace);
        fieldSpace.sendKeys(text);
    }

    public void clickSpaceContinue() {
        click(btnSpaceContinue);
    }

    public void inputEmail(String text) {
        clear(fieldEmail);
        fieldEmail.sendKeys(text);
    }

    public void clickEmailContinue() {
        click(btnEmailContinue);
    }

    public void inputPassword(String text) {
        clear(fieldPassword);
        fieldPassword.sendKeys(text);
    }

    public void clickLogin() {
        click(btnLogin);
    }

}
