package com.ibm.project.amazon;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class TodaysDeal {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung_AmazonWeb"); //cap.setCapability(deviceName, "Lenovo Tab"); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //cap.setCapability(platformName, "Android"); 
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");   ////cap.setCapability(browserName, "Chrome"); 
//		cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
//		cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\SATISHKALE\\Downloads\\IBM\\Upskill Program - Selenium\\SeleniumSetUpFiles\\chromedriver_win32\\chromedriver.exe");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://m.amazon.in");
		
		driver.findElement(By.id("nav-button-cart")).click();
		driver.findElement(By.xpath("//*[@id='sc-active-cart']/div[2]/div[1]/a")).click();
		driver.findElement(By.xpath("//div[@class='a-column a-span9 rightSide']")).click();
//		driver.findElement(By.xpath("//*[@id=\"a-autoid-8\"]/span/input")).click();
//		System.out.println(driver.findElement(By.xpath("//*[@id='a-autoid-8']/span/input")).getText());
		
	}
	
}
