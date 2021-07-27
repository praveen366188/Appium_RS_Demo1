import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Demo_3_2_Gestures_Swipe extends Base {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();

        driver.findElementByXPath("//*[@content-desc='3']").click();
        WebElement e1 = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement e2 = driver.findElementByXPath("//*[@content-desc='45']");
        TouchAction t = new TouchAction(driver);
        t.longPress(longPressOptions().withElement(element(e1)).withDuration(Duration.ofSeconds(3))).moveTo(element(e2)).release().perform();

    }


}
