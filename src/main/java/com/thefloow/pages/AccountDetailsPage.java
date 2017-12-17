package com.thefloow.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountDetailsPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Please enter your details below.']")
    public WebElement textEnterDetails;
    @FindBy(id = "com.thefloow.flo:id/edit_text_first_name")
    public WebElement fieldFirstName;
    @FindBy(id = "com.thefloow.flo:id/edit_text_surname")
    public WebElement fieldSurname;
    @FindBy(id = "com.thefloow.flo:id/edit_text_date_of_birth")
    public WebElement fieldBirthDate;
    @FindBy(id = "com.thefloow.flo:id/edit_text_email")
    public WebElement fieldEmailCreateAccount;
    @FindBy(id = "com.thefloow.flo:id/edit_text_postcode")
    public WebElement fieldPostcode;
    @FindBy(id = "com.thefloow.flo:id/edit_text_company_name")
    public WebElement fieldCompanyName;
    @FindBy(id = "com.thefloow.flo:id/edit_text_password")
    public WebElement fieldPasswordCreateAccount;
    @FindBy(id = "com.thefloow.flo:id/edit_text_confirm_password")
    public WebElement fieldRepeatPasswordCreateAccount;
    @FindBy(id = "com.thefloow.flo:id/button_register")
    public WebElement buttonSubmitAccountDetails;
    @FindBy(id = "android:id/button1")
    public WebElement buttonOk;
    @FindBy(xpath = "//android.widget.TextView[@text='Success']")
    public WebElement textSuccess;
    @FindBy(id = "android:id/message")
    public WebElement textAlert;


    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }
}
