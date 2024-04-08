package HybridApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HybridApps.Capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class generalStore extends Capabilities {
AndroidDriver<AndroidElement> driver;
	
	
	@BeforeTest
	public  void bt() throws MalformedURLException {
		
		 driver = cap2();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled = true)
	public void general_store() {
		

	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")).click();
	
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jaysingh");
	//com.androidsample.generalstore:id/btnLetsShop
	
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
//	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0);
	
//	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Add To CART\")")).get(0).click();
	
//	driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
	
	driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
	 
//	 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
	 driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
	 
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	 
	String shoes_text = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$160.97\")")).getText();
	String shoes_text2 = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$120.0\")")).getText();
	String total_amount = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	//com.androidsample.generalstore:id/totalAmountLbl
	
	System.out.println("First shoe" + shoes_text);
	System.out.println("Second shoe" + shoes_text2);
	
	System.out.println("Total amount" + total_amount);
	
	String Prod1 = shoes_text.substring(1);
	String Prod2 = shoes_text2.substring(1);
	String TotalPrice = total_amount.substring(2);
	
	Double p1 = Double.parseDouble(Prod1);
	Double p2 = Double.parseDouble(Prod2);
	
	Double total = Double.parseDouble(TotalPrice);
	
	Double TotalPrice2 = p1 + p2;
	System.out.println("Total price " + TotalPrice2);
	
	if(TotalPrice2.equals(total))
	{
		System.out.println("Cost Matching");
	}
	else {
		System.out.println("Cost are not Matching");
	}

	driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
	
	driver.findElement(MobileBy.className("android.widget.Button")).click();
	}

}
