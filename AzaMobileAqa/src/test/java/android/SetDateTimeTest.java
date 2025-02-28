package android;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SetDateTimeTest {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android11");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
        desiredCapabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);

    }

    @Test
    public void testSetDateTime() {
        MobileElement viewsOption = driver.findElementByAccessibilityId("Views");
        viewsOption.click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Dialog']")).click();

        MobileElement changeDate = driver.findElementByAccessibilityId("change the date");
        changeDate.click();
        MobileElement chooseDate = driver.findElementByAccessibilityId("27 February 2025");
        chooseDate.click();
        MobileElement clickOk = driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
        clickOk.click();
        List<MobileElement> buttons = driver.findElements(By.xpath("//android.widget.TextView[@clickable='true']"));


        MobileElement changeTime = driver.findElementByAccessibilityId("change the time (spinner)");
        changeTime.click();

        MobileElement hours = driver.findElementByAndroidUIAutomator("new UiSelector().text(\'1\')");
        hours.click();
        hours.clear();
        hours.sendKeys("11");

        MobileElement minutes = driver.findElementByAndroidUIAutomator("new UiSelector().text(\'2\')");
        minutes.click();
        minutes.clear();
        minutes.sendKeys("11");
        MobileElement dayOrNight = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"PM\")");
        dayOrNight.click();
        MobileElement stethetime = driver.findElementByAccessibilityId("android:id/button1");
        stethetime.click();

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


