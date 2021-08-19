import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Demo_5_3_E_commerce_Verify_Cart extends Base {

    public static void main(String[] args) throws MalformedURLException {
        File app = new File(new File("src"), "General-Store.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 30_PK");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"));");

        driver.findElementByXPath("//android.widget.TextView[@text='Angola']").click();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("selena");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Products']").isDisplayed());

//        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

        int count = 4;
        for (int i = 0; i <= count; i++) {
            if (driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText().equals("Jordan 6 Rings")) {
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Assert.assertEquals(driver.findElementById("com.androidsample.generalstore:id/productName").getText().trim(), "Jordan 6 Rings");

    }


}
