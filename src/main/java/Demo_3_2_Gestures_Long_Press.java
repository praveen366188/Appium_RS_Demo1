import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.LongPressOptions.*;

import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Demo_3_2_Gestures_Long_Press extends Base {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();


        WebElement ex = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");

        TouchAction t = new TouchAction(driver);
        t.longPress(longPressOptions().withElement(element(ex)).withDuration(Duration.ofSeconds(2))).release().perform();

        System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Sample action']").isDisplayed());




    }


}
