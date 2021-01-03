package com.example.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public AppiumDriver driver;
    DesiredCapabilities capabilities;

    ArticleHelper articleHelper;
    NavigationHelper navigation;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa25_mob");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:\\Users\\Elena\\Documents\\GitHub\\Wiki_25\\apk\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        logger.info("device is Ready");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        articleHelper = new ArticleHelper(driver);
        navigation = new NavigationHelper(driver);

    }

    public void stop() {
        driver.quit();
    }

    public String getAppVersion() {
        return driver.findElement(By.id("app_version_res")).getText();
    }

    public ArticleHelper article() {
        return articleHelper;
    }

    public NavigationHelper navigateTo() {
        return navigation;
    }
}
