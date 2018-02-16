package com.Cogniphy.Protection.Muthoot.Reports;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;

public class ERTSummay_Report extends BaseClass{
	private static final Logger log = Logger.getLogger(ERTSummay_Report.class.getName());
	public static void navigate_to_ERTSummary_Report() {
    	driver.findElement(By.xpath(reader.get("ertsummary_xpath"))).click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
	public static void fetchSummuryRepot() throws Exception {
		Thread.sleep(6000);
		driver.findElement(By.cssSelector(reader.get("dateFilter_css"))).click();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(reader.get("datePickerPreviousButton_xpath"))).click();
		driver.findElement(By.xpath(reader.get("datePickerPreviousButton_xpath"))).click();
		driver.findElement(By.xpath(reader.get("6th_dec_xpath"))).click();
		
		driver.findElement(By.xpath(reader.get("apply_Xpath"))).click();
		
		WebElement element = driver.findElement(By.xpath(reader
				.get("clientFilter_xpath")));
		element.click();
		List<WebElement> list = element.findElements(By.xpath(reader
				.get("clientFilterText_xpath")));
		for (WebElement droptext : list) {
			if (droptext.getText().equals("ALL")) {
				droptext.click();
			}
		}
		
		//new Select(driver.findElement(By.xpath(reader.get("sessionFilter_xpath")))).selectByVisibleText("Morning ERT");
		driver.findElement(By.xpath(reader.get("submit_xpaht"))).click();
		
		fetch_ertReport_Time();
		noOf_Branches_vistedBy("KL/KCH/01");
		
	}
	public static List<String> repAtTime ;
		public static List<String> fetch_ertReport_Time() {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			repAtTime = new ArrayList<String>();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("reportAt_xpath"))));
			List<WebElement> repAt = driver.findElements(By.xpath(reader.get("reportAt_xpath")));
		for(WebElement element : repAt) {
			repAtTime.add(element.getText());
		}
			
			return repAtTime;
		}
		
		public static List<String> inciBranchname;
		public static List<String> summBranch_Names(){
			WebDriverWait wait = new WebDriverWait(driver, 120);
			inciBranchname = new ArrayList<String>();
			while(true) {
			try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("branchNames_xpath"))));
			List<WebElement> repAt = driver.findElements(By.xpath(reader.get("branchNames_xpath")));
			for(WebElement element : repAt) {
				if(element.isDisplayed()) {
			inciBranchname.add(element.getText());
			}
			}
			}catch(Exception e) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				inciBranchname.add(driver.findElement(By.xpath(reader.get("bretab_branchNames_xpath"))).getText());
				log.info(e.toString());
			}
			
			return inciBranchname;
			}
		}
		

		
			
		static String text;
		
		static Integer i;
		static Integer j;
		public static String noOf_Branches_vistedBy(String ertName) throws Exception{
			List<WebElement> braNames = driver.findElements(By.xpath(reader.get("branchName_xpath")));
			List<WebElement> bracount = driver.findElements(By.xpath(reader.get("count_xpath")));
			
			for ( i = 0; i < braNames.size(); i++) {
				for (j = 0; j < bracount.size(); j++) {
					if(i.equals(j)) {
					String names = braNames.get(i).getText();
				    
				    if(bracount.get(j).getText().equals("03:22")) {
				    	bracount.remove(j);
				    	continue;
				    } 
				    	
					if(braNames.get(i).getText().equals(ertName)) {
				     text = bracount.get(j).getText();
				     System.out.println(braNames.get(i).getText() + ":"+ text);
				    
					}
						 
					}
				}
				
			}
			 return text;
		}
		
		public static List<String> actualADTtime;
		public static List<String> actualADTtimings(){
			WebDriverWait wait = new WebDriverWait(driver, 120);
			actualADTtime = new ArrayList<String>();
			while(true) {
			try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("actualADTtimes_xpath"))));
			List<WebElement> repAt = driver.findElements(By.xpath(reader.get("actualADTtimes_xpath")));
			for(WebElement element : repAt) {
				if(element.isDisplayed()) {
					actualADTtime.add(element.getText());
			}
			}
			}catch(Exception e) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				actualADTtime.add(driver.findElement(By.xpath(reader.get("actualADTbreak_xpath"))).getText());
				log.info(e.toString());
			}
			
			return actualADTtime;
			}
		
		}
		
		
		public static List<String> adtRecivedTime;
		public static List<String> aDTRecivedtimings(){
			WebDriverWait wait = new WebDriverWait(driver, 120);
			adtRecivedTime = new ArrayList<String>();
			while(true) {
			try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("adtRecivedTim_xpath"))));
			List<WebElement> repAt = driver.findElements(By.xpath(reader.get("adtRecivedTim_xpath")));
			for(WebElement element : repAt) {
				if(element.isDisplayed()) {
					adtRecivedTime.add(element.getText());
			}
			}
			}catch(Exception e) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				adtRecivedTime.add(driver.findElement(By.xpath(reader.get("adtRecivedBreak_xpath"))).getText());
				log.info(e.toString());
			}
			
			return adtRecivedTime;
			}
		
		}
		static List<String> odoStvalue ;
		public static List<String> odometr_StartValue() {
			odoStvalue = new ArrayList<String>();
			List<WebElement> values = driver.findElements(By.xpath(reader.get("odoStart_xpath")));
			for(WebElement ele :values) {
				odoStvalue.add(ele.getText());
			}
			return odoStvalue;
		}
		
		static List<String> odoEndvalue ;
		public static List<String> odometr_EndValue() {
			odoEndvalue = new ArrayList<String>();
			List<WebElement> values = driver.findElements(By.xpath(reader.get("odoEnd_xpath")));
			for(WebElement ele :values) {
				if(ele.getText() == "") {
					odoEndvalue.add("0");
				}else if(!ele.getText().equals("")) {
				odoEndvalue.add(ele.getText());
				}
			}
			return odoEndvalue;
		}
		
		static List<String> erts ;
		public static List<String> eRTNames() {
			erts = new ArrayList<String>();
			List<WebElement> values = driver.findElements(By.xpath(reader.get("ertnames")));
			for(WebElement ele :values) {
				erts.add(ele.getText());
			}
			return erts;
		}
		
		
		
		
		
		
		public static void navigate_to_Gaurd_CheckList() {
			
			WebDriverWait wait = new WebDriverWait(driver, 300);
			driver.findElement(
					By.cssSelector(reader.get("date_filter_css"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(reader.get("datePickerPreviousButton_xpath"))));
			driver.findElement(
					By.xpath(reader.get("datePickerPreviousButton_xpath")))
					.click();
			driver.findElement(By.xpath(reader.get("5date_xpath"))).click();
			new Select(driver.findElement(By.xpath(reader
					.get("dropdown_xpth")))).selectByValue("AM");
			driver.findElement(By.xpath(reader.get("5date_xpath"))).click();
			driver.findElement(
					By.xpath(reader.get("datePicker_2nd_previous_xpath")))
					.click();
			driver.findElement(By.xpath(reader.get("2nd_5th_dec_xpath")))
					.click();
			new Select(driver.findElement(By.xpath(reader
					.get("2nd_dropdown_xpath")))).selectByValue("PM");
			
			new Select(driver.findElement(By.xpath(reader
					.get("2nd_hour_xpath")))).selectByValue("10");
			driver.findElement(By.xpath(reader.get("ApplyButtonDateERT")))
					.click();
			driver.findElement(By.xpath(reader.get("vehicleFilter_xpath")))
					.click();
			driver.findElement(By.xpath(reader.get("ERT_VH_02"))).click();
			System.out.println("trying to click client filter");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(reader.get("Br_cFilter_xpath"))));
			new Select(driver.findElement(By.xpath(reader
					.get("Br_cFilter_xpath")))).selectByValue("MFL");
			driver.findElement(By.xpath(reader.get("Br_submit_xpath")))
					.click();
		}
}
