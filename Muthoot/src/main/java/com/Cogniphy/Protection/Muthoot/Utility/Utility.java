package com.Cogniphy.Protection.Muthoot.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends BaseClass{
	
	//-------------------------method to wait---------------------
	public static void waitForLongTime() throws Exception {
		Thread.sleep(180000);
	}
	
	//------------------------------To wait until element present----------------------------------
	public static boolean isElementPresent(By locator, int waitTime) {
		  boolean bFlag=false;
		  try {
			WebDriverWait wait=new WebDriverWait(driver, waitTime);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if(driver.findElement(locator).isDisplayed()){
				bFlag=true;
				System.out.println("Element "+locator+" Is displayed");
				
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element "+locator+"Was Not found in DOM in Time"+waitTime+"Seconds-NoSuchElementException");
		}
		return bFlag;  
	  }
	
	
	  public static Pattern pattern;
	  public static Matcher matcher;

	  private static final String TIME24HOURS_PATTERN =
                "([01]?[0-9]|2[0-3]):[0-5][0-9]";

	  public Utility(){
		  pattern = Pattern.compile(TIME24HOURS_PATTERN);
	  }

	  
	  public boolean validate(final String time){

		  matcher = pattern.matcher(time);
		  return matcher.matches();

	  }
	
	  public static void selectDate() throws InterruptedException {
		  driver.findElement(By.xpath(reader.get("dateFilter_xpath"))).click();
		  String input = "12/06/2017";
		  Date d =new Date(input);
		  SimpleDateFormat df = new SimpleDateFormat("MMMM/dd/yyyy");
		  String date =df.format(d);
		  System.out.println(date);
		  String[] split = date.split("/");
		  System.out.println(split[0]+ " "+ split[1]+ " "+ split[2]);
		  String month = split[0]+" "+split[2];
		  System.out.println("month is " + month);
		  Thread.sleep(6000);
		  driver.findElement(By.cssSelector(reader.get("dateFilter_css"))).click();
		  Thread.sleep(8000);
		  while(true) {
			  try {
				  
				  driver.findElement(By.xpath("//th[contains(text(), '"+month+"')]")).isDisplayed();
				  WebElement ele = driver.findElement(By.xpath(reader.get("per_date_xpath")));
				  List<WebElement> dates = ele.findElements(By.tagName("td"));
				  for (WebElement element : dates) {
						if(element.getText().equals(split[1]))
						 
						 {
							System.out.println(element.getText());
							 element.click();
						 }	
					}
			  }catch(Exception e) {
				  driver.findElement(By.xpath("/html/body/div[9]/div[1]/div[1]/table/thead/tr[1]/th[1]")).click();
				  Thread.sleep(1000);
			  }
		  }
		  
	  }
	  
	  
	  public static void selecteDateFor_GaurdAttendance() throws Exception {
		    Thread.sleep(5000);
			driver.findElement(
					By.cssSelector(reader.get("date_filter_css"))).click();
			Thread.sleep(8000);
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
			new Select(driver.findElement(By.xpath(reader
					.get("Br_cFilter_xpath")))).selectByValue("MFL");
			driver.findElement(By.xpath(reader.get("Br_submit_xpath")))
					.click();
		}
	  
	  
	  @FindBy(how = How.XPATH, using = "//*[@id='datetimerange']")
	  @CacheLookup
	  WebElement dateFilterr ;
	
}
