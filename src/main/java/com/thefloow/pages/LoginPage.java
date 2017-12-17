package com.thefloow.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(className = "android.widget.Button")
    public WebElement buttonAgree;
    @FindBy(xpath = "//android.view.View[@content-desc='Terms and Conditions']")
    public WebElement textTermsAndConditions;
    @FindBy(xpath = "//android.widget.TextView[@text='Please log in']")
    public WebElement textPleaseLogIn;
    @FindBy(xpath = "//android.widget.EditText[@text='E-mail address']")
    public WebElement fieldEmail;
    @FindBy(id = "com.thefloow.flo:id/edit_text_password")
    public WebElement fieldPassword;
    @FindBy(id = "com.thefloow.flo:id/text_view_forgot_password")
    public WebElement buttonForgotPassword;
    @FindBy(xpath = "//android.widget.TextView[@text='or']")
    public WebElement textOr;
    @FindBy(id = "com.thefloow.flo:id/text_view_create_account")
    public WebElement buttonCreateAccount;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public ForgotPasswordPage clickForgotPassword() {
        buttonForgotPassword.click();
        return new ForgotPasswordPage(this.driver);
    }

    public AccountDetailsPage clickCreateAccount() {
        buttonCreateAccount.click();
        return new AccountDetailsPage(this.driver);
    }

}
