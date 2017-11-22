package com.occall.ui;

import io.appium.java_client.AppiumDriver;

public class SwipeClass {


	public void swipeToLeft(AppiumDriver driver,int during, int num) throws Exception {  
	    int width = driver.manage().window().getSize().width;  
	    int height = driver.manage().window().getSize().height;  
	    for (int i = 0; i < num; i++) {  
	        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);  
	        
	        //延迟
	        Thread.sleep(3000);  
	    }  
	}
	
}
