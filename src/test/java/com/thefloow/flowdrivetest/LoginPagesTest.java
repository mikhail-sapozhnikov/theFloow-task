package com.thefloow.flowdrivetest;

import com.thefloow.base.BaseSetup;
import com.thefloow.pages.AccountDetailsPage;
import com.thefloow.pages.ForgotPasswordPage;
import com.thefloow.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Below tests verify the correctness of the elements on the login pages
 */
public class LoginPagesTest extends BaseSetup {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("FlowDrive.apk");
    }

    @Test
    public void checkLoginPage() {
        System.out.println("Login page test started");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.textTermsAndConditions.isDisplayed());
        loginPage.buttonAgree.click();
        Assert.assertTrue(loginPage.textPleaseLogIn.isDisplayed());
        Assert.assertEquals(loginPage.fieldEmail.getText(), "E-mail address", "[ERROR] Incorrect text in the 'E-mail' field");
        Assert.assertTrue(loginPage.fieldPassword.isEnabled());
        Assert.assertTrue(loginPage.buttonForgotPassword.isEnabled());
        Assert.assertTrue(loginPage.buttonCreateAccount.isEnabled());
        System.out.println("[OK] Login page is displayed correctly");

    }

    @Test
    public void checkForgotPasswordPage() {
        System.out.println("Forgot password page test started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.buttonAgree.click();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPassword();
        Assert.assertTrue(forgotPasswordPage.textForgotPassword.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.textEnterEmail.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.fieldEmailForgotPassword.isEnabled());
        Assert.assertEquals(forgotPasswordPage.fieldEmailForgotPassword.getText(), "E-mail address", "[ERROR] Incorrect text in the 'E-mail' field");
        Assert.assertTrue(!forgotPasswordPage.buttonSend.isEnabled());
        Assert.assertEquals(forgotPasswordPage.buttonSend.getText(), "Send", "[ERROR] Send button has incorrect text");
        Assert.assertTrue(forgotPasswordPage.textReceiveCode.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.textHaveCode.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.textResetPassword.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.buttonResetPassword.isEnabled());
        System.out.println("[OK] Forgot password page is displayed correctly");
    }

    @Test
    public void checkAccountDetailsPage() {
        System.out.println("Account details page test started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.buttonAgree.click();
        AccountDetailsPage accountDetailsPage = loginPage.clickCreateAccount();
        Assert.assertTrue(accountDetailsPage.textEnterDetails.isDisplayed());
        Assert.assertTrue(accountDetailsPage.fieldFirstName.isEnabled());
        Assert.assertEquals(accountDetailsPage.fieldFirstName.getText(), "First name", "[ERROR] Incorrect text in the 'First name' field");
        Assert.assertTrue(accountDetailsPage.fieldSurname.isEnabled());
        Assert.assertEquals(accountDetailsPage.fieldSurname.getText(), "Surname", "[ERROR] Incorrect text in the 'Surname' field");
        Assert.assertTrue(accountDetailsPage.fieldBirthDate.isEnabled());
        Assert.assertEquals(accountDetailsPage.fieldBirthDate.getText(), "Date of birth (at least 17 years old)", "[ERROR] Incorrect text in the 'Date of birth' field");
        Assert.assertTrue(accountDetailsPage.fieldEmailCreateAccount.isEnabled());
        Assert.assertEquals(accountDetailsPage.fieldEmailCreateAccount.getText(), "E-mail address", "[ERROR] Incorrect text in the 'E-mail address' field");
        Assert.assertTrue(accountDetailsPage.fieldPostcode.isEnabled());
        Assert.assertEquals(accountDetailsPage.fieldPostcode.getText(), "Postcode", "[ERROR] Incorrect text in the 'Postcode' field");
        Assert.assertTrue(accountDetailsPage.fieldCompanyName.isEnabled());
        Assert.assertEquals(accountDetailsPage.fieldCompanyName.getText(), "Company name", "[ERROR] Incorrect text in the 'Company name' field");
        Assert.assertTrue(accountDetailsPage.fieldPasswordCreateAccount.isEnabled());
        Assert.assertTrue(accountDetailsPage.fieldRepeatPasswordCreateAccount.isEnabled());
        Assert.assertTrue(!accountDetailsPage.buttonSubmitAccountDetails.isEnabled());
        Assert.assertEquals(accountDetailsPage.buttonSubmitAccountDetails.getText(), "Submit", "[ERROR] 'Submit' button has incorrect text");

        System.out.println("[OK] Account details page is displayed correctly");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
