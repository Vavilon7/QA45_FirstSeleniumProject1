package helps;

import com.demoWebShop.fw.BaseHelper;
import data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageHelper extends BaseHelper {
    public LoginPageHelper(WebDriver driver){
        super(driver);
    }
    private static final By LOGIN_LINK = By.cssSelector("a[href='/login']");
    private static final By EMAIL_FIELD = By.xpath("//*[@name='Email']");
    private static final By PASSWORD_FIELD = By.xpath("//*[@name='Password']");
    private static final By REMEMBER_ME_CHECKBOX = By.xpath("//input[@id='RememberMe']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@class='button-1 login-button']");
    private static final By ERROR_MESSAGE = By.cssSelector(".validation-summary-errors");
    private static final By LOGOUT_BUTTON = By.cssSelector("a[href='/logout']");

    public boolean isLogInPresent() {
        return isElementPresent(LOGIN_LINK);
    }
    public void clickOnLoginLink() {
        click(LOGIN_LINK);
    }
    public void fillLoginForm(User user) {
        type(EMAIL_FIELD, user.getEmail());
        type(PASSWORD_FIELD, user.getPassword());
    }
    public void clickOnRememberMe() {
        click(REMEMBER_ME_CHECKBOX);
    }
    public void clickOnLoginButton() {
        click(LOGIN_BUTTON);
    }
    public boolean isLoginSuccessful() {
        return isElementPresent(LOGOUT_BUTTON);
    }
    public String getLoginErrorText() {
        return getElementText(ERROR_MESSAGE);
    }

}
