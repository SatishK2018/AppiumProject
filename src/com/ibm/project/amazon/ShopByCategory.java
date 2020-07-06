package com.ibm.project.amazon;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class ShopByCategory {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung_AmazonWeb"); //cap.setCapability(deviceName, "Lenovo Tab"); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //cap.setCapability(platformName, "Android"); 
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");   ////cap.setCapability(browserName, "Chrome"); 
		cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\SATISHKALE\\Downloads\\IBM\\Upskill Program - Selenium\\SeleniumSetUpFiles\\chromedriver_win32\\chromedriver.exe");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://m.amazon.in");
		
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.findElement(By.linkText("Shop by Category")).click();
		driver.findElement(By.id("sbdCategory2")).click();
		driver.findElement(By.xpath("//span[text()=' Fire TV Stick with all-new Alexa Voice Remote ']")).click();
		driver.findElement(By.id("configuration-button")).click();
		driver.findElement(By.id("configuration_1")).click();
		driver.findElement(By.xpath("//span[@aria-label='DONE']")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("//*[@class='a-spacing-small sc-action-save-for-later sc-action-button']")).click();
			
	}
	
}
