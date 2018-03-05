package com.Cogniphy.Protection.Muthoot.Utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class LogIn extends BaseClass {
	//static ConfigReader reader = new ConfigReader();
	public static final Logger log = Logger.getLogger(LogIn.class.getName());
	
	public static void chrome_LogIn() throws ATUTestRecorderException {

		BaseClass.beforeTest("chrome");
		log.info("chrome browser Launched");
		driver.findElement(By.id(reader.get("username_id"))).sendKeys(reader.get("UserName"));
		log.info("Username Entered");
		driver.findElement(By.id(reader.get("userpwd_id"))).sendKeys(reader.get("Password"));
		log.info("Password entered");
		driver.findElement(By.name(reader.get("LogIn_name"))).click();
		log.info("Clicked on Login button");
		driver.manage().window().maximize();
	}
	public static void fireFox_LogIn() throws ATUTestRecorderException {
		
		BaseClass.beforeTest("firefox");
		log.info("chrome browser Launched");
		driver.findElement(By.id(reader.get("username_id"))).sendKeys(reader.get("UserName"));
		log.info("Username Entered");
		driver.findElement(By.id(reader.get("userpwd_id"))).sendKeys(reader.get("Password"));
		log.info("Password entered");
		driver.findElement(By.name(reader.get("LogIn_name"))).click();
		log.info("Clicked on Login button");
	}
}
