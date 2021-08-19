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

import static io.appium.java_client.touch.offset.ElementOption.element;

public class Demo_5_1_E_commerce_Login extends Base {

    public static void main(String[] args) throws MalformedURLException {
        File app = new File(new File("src"), "General-Store.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 30_PK");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");

        driver.findElementByXPath("//android.widget.TextView[@text='India']").click();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("selena");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Products']").isDisplayed());


    }


}
