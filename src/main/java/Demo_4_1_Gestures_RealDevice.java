import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Demo_4_1_Gestures_RealDevice {

    public static void main(String[] args) throws MalformedURLException {

        File app = new File(new File("src"), "ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //if you want to run in real device you just need to add that "Android device" in capabilities
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        WebElement d1 = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        WebElement d2 = driver.findElementById("io.appium.android.apis:id/drag_dot_2");
        TouchAction t = new TouchAction(driver);
//t.longPress(longPressOptions().withElement(element(d1))).moveTo(element(d2)).release().perform();

        t.longPress(element(d1)).moveTo(element(d2)).release().perform();
//release is very important here otherwise u will get error
        System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Dropped!']").isDisplayed());


    }


}
