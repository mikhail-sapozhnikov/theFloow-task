package com.thefloow.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Forgot Password']")
    public WebElement textForgotPassword;
    @FindBy(xpath = "//android.widget.TextView[@text='Please enter the e-mail address that you used to register with us below.']")
    public WebElement textEnterEmail;
    @FindBy(id = "com.thefloow.flo:id/edit_text_email")
    public WebElement fieldEmailForgotPassword;
    @FindBy(id = "com.thefloow.flo:id/btn_get_code")
    public WebElement buttonSend;
    @FindBy(xpath = "//android.widget.TextView[@text=\"You'll receive a 4-digit code so you can reset your password.\"]")
    public WebElement textReceiveCode;
    @FindBy(xpath = "//android.widget.TextView[@text='Have a code?']")
    public WebElement textHaveCode;
    @FindBy(xpath = "//android.widget.TextView[@text='Reset your password here.']")
    public WebElement textResetPassword;
    @FindBy(id = "com.thefloow.flo:id/layout_got_code")
    public WebElement buttonResetPassword;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }


}
