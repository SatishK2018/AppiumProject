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


public class AddProductToCart {

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
		
		driver.findElement(By.id("nav-search-keywords")).sendKeys("iPhone 7",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Apple iPhone 7 (32GB) - Black'][@class='a-size-base a-color-base a-text-normal']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("color_name-button")));
		driver.findElement(By.id("color_name-button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("color_name_1")));
		driver.findElement(By.id("color_name_1")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@aria-label='DONE']")));
		driver.findElement(By.xpath("//span[@aria-label='DONE']")).click();
		//new Select(driver.findElement(By.id("mobileQuantityDropDown"))).selectByIndex(4);
		driver.findElement(By.id("mobileQuantityDropDown")).sendKeys("5");
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("//*[@class='a-spacing-small sc-action-save-for-later sc-action-button']")).click();
		
	}
	
}
