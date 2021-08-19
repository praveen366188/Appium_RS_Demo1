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

public class Demo_4_2_RealDevice_Chrome_Browser {

    public static void main(String[] args) throws MalformedURLException {
//         In Mobile go to chrome and see the version from settings-> about and download that chrome from below link
//        https://sites.google.com/a/chromium.org/chromedriver/downloads
//        and extract and put that chromedriver.exe in below folder
//        C:\Users\Praveenkumar\AppData\Roaming\npm\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win
//        this will solve the chrome launch issue.


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        AndroidDriver<AndroidElement>  driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.get("https://praveen366188.github.io/mySite/");




    }


}
