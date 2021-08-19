import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Demo_1_XPath_Id_ClassName extends Base {

    public static void main(String[] args) throws MalformedURLException {
// In Appium we're having different type of finding element like xpath ID  class etc
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        driver.findElementById("android:id/edit").sendKeys("Praveenkumar");
        driver.findElementById("android:id/button1").click();

        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        System.out.println( driver.findElementByClassName("android.widget.EditText").getText());
        driver.findElementById("android:id/button2").click();


    }
}
