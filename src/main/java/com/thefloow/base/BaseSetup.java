package com.thefloow.base;

import com.thefloow.utils.CalculationUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Initialising Android driver
 */
public class BaseSetup {

    protected final CalculationUtils calculationUtils = new CalculationUtils();

    private static WebDriver initAndroidDriver(String apkName) {
        File file = new File(apkName);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Samsung");
        capabilities.setCapability("deviceReadyTimeout", "3000");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("app", file.getAbsolutePath());
        capabilities.setCapability("clearSystemFiles", true);
        capabilities.setCapability("appWaitActivity", "com.thefloow.flo.activity.TermsAndConditionsActivity");

        WebDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public WebDriver getDriver(String apk) {
        return initAndroidDriver(apk);
    }

}
