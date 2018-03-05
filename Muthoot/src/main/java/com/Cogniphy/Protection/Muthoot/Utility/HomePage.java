package com.Cogniphy.Protection.Muthoot.Utility;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Cogniphy.Protection.Muthoot.Reports.ERTDaily_Report;

public class HomePage extends BaseClass{
	private static final Logger log = Logger.getLogger(HomePage.class.getName());
	public static void verifyHomePageMainMenuLinks() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(By.xpath(reader.get("mainMenu_xpath")));
		for(WebElement element : list) {
			if(element.isDisplayed()) {
				String text = element.getText();
				log.info("Main Menu Elements Are :"+text);
			}
		}
	}
	public static void verifyHomePageQuickLinks() {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(By.tagName("a"));
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getAttribute("class").equals("quickLinks")) {
				String text = list.get(i).getAttribute("title");
				log.info("Quick Link Elements Are :"+text);
			}
		}
		
	}
	public static void getERTSmmaryPage() {
		driver.findElement(By.xpath(reader.get("report_xpath"))).click();
		log.info("Clicked on REPORTS Menu");
		driver.findElement(By.xpath(reader.get("ertsummary_xpath"))).click();
		log.info("Clicked on ERT SUMMARY SubMenu");
		String text = driver.findElement(By.xpath(reader.get("ertsummarypageTitle"))).getText();
		Assert.assertEquals(text, "ERT Summary Report", "Does not Match");
		log.info("Page Title -"+ text +"-Verified Successfully");
	}
	
}
