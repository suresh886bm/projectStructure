package com.Cogniphy.Protection.Muthoot.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;

public class Gaurd_checklist extends BaseClass{
public static void navigate_to_Gaurd_CheckList() throws Exception {
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
}
