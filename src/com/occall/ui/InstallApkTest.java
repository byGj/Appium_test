package com.occall.ui;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class InstallApkTest {
  
	private AppiumDriver  driver;
	
	

	@BeforeClass
	public void setup() throws Exception {
		   
	    File classpathRoot = new File(System.getProperty("user.dir"));//获得项目路径
	    File appDir = new File(classpathRoot, "apps");//获得APK所在文件夹名称
	    System.out.println(appDir);
	    File app = new File(appDir, "qlt-Google-debug.apk");//获得APK文件
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, ""); 
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "c221baeb"); 
		cap.setCapability("platformVersion", "6.0.1"); 
		
		cap.setCapability("app", app.getAbsolutePath()); //指定需要测试的APK，也就是需要安装的APK文件；
		
		//最主要的是这两个
		cap.setCapability("appPackage", "com.occall.qiaoliantong.test");
		cap.setCapability("appActivity", "com.occall.qiaoliantong.ui.auth.activity.SignInActivity");
	
		
		//
		cap.setCapability("sessionOverride", true); // 每次启动时覆盖session，否则第二次后运行会报错不能新建session

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  }
	
	
	
	
	@Test
	public void f() throws Exception {
		
		//刷新页面等待5秒
	    try{
	    	Thread.sleep(10000);
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	    
	    
	    SwipeClass swiper = new SwipeClass();
	    swiper.swipeToLeft(driver, 2, 3);
	    
		
		// 获取账号输入框+点击+输入账号
		WebElement number = driver.findElement(By.id("com.occall.qiaoliantong.test:id/mobileEt"));
		//WebElement number = driver.findElement(By.name("请输入手机号"));
		number.click();
		number.sendKeys("9990421");

		// 获取密码输入框+点击+输入密码
		WebElement passW = driver.findElement(By.id("com.occall.qiaoliantong.test:id/pwEt"));
		passW.click();
		passW.sendKeys("111111");

		// 点击登录按钮
		WebElement loginbtn = driver.findElement(By.id("com.occall.qiaoliantong.test:id/loginBt"));
		loginbtn.click();
	}
  
	@AfterClass
	public void tearDown() throws Exception {
	  
	  driver.quit();
	  
	  
	}
  
}
