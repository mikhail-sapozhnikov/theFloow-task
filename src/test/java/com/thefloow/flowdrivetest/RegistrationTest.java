package com.thefloow.flowdrivetest;

import com.thefloow.base.BaseSetup;
import com.thefloow.pages.AccountDetailsPage;
import com.thefloow.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Below tests verify the correctness of the registration functionality
 */
public class RegistrationTest extends BaseSetup {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("FlowDrive.apk");
    }

    @Test
    public void checkRegistrationHappyPath() {

        String num = String.valueOf(calculationUtils.getRandomNum(1000)); // Random number to make entered data unique for every registration

        System.out.println("Registration happy path test started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.buttonAgree.click();
        AccountDetailsPage accountDetailsPage = loginPage.clickCreateAccount();
        accountDetailsPage.fieldFirstName.sendKeys("TestName" + num);
        accountDetailsPage.fieldSurname.sendKeys("TestSurname" + num);
        accountDetailsPage.fieldBirthDate.click();
        accountDetailsPage.buttonOk.click();
        accountDetailsPage.fieldEmailCreateAccount.sendKeys("test" + num + "@" + "test" + num + ".com");
        accountDetailsPage.fieldPostcode.sendKeys(num + "A");
        accountDetailsPage.fieldCompanyName.sendKeys("TestCompany #" + num);
        accountDetailsPage.fieldPasswordCreateAccount.sendKeys("Ab12#$(" + num);
        accountDetailsPage.fieldRepeatPasswordCreateAccount.sendKeys("Ab12#$(" + num);
        accountDetailsPage.buttonSubmitAccountDetails.click();
        Assert.assertTrue(accountDetailsPage.textSuccess.isDisplayed());

        System.out.println("[OK] Registration complete successfully");
    }

    @Test
    public void checkPasswordValidation() {

        System.out.println("Password validation test started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.buttonAgree.click();
        AccountDetailsPage accountDetailsPage = loginPage.clickCreateAccount();
        accountDetailsPage.fieldFirstName.sendKeys("TestName");
        accountDetailsPage.fieldSurname.sendKeys("TestSurname");
        accountDetailsPage.fieldBirthDate.click();
        accountDetailsPage.buttonOk.click();
        accountDetailsPage.fieldEmailCreateAccount.sendKeys("test@test.com");
        accountDetailsPage.fieldPostcode.sendKeys("12345A");
        accountDetailsPage.fieldCompanyName.sendKeys("TestCompany");
        accountDetailsPage.fieldPasswordCreateAccount.sendKeys("1");
        accountDetailsPage.fieldRepeatPasswordCreateAccount.sendKeys("1");
        accountDetailsPage.buttonSubmitAccountDetails.click();
        Assert.assertEquals(accountDetailsPage.textAlert.getText(), "Password: 8 characters needed.", "[ERROR] Password validation alert is incorrect");
        accountDetailsPage.buttonOk.click();
        accountDetailsPage.fieldPasswordCreateAccount.sendKeys("12345678");
        accountDetailsPage.buttonSubmitAccountDetails.click();
        Assert.assertEquals(accountDetailsPage.textAlert.getText(), "Password: 1 letter needed.", "[ERROR] Password validation alert is incorrect");
        accountDetailsPage.buttonOk.click();
        accountDetailsPage.fieldPasswordCreateAccount.sendKeys("12345678A");
        accountDetailsPage.buttonSubmitAccountDetails.click();
        Assert.assertEquals(accountDetailsPage.textAlert.getText(), "Password: Confirmation does not match.", "[ERROR] Password validation alert is incorrect");

        System.out.println("[OK] Password validation test complete successfully");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
