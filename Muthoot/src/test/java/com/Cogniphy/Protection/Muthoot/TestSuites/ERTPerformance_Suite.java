package com.Cogniphy.Protection.Muthoot.TestSuites;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Reports.ERTDaily_Report;
import com.Cogniphy.Protection.Muthoot.Reports.ERT_Performance_Page;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.LogIn;
import com.Cogniphy.Protection.Muthoot.Utility.Utility;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ERTPerformance_Suite extends BaseClass{
	
	
	@Test
	  public void TC_001_Login() throws Exception {
		  LogIn.chrome_LogIn();
		  Utility.navigate_To_Reports();
	}
	@Test
	public void TC_002_Verify_the_Performance_Report_in_the_submenu() throws InterruptedException {
		ERT_Performance_Page.navi_To_ERTPerfmnce();
		ERT_Performance_Page.verify_Page_Title();
		ERT_Performance_Page.select_Yestreday_Date();
	}
	@Test
	public void TC_003_verify_Tab_Status() throws InterruptedException {
		ERT_Performance_Page.Verify_Tab_status_column();
		
	}
	@Test
	public void TC_004_verify_ManualAtendance_column() throws InterruptedException {
		ERT_Performance_Page.Verify_ManualAttend_for_eachERT();
	}
	@Test
	public void TC_005_verify_Biometric_Atendance_column() throws InterruptedException {
		ERT_Performance_Page.verify_Biometric_Attendance();
	}
	@Test
	public void TC_006_verify_ADT_Violation() throws InterruptedException {
		ERT_Performance_Page.verify_Adt_Violation();
	}
	@Test
	public void TC_007_verify_GaurdCheckList() throws InterruptedException {
		ERT_Performance_Page.verify_Gaurd_CheckList();
	}
	@Test
	public void TC_008_verify_BranchCheckList() throws InterruptedException {
		ERT_Performance_Page.verify_branchCheckList();
	}
	@Test
	public void TC_009_verify_BeatDeviation() throws InterruptedException {
		ERT_Performance_Page.verify_BeatDeviation();
	}
	@Test
	public void TC_010_verify_SchedulDeviation() throws InterruptedException {
		ERT_Performance_Page.verify_ScheduleDeviation();
	}
	@Test
	public void TC_011_verify_IncdenPerformance() throws InterruptedException {
		ERT_Performance_Page.verify_IncidentPerformance();
	}
	@Test
	public void TC_012_verify_CheckInCheckoutDeviation() throws InterruptedException {
		ERT_Performance_Page.verify_CheckIn_Checkout_deviation();
	}
	
	@AfterTest
	public void afterTest() throws ATUTestRecorderException {
		//System.gc();
		driver.quit();
		
	}
	
}
