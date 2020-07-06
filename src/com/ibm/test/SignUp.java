package com.ibm.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class SignUp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo Tab_AmazonWeb"); //cap.setCapability(deviceName, "Lenovo Tab"); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //cap.setCapability(platformName, "Android"); 
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");   ////cap.setCapability(browserName, "Chrome"); 
		cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\SATISHKALE\\Downloads\\IBM\\Upskill Program - Selenium\\SeleniumSetUpFiles\\chromedriver_win32\\chromedriver.exe");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://m.amazon.in");
		
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.findElement(By.id("hmenu-customer-name")).click();
		driver.findElement(By.id("createAccountSubmit")).click();
		driver.findElement(By.id("ap_customer_name")).sendKeys("Rakesh Kumar");
		driver.findElement(By.id("ap_phone_number")).sendKeys("9766734253");
		driver.findElement(By.id("ap_email")).sendKeys("Rakesh.kumar@testmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("test123");
		driver.findElement(By.id("continue")).click();
		//Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//H4[@class='a-alert-heading'][text()='Mobile number already in use']")).getText());
		
	}
	
}
