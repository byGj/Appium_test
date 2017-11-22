package com.occall.ui;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

//import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

//import java.net.MalformedURLException;
import java.net.URL;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

public class loginOccall2 {
	
	private AppiumDriver  driver;
	
	

  @BeforeClass
  public void setup() throws Exception {
	  
	  	DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, ""); 
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "71MBBLG26R76"); 
		cap.setCapability("platformVersion", "5.1"); 
		
		//最主要的是这两个
		cap.setCapability("appPackage", "com.meizu.flyme.calculator");
		cap.setCapability("appActivity", "com.meizu.flyme.calculator.Calculator");
		//不对apk进行重签名，设置很有必要，否则有的apk在重签名之后无法正常使用  
		//cap.setCapability("noSign", "True");
		
		//！重点所在
		cap.setCapability("appWaitActivity","com.meizu.flyme.calculator.Calculator"); //你想要等待启动的Activity名称
		cap.setCapability("sessionOverride", true); // 每次启动时覆盖session，否则第二次后运行会报错不能新建session

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
  }

  
  

  @Test
  public void plus(){
	  
	  //获取1
	  driver.findElementById("com.meizu.flyme.calculator:id/digit1").click();
	  //获取+
	  driver.findElementById("com.meizu.flyme.calculator:id/plus").click();
	  //获取2
	  driver.findElementById("com.meizu.flyme.calculator:id/digit2").click();
	  //获取=
	  driver.findElementById("com.meizu.flyme.calculator:id/eq").click();
	 

  }
  
  @AfterClass
  public void tearDown() throws Exception {
	  
	  driver.quit();
	  
  }



}
