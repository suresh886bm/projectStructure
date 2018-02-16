package com.Cogniphy.Protection.Muthoot.TestSuites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Reports.ERTDaily_Report;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.LogIn;
import com.Cogniphy.Protection.Muthoot.Utility.Utility;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class NewTest extends BaseClass{
	@BeforeClass
	public void beforClass() throws ATUTestRecorderException {
		LogIn.chrome_LogIn();
		ERTDaily_Report.navigate_To_Reports();
	}
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(6000);
	  driver.findElement(By.cssSelector(reader.get("dateFilter_css"))).click();
	  Thread.sleep(8000);
	  
	  String input = "12/06/2017";
	  Date d =new Date(input);
	  SimpleDateFormat df = new SimpleDateFormat("MMM/dd/yyyy");
	  String date =df.format(d);
	  System.out.println(date);
	  String[] split = date.split("/");
	  System.out.println(split[0]+ " "+ split[1]+ " "+ split[2]);
	  String month = split[0]+" "+split[2];
	  System.out.println("month is " + month);
	  
	  while(true) {
		  try {
			  Thread.sleep(10000);
			  WebElement ele = driver.findElement(By.xpath(reader.get("per_date_xpath")));
			  List<WebElement> dates = ele.findElements(By.tagName("td"));
			  driver.findElement(By.xpath("//th[contains(text(), '"+month+"')]")).isDisplayed();
			  for (WebElement element : dates) {
					if(element.getText().equals(split[1]))
		
					 {
						System.out.println(element.getText());
						 element.click();
					 }	
				}
		  }catch(Exception e) {
			  driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/table/thead/tr[1]/th[1]")).click();
			  e.printStackTrace();
		  }
	  }
  }
}
