package WebApps;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Web_Application extends Web_Capabilities {
	
	AndroidDriver<AndroidElement>driver;
	@BeforeTest
	public void web_app() throws MalformedURLException {
		driver=cap();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void webDemo() {
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Masai");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
		// To Find all links on the search results page
	     List<AndroidElement> links = driver.findElements(By.tagName("a"));
	    //To Print the URLs of all the links
	    System.out.println("Total Links: " + links.size());
	    
	    for(int i=0;i<links.size();i++)
	    {
	    	System.out.println(links.get(i).getText());
	    	System.out.println(links.get(i).getAttribute("href"));
	    }
	    
//	    for (WebElement link : links) {
//	        String url = link.getAttribute("href");
//	        System.out.println(url);
//		
//	}
	}

}
