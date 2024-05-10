package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementFunctions;
import utils.SeleniumActions;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "xdget33092_1")
    private WebElement loginBtn;

    @FindBy(id = "xdget642385_1")
    private WebElement successLogin;

    public void enterEmail(String email){
        SeleniumActions.typeTextOnElement(emailField,email);
    }

    public void enterPassword(String password){
        SeleniumActions.typeTextOnElement(passwordField,password);
    }

    public void clickLoginBtn(){
        SeleniumActions.clickOnElement(loginBtn);
    }

    public boolean isUserSuccessfullyLogin(){
        try {
            ElementFunctions.isElementDisplayed(successLogin);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }


}
