import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.*;
import static io.appium.java_client.touch.offset.ElementOption.*;

import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Demo_3_1_Gestures_tap extends Base {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        WebElement ex= driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");

TouchAction t=new TouchAction(driver);
//        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(ex))).perform();
t.tap(tapOptions().withElement(element(ex))).perform();





    }



}
