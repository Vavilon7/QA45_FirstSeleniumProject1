package helps;

import com.demoWebShop.fw.BaseHelper;
import data.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageHelper extends BaseHelper {
    public RegisterPageHelper(WebDriver driver) {
        super(driver);
    }
    private static final By EMAIL_ERROR = By.cssSelector(".field-validation-error[data-valmsg-for='Email']");
    private static final By PASSWORD_ERROR = By.cssSelector(".field-validation-error[data-valmsg-for='Password']");

    public boolean isRegisterButtonPresent() {
        return isElementPresent(By.xpath("//a[@href='/register']"));
    }

    public void openRegisterPage() {
        click(By.xpath("//a[@href='/register']"));
    }

    public void fillRegisterForm(Contact contact) {
        type(By.id("FirstName"), contact.getFirstName());
        type(By.id("LastName"), contact.getLastName());
        type(By.id("Email"), contact.getEmail());
        type(By.id("Password"), contact.getPassword());
        type(By.id("ConfirmPassword"), contact.getConfirmPassword());
    }

    public void submitRegisterForm() {
        click(By.id("register-button"));
    }

    public boolean isRegistrationSuccessful() {
        return isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]"));
    }

    public boolean isEmailErrorPresent() {
        return isElementPresent(EMAIL_ERROR);
    }

    public boolean isPasswordErrorPresent() {
        return isElementPresent(PASSWORD_ERROR);
    }

    public boolean isEmailErrorCorrect(String expectedErrorMessage) {
        return getElementText(EMAIL_ERROR).equals(expectedErrorMessage);
    }

    public boolean isPasswordErrorCorrect(String expectedErrorMessage) {
        return getElementText(PASSWORD_ERROR).equals(expectedErrorMessage);
    }

    public void clickOnContinueButton() {
        click(By.xpath("//input[@class='button-1 register-continue-button']"));
    }
}