package com.Cogniphy.Protection.Muthoot.Reports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.Utility;
import com.Cogniphy.Protection.Muthoot.Utility.WebTable;

public class ERTDaily_Report extends BaseClass {
	private static final Logger log = Logger.getLogger(ERTDaily_Report.class.getName());
	static int i;
	static int j;
	static int dRow_counr;
	static int dCol_counr;
	
	
	public static void navigate_To_Daily_Reports() {
		driver.findElement(By.xpath(reader.get("daily_Reportt"))).click();
	}

	public static void fetch_Daily_report() throws Exception {
        Thread.sleep(6000);
		Utility.selectDateOf("12/18/2017");
		new Select(driver.findElement(By.xpath(reader.get("sessionFilter_xpath")))).selectByVisibleText("Morning ERT");
		submit();
		Utility.waitForLongTime();
	}

	public static void submit() {
		driver.findElement(By.xpath(reader.get("apply"))).click();
		driver.findElement(By.xpath(reader.get("submit"))).click();
	}
	public static List<String> branchCountFromDailyReport() throws Exception {
		List<String> list = new ArrayList<String>();
		Utility.navigate_To_Reports();
		fetch_Daily_report();
		for (int i = 0; i < ERTSummay_Report.namesOf_KOCHI_ERTs().size(); i++) {
			list.add(noOf_Branches_visitedBy(ERTSummay_Report.namesOf_KOCHI_ERTs().get(i)));
		}
		return list;
	}

	static String[][] dRData = null;

	public static void fetch_Data_From_Daily_Report() {
		String first_part = "//table[@id='RptTable']/tbody/tr[";
		String second_part = "]/td[";
		String third_part = "]";
		dRow_counr = driver.findElements(By.xpath(reader.get("table_rows"))).size() + 1;
		dCol_counr = driver.findElements(By.xpath(reader.get("table_cols"))).size() + 1;

		System.out.println("row count is " + dRow_counr + "col count is " + dCol_counr);

		dRData = new String[dRow_counr][dCol_counr];

		for (i = 1; i < dRow_counr; i++) {
			for (j = 1; j < dCol_counr; j++) {
				String final_xpath = first_part + i + second_part + j + third_part;
				dRData[i][j] = driver.findElement(By.xpath(final_xpath)).getText();
				System.out.println(dRData[i][j]);
			}

		}

	}

	public static List<String> repoTime;
	public static List<String> reportAt_Time() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		repoTime = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("repoAt_xpath"))));
		List<WebElement> list = driver.findElements(By.xpath(reader.get("repoAt_xpath")));
		for (int i = 0; i < list.size(); i++) {
			repoTime.add(list.get(i).getText());
		}
		return repoTime;
	}

	public static int nc;
	public static Set<String> text;
	public static List<String> comText;
	public static String count;
	static List<String> totalCount;

	public static String noOf_Branches_visitedBy(String ertName) throws Exception {
	    count = new String();
		text = new HashSet<String>();
		comText = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("ertt_xpath"))));
		List<WebElement> repAt = driver.findElements(By.xpath(reader.get("ertt_xpath")));
		
		for (int i = 0; i < repAt.size(); i++) {
			comText.add(i, repAt.get(i).getText());
			text.addAll(comText);
		}
		for (int i = 0; i < comText.size(); i++) {
			nc = Collections.frequency(comText, ertName);
		}
		count = Integer.toString(nc);
		return count;

	}
	

}
