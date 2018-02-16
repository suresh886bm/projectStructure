package com.Cogniphy.Protection.Muthoot.Reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;

public class RCR_Reports extends BaseClass{
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
}
