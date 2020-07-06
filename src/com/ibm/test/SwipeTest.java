package com.ibm.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class SwipeTest {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo Tab"); //cap.setCapability(deviceName, "Lenovo Tab"); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //cap.setCapability(platformName, "Android");
		//cap.setCapability(MobileCapabilityType.NO_RESET, true);
		//cap.setCapability("app", ".apk file");  // if .apk is available on your system, provide .apk file path
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().descriptionContains(\"Search\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Search\")")).sendKeys("Math");
//		driver.hideKeyboard();
//		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Doodling in math: Sick number games\")")).click();
		
		//TouchAction touchAction = new TouchAction(driver);
		Dimension d = driver.manage().window().getSize();
		int width = d.width;
		int height = d.height;
		int x1 = width/2;
		int y1 = 4*height/5;
		int x2 = width/2;
		int y2 = height/5;
				
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    while (driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"From Math to Maps\")")).size() == 0) {
	    	System.out.println(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"From Math to Maps\")")).size()); 
	    	driver.executeScript("mobile:shell", ImmutableMap.of("command", "input swipe "+x1+" "+y1+" "+x2+" "+y2));
	    }
	    System.out.println(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"From Math to Maps\")")).size());
	   driver.openNotifications();
	   driver.findElement(MobileBy.id("com.android.systemui:id/quick_settings_container")).click();
	   driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Airplane mode\")")).click();
	   if (driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"OK\")")).isDisplayed())
		   driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"OK\")")).click();
	   driver.pressKey(new KeyEvent(AndroidKey.BACK));
	   //driver.pressKey(new KeyEvent(AndroidKey.HOME));
	   
	   
	   
	}

}
