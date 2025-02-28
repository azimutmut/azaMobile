package android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ViewsElementsTest {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android11");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
        desiredCapabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);

    }

    @Test
    public void testViewsElementsCount() {
        MobileElement viewsOption = driver.findElementByAccessibilityId("Views");
        viewsOption.click();
        List<MobileElement> clickableItems = driver.findElementsByXPath("//android.widget.TextView[@clickable='true']");
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Splitting Touches across Views\"))"));
        List<MobileElement> clickableItems1 = driver.findElementsByXPath("//android.widget.TextView[@clickable='true']");
        MobileElement element1 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"WebView3\"))"));
        List<MobileElement> clickableItems2 = driver.findElementsByXPath("//android.widget.TextView[@clickable='true']");
        Assert.assertTrue(clickableItems.size() > 0, "Не найдено ни одного элемента в разделе Views");
        System.out.println(clickableItems.size());
        System.out.println(clickableItems1.size());
        System.out.println(clickableItems2.size());
        int totalClickableItems = clickableItems1.size() + clickableItems2.size()+clickableItems.size();
        System.out.println(totalClickableItems);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
