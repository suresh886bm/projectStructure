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
import org.testng.Assert;

import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.Utility;

import net.bytebuddy.implementation.bytecode.Addition;

public class ERTSummay_Report extends BaseClass{
	private static final Logger log = Logger.getLogger(ERTSummay_Report.class.getName());
	//----------------------select Date For more than3Months-----------------------------
	public static void selectDateFormorethan3Months() throws InterruptedException {
		Utility.selectDateOf("12/18/2017");
	}
	
	//----------------------select DateFor Future days-----------------------------
	
	public static void selectFutureDays() throws InterruptedException {
		Utility.select_tomarrowDate();
		driver.findElement(By.xpath(reader.get("cancel_xpath"))).click();
	}

	public static void clickOnSubmit() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(reader.get("submit"))).click();
		log.info("Clicked on submit button");
	}
	public static void verifyReportTitle() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		List<WebElement> title = driver.findElements(By.xpath(reader.get("tableTitle_xpath")));
		for(WebElement element : title) {
		Assert.assertEquals(element.getText(), "ERT ACTION REPORT SUMMARY OF RCR MUTHOOT KOCHI - RCR REGION ON 18 DEC 2017 Morning ERT", "Does Not Match");
		log.info("title successfully verified :"+element.getText());
		}
	}
	public static void verifyColumnsInThe_SummaryTable() {
		List<WebElement> list = driver.findElements(By.xpath(reader.get("tableColumns_xpath")));
		for(WebElement element  : list) {
			if(element.isDisplayed()) {
				log.info("Columns in the table are :"+element.getText());
			}
		}
		
	}
	public static List<String> repAtTime ;
		public static List<String> ertReportTime() {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			repAtTime = new ArrayList<String>();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("reportAt_xpath"))));
			List<WebElement> repAt = driver.findElements(By.xpath(reader.get("reportAt_xpath")));
		for(WebElement element : repAt) {
			if(element.getText() == "") {
				element.getText().replace("", "0");
				repAtTime.add(element.getText());
			}
			
		}
			System.out.println(repAtTime);
			return repAtTime;
		}
		public static List<String> ertRelievedTime(){
			List<String> timings = new ArrayList<String>();
			List<WebElement> list = driver.findElements(By.xpath(reader.get("relieveTime")));
			for(WebElement element : list) {
				String text = element.getText();
				timings.add(text);
			}
			return timings;
		}
		public static void verifyReportAt_and_RelieveTiming() {
			for (int i = 0; i < ertReportTime().size(); i++) {
				for (int j = 0; j < ertRelievedTime().size(); j++) {
					if(i == j && Integer.parseInt(ertReportTime().get(i)) < Integer.parseInt(ertRelievedTime().get(j))) {
						log.info("Available ReportAt Timings are :"+ertReportTime().get(i));
					}
				}
			}
		}
		public static void checkTimeformat() {
			for (int i = 0; i < ertReportTime().size(); i++) {
				Utility utility = new Utility();
				boolean result = utility.validateTimeFormat(ertReportTime().get(i));
				log.info("Timeformat of ReportAt :" + ertReportTime().get(i) + "=" + result);
				
			}
		}
		static String timings ;
		public static void verifyTimeOfArrival() {
			timings = new String();
			List<WebElement> list = driver.findElements(By.xpath(reader.get("arrival_xpath")));
			Utility utility = new Utility();
			for (int i = 0; i < list.size(); i++) {
				timings = list.get(i).getText();	
				boolean result = utility.validateTimeFormat(timings);
				log.info("Timeformat of ArrivalTime :" + timings + "=" + result);
			}
			
			
		}
		
		public static void verifyTotalRespondingTime() {
			timings = new String();
			List<WebElement> list = driver.findElements(By.xpath(reader.get("totalRespond_xpath")));
			Utility utility = new Utility();
			for (int i = 0; i < list.size(); i++) {
				timings = list.get(i).getText();	
				boolean result = utility.validateTimeFormat(timings);
				log.info("Timeformat of ArrivalTime :" + timings + "=" + result);
			}
		}
		static int sum = 0;
		public static void verifyKMCovered() {
			List<String> kms = new ArrayList<String>();
			List<WebElement> list = driver.findElements(By.xpath(reader.get("km_covered")));
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getText() == "") {
					kms.add("0");
				}
				sum = sum + Integer.parseInt(kms.get(i));
			}
			  log.info("Total No.of KM Covered :"+ sum);
			  String text = driver.findElement(By.xpath(reader.get("km_covered"))).getText();
			  Assert.assertEquals(Integer.parseInt(text), sum, "Total KM Does Not Match");
			
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
		public static List<String> branchCountFromSummaryReport() throws Exception {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < ERTSummay_Report.namesOf_KOCHI_ERTs().size(); i++) {
				list.add(noOf_Branches_vistedBy(ERTSummay_Report.namesOf_KOCHI_ERTs().get(i)));
			}
			return list;
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
		static List<String> start = new ArrayList<String>();
		static List<String> end = new ArrayList<String>();
		static List<String> exact = new ArrayList<String>();
		static List<String> odoStvalue ;
		public static List<String> odometr_StartValue() {
			odoStvalue = new ArrayList<String>();
			List<WebElement> values = driver.findElements(By.xpath(reader.get("odoStart_xpath")));
			for(WebElement ele :values) {
				//odoStvalue.add(ele.getText());
				if(ele.getText() == "") {
					odoStvalue.add("0");
				}else if(!ele.getText().equals("")) {
					odoStvalue.add(ele.getText());
				}
			}
			return odoStvalue;
		}
		public static void addingValues() {
			start.addAll(odometr_StartValue());
			end.addAll(odometr_EndValue());
			exact.addAll(kMcovered());
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
		public static List<String> kMcovered(){
			List<String> values = new ArrayList<String>();
			List<WebElement> list = driver.findElements(By.xpath(reader.get("km_covered")));
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getText() == "") {
					values.add("0");
				}else 
				values.add(list.get(i).getText());
			}
			return values;
		}
        public static void validateKMsRunByVehicles() {
			addingValues();
			for (int i = 0; i < start.size(); i++) {
				for (int j = 0; j < end.size(); j++) {
					for (int j2 = 0; j2 < exact.size(); j2++) {
						
						if(i == j && j == j2 ) {
							int act = Integer.parseInt(end.get(j)) - Integer.parseInt(start.get(i));
							Assert.assertEquals(Integer.parseInt(exact.get(j2)), act);
						}
					}
				}
			}
			
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
		public static void enterDateManually() throws InterruptedException {
			Thread.sleep(6000);
			driver.findElement(By.xpath(reader.get("dateFilter_xpath"))).sendKeys("sas!@#$%124678");
			Thread.sleep(8000);
			driver.findElement(By.xpath(reader.get("cancel_xpath"))).click();
		}
		
		static String clients;
		public static void verifyClientFilter() {
			
			List<WebElement> list = new Select(driver.findElement(By.xpath(reader.get("clientFilter_xpath")))).getOptions();
			for(WebElement elementt : list) {
				clients = elementt.getText();
				if(clients.equals("ALL")) {
					Assert.assertEquals(clients, "ALL", "Does Not Match");
					elementt.click();
				}else if(clients.equals("MF")) {
					Assert.assertEquals(clients, "MF", "Does Not Match");
				}
				else if(clients.equals("MFL")) {
					Assert.assertEquals(clients, "MFL", "Does Not Match");
				}
				else if(clients.equals("MAFIL")) {
					Assert.assertEquals(clients, "MAFIL", "Does Not Match");
				}
				else if(clients.equals("ESAF")) {
					Assert.assertEquals(clients, "ESAF", "Does Not Match");
				}
				
				log.info("Values in ClientFilter dropdown :"+ clients);
			}
	
		}
		
		public static void verifySessionFilter() {
			List<WebElement> list = new Select(driver.findElement(By.xpath(reader.get("sessionFilter_xpath")))).getOptions();
			for(WebElement elementt : list) {
				clients = elementt.getText();
				if(clients.equals("Morning ERT")) {
					Assert.assertEquals(clients, "Morning ERT", "Morning session Does Not Match");
					elementt.click();
				}else if(clients.equals("Night ERT")) {
					Assert.assertEquals(clients, "Night ERT", "Evening session Does Not Match");
				}
				log.info("Values in SessionFilter dropdown :"+ clients);
			}
	
		}
		public static List<String> namesOf_KOCHI_ERTs() {
			List<String> erts = new ArrayList<String>();
			erts.add("KL/KCH/01"); erts.add("KL/KCH/02"); erts.add("KL/KCH/03"); erts.add("KL/KCH/04");
			erts.add("KL/KCH/05");erts.add("KL/KCH/06"); erts.add("KL/KCH/07"); erts.add("KL/KCH/08");
			erts.add("KL/KCH/09"); erts.add("KL/KCH/10"); erts.add("KL/KCH/11"); erts.add("KL/KCH/12");
			erts.add("KL/KCH/13"); erts.add("KL/KCH/14"); erts.add("KL/KCH/15"); erts.add("KL/KCH/16"); 
			erts.add("KL/KCH/17"); erts.add("KL/KCH/18"); erts.add("KL/KCH/19"); erts.add("KL/KCH/20");
			erts.add("KL/KCH/21"); erts.add("KL/KCH/22"); erts.add("KL/KCH/23"); erts.add("KL/KCH/24");
			erts.add("KL/KCH/25");
			return erts;
		}
		public static List<String> namesFrom_Application(){
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			List<String> erts = new ArrayList<String>();
			List<WebElement> list = driver.findElements(By.xpath(reader.get("ertnames")));
			for(WebElement element : list) {
				String text = element.getText();
				erts.add(text);
			}
			return erts;
		}
		public static void verifyAll_ERTs() {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			for (int i = 0; i < namesOf_KOCHI_ERTs().size(); i++) {
				for (int j = 0; j < namesFrom_Application().size() ; j++) {
					if(i == j && namesOf_KOCHI_ERTs().get(i).equals(namesFrom_Application().get(j))) {
						log.info("ERTs From The Application are :"+namesOf_KOCHI_ERTs().get(i));
					}
				}
				
			}
		}
		public static void verifyIrregularities() {
			List<WebElement> adtbrancNames = driver.findElements(By.xpath(reader.get("adtBranchnames_xpath")));
			List<WebElement> irregulrty = driver.findElements(By.xpath(reader.get("irregulrty_xpath")));
			for (int i = 0; i < adtbrancNames.size(); i++) {
				for (int j = 0; j < irregulrty.size(); j++) {
					if(i == j) {
						log.info(adtbrancNames.get(i).getText()+"="+irregulrty.get(j).getText());
					}
				}
			}
		}
		public static void checkTheAction() {
			List<WebElement> adtbrancNames = driver.findElements(By.xpath(reader.get("adtBranchnames_xpath")));
			List<WebElement> actionTaken = driver.findElements(By.xpath(reader.get("actionTaken_xpath")));
			for (int i = 0; i < adtbrancNames.size(); i++) {
				for (int j = 0; j < actionTaken.size(); j++) {
					if(i == j) {
						log.info(adtbrancNames.get(i).getText()+"="+actionTaken.get(j).getText());
					}
				}
			}
		}
		public static void verifyRemarks() {
			List<WebElement> ertNames = driver.findElements(By.xpath(reader.get("ertnames")));
			List<WebElement> remarks = driver.findElements(By.xpath(reader.get("remarks_xpath")));
			for (int i = 0; i < ertNames.size(); i++) {
				for (int j = 0; j < remarks.size(); j++) {
					if(i == j) {
						log.info(ertNames.get(i).getText()+"="+remarks.get(j).getText());
					}
				}
			}
		}
		
}
