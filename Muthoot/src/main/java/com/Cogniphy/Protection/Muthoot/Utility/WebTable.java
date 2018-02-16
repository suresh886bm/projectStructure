package com.Cogniphy.Protection.Muthoot.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTable extends BaseClass{
	
	int i;
	int j;
	int k;
	int l;
//@Test()
public static void read(int i, int j)
{
	//System.setProperty("webdriver.chrome.driver", "D:\\Lib\\chromedriver.exe");	
	//driver=new ChromeDriver();
	//driver.get("http://only-testing-blog.blogspot.in/");
	//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("(//table[@cellpadding='10'])[1]")));
	String[][] appData = null;
	
	 String first_part = "//*[@id=\\\"content-wrapper\\\"]/div/div[2]/table/tbody/tr[";
	 String second_part = "]/td[";
	 String third_part = "]";
	 //(//table[@cellpadding='10'])[1]/tbody/tr[1]/td[.]
	int Row_counr=driver.findElements(By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/table/tbody/tr[.]")).size()+1;
	int Col_counr=driver.findElements(By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/table/tbody/tr[1]/td[.]")).size()+1;
	System.out.println("row count is "+Row_counr +"col count is "+Col_counr);
	
	appData=new String[Row_counr][Col_counr];
	
	for (i = 1; i < Row_counr; i++) {
	for (j = 1; j < Col_counr; j++) {
	String final_xpath = first_part+i+second_part+j+third_part;
	appData[i][j]=driver.findElement(By.xpath(final_xpath)).getText();
	System.out.println(appData[i][j]);
	}
	}
     
	
	//For second table data reading
	/*String[][] appData1 = null;
	
	 String first_part1 = "(//table[@cellpadding='10'])[1]/tbody/tr[";
	 String second_part1 = "]/td[";
	 String third_part1 = "]";
	
	int Row_counr1=driver.findElements(By.xpath("(//table[@cellpadding='10'])[1]/tbody/tr[.]")).size()+1;
	int Col_counr1=driver.findElements(By.xpath("(//table[@cellpadding='10'])[1]/tbody/tr[1]/td[.]")).size()+1;
	System.out.println("row count is "+Row_counr1 +"col count is "+Col_counr1);
	
	appData1=new String[Row_counr1][Col_counr1];
	
	for (k = 1; k < Row_counr1; k++) {
	for (l = 1; l < Col_counr1; l++) {
	String final_xpath1 = first_part1+k+second_part1+l+third_part1;
	appData1[k][l]=driver.findElement(By.xpath(final_xpath1)).getText();
	System.out.println(appData1[k][l]);
	}
	}*/
	
	//To compare the both tables 
	/*for (int m = 1; i < Row_counr; i++) {
     for (int n = 1; j <Col_counr; j++) {
        	
	if (!appData[m][n].trim().equalsIgnoreCase(appData1[m][n])) {
		System.out.println("Data is mismatched while comparing,actual from table one "+appData[i][j]+"but found from table2 is "+appData[i][j]);
	}
	 }
 	}*/
	 System.out.println("***************Success***************");
}
}