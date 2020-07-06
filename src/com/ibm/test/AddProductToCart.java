package com.ibm.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AddProductToCart {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo Tab_AmazonWeb"); //cap.setCapability(deviceName, "Lenovo Tab"); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //cap.setCapability(platformName, "Android"); 
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");   ////cap.setCapability(browserName, "Chrome"); 
//		cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
//		cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\SATISHKALE\\Downloads\\IBM\\Upskill Program - Selenium\\SeleniumSetUpFiles\\chromedriver_win32\\chromedriver.exe");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://m.amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 7",Keys.ENTER);
		driver.findElement(By.xpath("//*[@class=\"a-size-medium a-color-base a-text-normal\"][text()='Apple iPhone 7 (32GB) - Black']")).click();
		Set <String> winids = driver.getWindowHandles();	
		System.out.println(winids);
		driver.switchTo().window((String) winids.toArray()[1]);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='a-autoid-9-announce']/div/div[1]/img")).click();
		Set <String> winids1 = driver.getWindowHandles();
		System.out.println(winids1);
		//driver.findElement(By.xpath("//*[@id='quantity']")).sendKeys("5");
		//new Select(driver.findElement(By.xpath("//*[@id='quantity']"))).selectByIndex(4);
		
		/*driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("hlb-view-cart")).click();
		driver.findElement(By.xpath("//*[@type='submit'][@value='Save for later']")).click();*/
		
	}
	
}
