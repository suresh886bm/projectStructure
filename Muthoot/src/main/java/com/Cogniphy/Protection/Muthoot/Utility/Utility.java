package com.Cogniphy.Protection.Muthoot.Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cogniphy.Protection.Muthoot.Reports.ERTDaily_Report;
import com.Cogniphy.Protection.Muthoot.Reports.RCR_Reports;

public class Utility extends BaseClass {
	private static final Logger log = Logger.getLogger(Utility.class.getName());

	// -------------------------method to wait---------------------
	public static void waitForLongTime() throws Exception {
		Thread.sleep(10000);
	}

	// ------------------------------To wait until element present----------------------------------
	public static boolean isElementPresent(By locator, int waitTime) {
		boolean bFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if (driver.findElement(locator).isDisplayed()) {
				bFlag = true;
				System.out.println("Element " + locator + " Is displayed");

			}
		} catch (NoSuchElementException e) {
			System.out.println("Element " + locator + "Was Not found in DOM in Time" + waitTime
					+ "Seconds-NoSuchElementException");
		}
		return bFlag;
	}

	public static Pattern pattern;
	public static Matcher matcher;

	private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

	public Utility() {
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
	}

	public static boolean validateTimeFormat(final String time) {

		matcher = pattern.matcher(time);
		return matcher.matches();

	}

	public static void selectDate(String enterDate) throws InterruptedException {
		
		driver.findElement(By.xpath(reader.get("dateFilter_xpath"))).click();
		String input = enterDate;
		Date d = new Date(input);
		SimpleDateFormat df = new SimpleDateFormat("MMM/dd/yyyy");
		String date = df.format(d);

		String[] split = date.split("/");
		
		String month = split[0] + " " + split[2];
		while (true) {
			try {
				driver.findElement(By.xpath("//*[contains(text(), '" + month + "')]")).isDisplayed();
				WebElement datePick = driver.findElement(By.xpath(reader.get("rcrdateFilter")));
				List<WebElement> list = datePick.findElements(By.tagName("td"));
				for (WebElement element : list) {
					String text = element.getText();
					if (text.equals(split[1]))

					{
						element.click();
						break;
					}

				}
				break;
			} catch (Exception e) {

				driver.findElement(By.xpath(reader.get("gdAtLeftterm_xpath"))).click();

			}

		}
	}

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

		WebElement ele = driver.findElement(By.xpath(reader.get("rcrdate2nd_xpath")));

		List<WebElement> dates = ele.findElements(By.tagName("td"));
		for (WebElement element : dates) {
			if (element.getText().equals(DayBefore()))

			{
				element.click();
				break;
			}
		}

	}
	public static String future() throws InterruptedException {
		driver.findElement(By.xpath(reader.get("dateFilter_xpath"))).click();
		String tomarrow = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, +10);
		Date before = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		tomarrow = formatter.format(before);

		return tomarrow;
	}
	public static void select_tomarrowDate() throws InterruptedException {
	
		WebElement ele = driver.findElement(By.xpath(reader.get("tableHead_xpath")));
		List<WebElement> dates = ele.findElements(By.tagName("td"));
		for (WebElement element : dates) {
			if (element.getText().equals(future()))

			{
				element.click();
				break;
			}
			
		}

	}

	public static void submit() {
		driver.findElement(By.xpath(reader.get("apply"))).click();
		driver.findElement(By.xpath(reader.get("submit"))).click();
	}

	public static void bringDataForLastMonth() throws InterruptedException {
		selectDate("01/18/2018");
		select_Yestreday_Date();
		submit();
	}

	public static void bringDataForLastTwoMonth() throws InterruptedException {
		selectDate("12/18/2017");
		select_Yestreday_Date();
		submit();
	}

	public static void bringDataForLastThreeMonth() throws InterruptedException {
		selectDate("11/18/2017");
		select_Yestreday_Date();
		submit();
	}

	public static void selectDateOf(String enterDate) throws InterruptedException {
		driver.findElement(By.xpath(reader.get("dateFilter_xpath"))).click();
		String input = enterDate;
		Date d = new Date(input);
		SimpleDateFormat df = new SimpleDateFormat("MMM/dd/yyyy");
		String date = df.format(d);
		String[] split = date.split("/");
		String month = split[0] + " " + split[2];
		
		while(true) {
			try {
				driver.findElement(By.xpath("//th[contains(text(), '" + month + "')]")).isDisplayed();
				WebElement datePick = driver.findElement(By.xpath(reader.get("tableHead_xpath")));
				List<WebElement> list = datePick.findElements(By.tagName("td"));
				for (WebElement element : list) {
					String text = element.getText();
					if (text.equals(split[1]))
					{
						element.click();
						break;
					}
				}
				break;
			} catch (Exception e) {

				driver.findElement(By.xpath(reader.get("datePickerPreviousButton_xpath"))).click();
			}

		}
	}

	public static void navigate_To_Reports() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(reader.get("report_xpath"))).click();
		log.info("naviagated to reports");
		driver.manage().window().maximize();
	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='datetimerange']")
	@CacheLookup
	WebElement dateFilterr;

}
