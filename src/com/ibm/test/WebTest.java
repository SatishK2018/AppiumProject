package com.ibm.test;

import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo Tab"); //cap.setCapability(deviceName, "Lenovo Tab"); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //cap.setCapability(platformName, "Android"); 
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");   ////cap.setCapability(browserName, "Chrome"); 
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\SATISHKALE\\Downloads\\IBM\\Upskill Program - Selenium\\SeleniumSetUpFiles\\chromedriver_win32\\chromedriver.exe");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium",Keys.ENTER);
		
	}

}
