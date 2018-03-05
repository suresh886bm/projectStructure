package com.Cogniphy.Protection.Muthoot.Reports;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cogniphy.Protection.Muthoot.TestSuites.Reports_TestSuite;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;

public class RCR_Reports extends BaseClass {
	private static final Logger log = Logger.getLogger(RCR_Reports.class.getName());
	public static void navigateToRcR_Report() {
		driver.findElement(By.xpath(reader.get("rcr_xpath"))).click();
	}

	public static void openGaurdAttendanceReport() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("gaurdAttendance"))));
		driver.findElement(By.xpath(reader.get("gaurdAttendance"))).click();
		Thread.sleep(6000);
		WebElement filter = driver.findElement(By.xpath(reader.get("dateFilter_xpath")));
		filter.click();
		Thread.sleep(6000);

	}
    static Integer i,j,k,l ;
    static List<String> ernames ;
    static List<String> dates ;
    static List<String> dataList ;
   
	public static void identify_PartialPresent() throws InterruptedException {
		
		ernames = new ArrayList<String>();
		List<WebElement> ertNames = driver.findElements(By.xpath(reader.get("RCRertNames")));
		for (WebElement element : ertNames) {
			ernames.add(element.getText());
		}
		//System.out.println(ernames);
		
		
		dates = new ArrayList<String>();
		List<WebElement> rcrDatess = driver.findElements(By.xpath(reader.get("rcrDates")));
		for ( i = 5; i < rcrDatess.size() - 4; i++) {
			dates.add(rcrDatess.get(i).getText());
		}
		//System.out.println(dates);
		
		for (int m = 0; m < addERTs().size(); m++) {
			fetchOnlyPPDates(addERTs().get(m));
		}
		
	}
	
	
	static void fetchOnlyPPDates(String text) {
		dataList = new ArrayList<String>();
		List<WebElement> preData = driver.findElements(By.xpath(reader.get(text)));
		for ( i = 5; i < preData.size() - 4; i ++) {
			dataList.add(preData.get(i).getText());
		}			
		//System.out.println(dataList);
		
		
		for ( i = 0; i < dates.size(); i++) {
			for ( j = 0; j < dataList.size(); j++) {
				if(i == j && dataList.get(j).equals("PP")) {
					System.out.println(text+"="+dates.get(i)+"="+dataList.get(j));
					log.info(text+" has showed on "+dates.get(i)+" as "+dataList.get(j));
				}
			}
		}
			
	}
	
	
	
	static List<String> ertsName ;
	static List<String> addERTs() {
		ertsName = new ArrayList<String>();
		for (int i = 1; i < 26; i++) {
			ertsName.add("ERT"+i);
		}
		return ertsName;
	}
	

	
	
}
