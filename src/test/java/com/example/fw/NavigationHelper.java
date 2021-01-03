package com.example.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(AppiumDriver driver) {
        super(driver);
    }

    public void favorits() {
        waitForElementAndClick(By.xpath("//*[@content-desc='My lists']"), 15);
        waitForElementAndClick(By.id("item_container"), 15);

    }
}
