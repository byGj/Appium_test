package com.occall.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Calculator {
		
		private AndroidDriver  driver;
		
		

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
		  
		  driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.Button[2]")).click();
		  
		  //获取1
		  driver.findElementById("com.meizu.flyme.calculator:id/digit2").click();
		  //获取+
		  driver.findElementById("com.meizu.flyme.calculator:id/plus").click();
		  //获取2
		  driver.findElementById("com.meizu.flyme.calculator:id/digit2").click();
		  //获取=
		  driver.findElementById("com.meizu.flyme.calculator:id/eq").click();
		  //等待5秒
		    try{
		    	Thread.sleep(5000);
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		  
		  //获取结果输入框
		  WebElement result = driver.findElementById("com.meizu.flyme.calculator:id/edit_text");
		  
		  System.out.printf("result = \n",driver.findElementById("com.meizu.flyme.calculator:id/edit_text").getText());
		  
		  //等待5秒
		    try{
		    	Thread.sleep(5000);
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		  
		  if(result.getText().equals("3") == true){
			  
			  System.out.println("结果正确 ");
		  }if(result.getText().equals("") == true){
			  
			  System.out.println("结果为空 ");
		  }else{
  
			  System.out.println("获取错误");
			  
		  }
		  
		 

	  }
	  
	  @AfterClass
	  public void tearDown() throws Exception {
		               
		  //driver.quit();
		  
	  }



	}

	

