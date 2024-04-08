package NativeApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

//some static imports for Touch Actions.
import static io.appium.java_client.touch.TapOptions.tapOptions;
//static import for long press.
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//static imports for elements.
import static io.appium.java_client.touch.offset.ElementOption.element;
//static imports for time.
import static java.time.Duration.ofSeconds;

public class ApiDemos extends Capabilities {
	
AndroidDriver<AndroidElement> driver;
	
	
	@BeforeTest
	public  void bt() throws MalformedURLException {
		
		 driver = cap();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled = false)
	public void abc() throws InterruptedException {
		
//		System.out.println("jaysingh emulator opened");
//		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();
//		driver.findElement(MobileBy.AccessibilityId("Custom View")).click();
//		Thread.sleep(3000);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		Thread.sleep(3000);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		//driver.findElement(MobileBy.xpath("//*[@text='WiFi settings']")).click();
		
		//There are two ways by which we can use text
		//The next method that we use is using AndroidUIAutomator.
		//We use AndroidUIAutomator to identify an element using an attribute.
		//We use UiSelector method for selecting the attribute.
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("jaysingh");
		driver.findElement(MobileBy.id("android:id/button2")).click();
	}

	@Test(enabled = false)
	public void notification()
	{
		driver.openNotifications();
		
		driver.findElement(MobileBy.className("android.widget.ImageView")).click();
	}
	
	@Test(enabled = false)
	public void views()
	{
		System.out.println("API demo is Opened");
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		//If we want to scroll then we need three things
		//1. AndriodUIAutomator
		//2.UiScrollable
		//3.UiSelector
	
		//If you want to scroll to a particular element then you have to use scrollIntoView.
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
	}
	
	@Test(enabled = false)
	public void clickable()
	{
		//If we want to check that the elements are present or not then we use clickable & to check it is clcikable we use
		//UiSelector method & AndroidUIAutomator
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		AndroidElement Click = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)"));
		
		//Click.getSize();
		System.out.println(Click.getSize());
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	@Test(enabled = false)
	public void clock()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		//Date Widgets
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		//2. Inline
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		
		AndroidElement data = driver.findElement(MobileBy.AccessibilityId("12"));
		AndroidElement data1 = driver.findElement(MobileBy.AccessibilityId("2"));
		
		TouchAction ta = new TouchAction(driver);
		
		ta.longPress(longPressOptions().withElement(element(data)).withDuration(ofSeconds(5))).moveTo(element(data1)).release().perform();
	}
	
	@Test(enabled = false)
	public void dragAnddrop()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		//Drag and Drop
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		
		//io.appium.android.apis:id/drag_dot_1
		AndroidElement drag1 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement drag2 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		
		TouchAction ta2 = new TouchAction(driver);
		ta2.longPress(longPressOptions().withElement(element(drag1)).withDuration(ofSeconds(5))).moveTo(element(drag2)).release().perform();
	}
	
	@Test(enabled = false)
	public void expandable_list_fish_name()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
//		Expandable Lists
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		AndroidElement fishname = driver.findElement(MobileBy.xpath("//*[@text='Fish Names']"));
		
		TouchAction ta3 = new TouchAction(driver);
		ta3.longPress(longPressOptions().withElement(element(fishname)).withDuration(ofSeconds(5))).release().perform();
//		ta3.longPress(longPressOptions().withElement(element(fishname)).withDuration(ofSeconds(5))).release().perform();
		
	}
	
	@Test(enabled = true)
	public void os_functionality() throws InterruptedException
	{
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		
		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
		
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Hello jaysingh");
		
		driver.findElement(MobileBy.AccessibilityId("Send")).click();
		
		driver.activateApp("com.google.android.apps.messaging");
		String text = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		
		System.out.println(text);
//		driver.activateApp("io.appium.android.apis");
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}
}
