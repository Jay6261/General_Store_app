package WebApps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Web_Capabilities {
	
public static AndroidDriver<AndroidElement> cap() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "M2101K6P");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "G://Chrome-Driver//chromedriver-win64//chromedriver.exe");
		
	
        dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c",false));
		
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		return driver;
}

}
