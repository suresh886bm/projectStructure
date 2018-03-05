package com.Cogniphy.Protection.Muthoot.Reports;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;

public class ERT_Performance_Page extends BaseClass {
	private static final Logger log = Logger.getLogger(ERT_Performance_Page.class.getName());
	

	public static void navi_To_ERTPerfmnce() {
		driver.findElement(By.xpath(reader.get("ertPerformance_xpath"))).click();
		log.info("Clicked on ERT Performance Link");
	}

	public static void verify_Page_Title() {
		String text = driver.findElement(By.xpath(reader.get("tab_title_xpath"))).getText();
		Assert.assertEquals("ERT PERFORMANCE", text, "Does not match");
		log.info("Title verified Succesfully");
		
	}

	// It is returning date Perfectly for FUTURE USE
	public static String DayBefore() {
		String DayBefore = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Date before = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		DayBefore = formatter.format(before);
		
		return DayBefore;
	}
	public static void select_Yestreday_Date() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, 300);
		 Thread.sleep(6000);
		 driver.findElement(By.cssSelector(reader.get("dateFilter_css"))).click();
		 Thread.sleep(8000);
		 log.info("clicked on date filter");
		 
		 WebElement ele = driver.findElement(By.xpath(reader.get("per_date_xpath")));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("per_date_xpath"))));
		 List<WebElement> dates = ele.findElements(By.tagName("td"));
		 for (WebElement element : dates) {
			if(element.getText().equals(DayBefore()))
			 
			 {
				 element.click();
				 break;
			 }	
		}
		 log.info("Selected the date from date picker");
		//new Select(driver.findElement(By.id("sessionId"))).selectByVisibleText("Morning ERT");
		 driver.findElement(By.xpath(reader.get("apply_Xpath"))).click();
		 log.info("Clicked on Apply button");
		driver.findElement(By.xpath(reader.get("button_xpath"))).click();
		log.info("Clicked on Submitt button");
	}
	
	public static void Verify_Tab_status_column() {
		if(driver.findElement(By.xpath(reader.get("tabStatus_xpath"))).isDisplayed()) {
			Boolean check = driver.findElement(By.xpath(reader.get("chargeStatus_xpath"))).isDisplayed();
			log.info("Tab status Contains charge status column "+ check );
			
		}
	}
	static Integer i, j ;
	public static void Verify_ManualAttend_for_eachERT() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//new Select(driver.findElement(By.xpath(reader.get("show_xpath")))).selectByVisibleText("ALL");
		driver.findElement(By.xpath(reader.get("table_xpath")));
		List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		List<WebElement> manual = driver.findElements(By.xpath(reader.get("manualAtdnc_xpath")));
		log.info("getting the data manual Attendance");
		for ( i = 0; i < erts.size(); i++) {
			for ( j = 0; j < manual.size(); j++) {
				if(i.equals(j)) {
					String ertNames = erts.get(i).getText();
					String manAtt = manual.get(j).getText();
					log.info("Manual Attendance for "+ertNames+ "=" +manAtt);
				}
			}
		}
		log.info("Manual attendance successfully verified");
		
}
	public static void verify_Biometric_Attendance() {
		List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		List<WebElement> biometric = driver.findElements(By.xpath(reader.get("biometric_xpath")));
		log.info("getting the data Biometric Attendance");
		for ( i = 0; i < erts.size(); i++) {
			for ( j = 0; j < biometric.size(); j++) {
				if(i.equals(j)) {
					String ertNames = erts.get(i).getText();
					String  value = biometric.get(j).getText();
					
					log.info("Biometric Attendance for "+ertNames+ "=" +value);
					
				}
			}
		}
		log.info("Biometric attendance successfully verified");
	}
	    
	
	public static void verify_Adt_Violation() {
		List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		List<WebElement> adtVio = driver.findElements(By.xpath(reader.get("aDT_violate_xpath")));
		log.info("getting the data of ADT Violation");
		for ( i = 0; i < erts.size(); i++) {
			for ( j = 0; j < adtVio.size(); j++) {
				if(i.equals(j)) {
					String ertNames = erts.get(i).getText();
					String  value = adtVio.get(j).getText();
					
					log.info("ADT Violation for "+ertNames+ "=" +value);
					
				}
			}
		}
		log.info("ADT Violation successfully verified");
	}
	
    public static void verify_Gaurd_CheckList() {
    	List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		List<WebElement> gaurdCheck = driver.findElements(By.xpath(reader.get("gaurdList_xpath")));
		log.info("getting the data from GaurdCheckList");
		for ( i = 0; i < erts.size(); i++) {
			for ( j = 0; j < gaurdCheck.size(); j++) {
				if(i.equals(j)) {
					String ertNames = erts.get(i).getText();
					String  value = gaurdCheck.get(j).getText();
					
					log.info("GaurdCheckList for "+ertNames+ "=" +value);
					
				}
			}
		}
		log.info("Gaurd CheckList successfully verified");
    }
    
    public static void verify_branchCheckList() {
    	List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		List<WebElement> branchCheck = driver.findElements(By.xpath(reader.get("branchCheckList")));
		log.info("getting the data from BarnchCheckList");
		for ( i = 0; i < erts.size(); i++) {
			for ( j = 0; j < branchCheck.size(); j++) {
				if(i.equals(j)) {
					String ertNames = erts.get(i).getText();
					String  value = branchCheck.get(j).getText();
					
					log.info("BranchCheckList for "+ertNames+ "=" +value);
					
				}
			}
		}
		log.info("Branch CheckList successfully verified");
    }
    
    public static void verify_BeatDeviation() {
    	List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		List<WebElement> beatDeviatio = driver.findElements(By.xpath(reader.get("beatDeviation")));
		log.info("getting the data from BeatDeviation");
		for ( i = 0; i < erts.size(); i++) {
			for ( j = 0; j < beatDeviatio.size(); j++) {
				if(i.equals(j)) {
					String ertNames = erts.get(i).getText();
					String  value = beatDeviatio.get(j).getText();
					
					log.info("BeatDeviation for "+ertNames+ "=" +value);
					
				}
			}
		}
		log.info("BeatDevition successfully verified");
    }
    
    public static void verify_ScheduleDeviation() {
    	List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		List<WebElement> schedulDeviation = driver.findElements(By.xpath(reader.get("scheduledevn")));
		log.info("getting the data from scheduleDeviation");
		for ( i = 0; i < erts.size(); i++) {
			for ( j = 0; j < schedulDeviation.size(); j++) {
				if(i.equals(j)) {
					String ertNames = erts.get(i).getText();
					String  value = schedulDeviation.get(j).getText();
					
					log.info("scheduleDeviation for "+ertNames+ "=" +value);
					
				}
			}
		}
		log.info("scheduleDeviation successfully verified");
    }
    public static void verify_IncidentPerformance() {
    	List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		List<WebElement> inciperformance = driver.findElements(By.xpath(reader.get("incidentperformance")));
		log.info("getting the data from scheduleDeviation");
		for ( i = 0; i < erts.size(); i++) {
			for ( j = 0; j < inciperformance.size(); j++) {
				if(i.equals(j)) {
					String ertNames = erts.get(i).getText();
					String  value = inciperformance.get(j).getText();
					
					log.info("incident performance for "+ertNames+ "=" +value);
					
				}
			}
		}
		log.info("Incident Performance successfully verified");
    }
    public static void verify_CheckIn_Checkout_deviation() {
    	List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		List<WebElement> checkInOut = driver.findElements(By.xpath(reader.get("checkincheckout")));
		log.info("getting the data from scheduleDeviation");
		for ( i = 0; i < erts.size(); i++) {
			for ( j = 0; j < checkInOut.size(); j++) {
				if(i.equals(j)) {
					String ertNames = erts.get(i).getText();
					String  value = checkInOut.get(j).getText();
					
					log.info("CheckIn Checkout Deviation for "+ertNames+ "=" +value);
					
				}
			}
		}
		log.info("CheckIn Checkout Deviation successfully verified");
    }
    
}


