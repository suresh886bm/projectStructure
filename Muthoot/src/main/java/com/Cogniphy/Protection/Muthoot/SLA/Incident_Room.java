package com.Cogniphy.Protection.Muthoot.SLA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;

public class Incident_Room extends BaseClass {
	// -----------------------------------------Incident Room-----------------------
	public static void navigate_to_Incident_room() throws Exception {
		
		driver.findElement(By.xpath(reader.get("sla_xpath"))).click();
		driver.findElement(By.xpath(reader.get("list_Incident_xpath"))).click();
		new Select(driver.findElement(By.xpath(reader.get("list_drop_xpath")))).selectByValue("ADT Alarm");
		System.out.println("clicked on ADT");
		driver.findElement(By.xpath(reader.get("getData_xpath"))).click();
		Thread.sleep(60000);
		driver.findElement(By.xpath(reader.get("show_drop_xpath"))).click();
		driver.findElement(By.xpath(reader.get("showdrop_All_xpath"))).click();
		
		driver.findElement(By.xpath(reader.get("creation_xpath"))).click();
		driver.findElement(By.xpath(reader.get("creation_xpath"))).click();
		System.out.println("clicked on creation");
	}

	public static List<String> incibraNames;
	//String date
	static Integer i;
	static Integer j;
	public static List<String> incident_BranchNames() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("creationList_xpath"))));
		List<WebElement> dateList = driver.findElements(By.xpath(reader.get("creationList_xpath")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("listBranches_xpath"))));
		List<WebElement> braNames = driver.findElements(By.xpath(reader.get("listBranches_xpath")));
		incibraNames = new ArrayList<String>();
		for ( i = 0; i < dateList.size(); i++) {
			for (j = 0; j < braNames.size(); j++) {
				if(i.equals(j)) {
				String textt = dateList.get(i).getText();
				if(textt.contains("2017-12-06")) {
					incibraNames.add(braNames.get(j).getText());
				}
				}
				}
			}
		 return incibraNames;
	}
	
	public static List<String> incADTtime;
	//String date
	static Integer k;
	static Integer l;
	public static List<String> incident_ActualDATtimes() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("creationList_xpath"))));
		List<WebElement> dateListt = driver.findElements(By.xpath(reader.get("creationList_xpath")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("inciActualADttimes_xpath"))));
		List<WebElement> incTimes = driver.findElements(By.xpath(reader.get("inciActualADttimes_xpath")));
		incADTtime = new ArrayList<String>();
		for ( k = 0; k < dateListt.size(); k++) {
			for (l = 0; l < incTimes.size(); l++) {
				if(k.equals(l)) {
				String textt = dateListt.get(k).getText();
				if(textt.contains("2017-12-06")) {
					incADTtime.add(incTimes.get(l).getText());
				}
				}
				}
			}
		 return incADTtime;
	}
	
	
	
	
	
	
	
}
