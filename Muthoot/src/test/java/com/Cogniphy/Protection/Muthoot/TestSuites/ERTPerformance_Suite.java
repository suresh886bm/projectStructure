package com.Cogniphy.Protection.Muthoot.TestSuites;

import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Reports.ERTDaily_Report;
import com.Cogniphy.Protection.Muthoot.Reports.ERT_Performance_Page;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.LogIn;
import com.Cogniphy.Protection.Muthoot.Utility.Utility;

public class ERTPerformance_Suite extends BaseClass{
	@Test(priority = 1)
	  public void Login() throws Exception {
		  LogIn.chrome_LogIn();
		  ERTDaily_Report.navigate_To_Reports();
	}
	@Test(priority = 2)
	public void Verify_the_Performance_Report_in_the_submenu() throws InterruptedException {
		ERT_Performance_Page.navi_To_ERTPerfmnce();
		ERT_Performance_Page.verify_Page_Title();
		ERT_Performance_Page.select_Yestreday_Date();
	}
	@Test(priority = 3)
	public void verify_Tab_Status() throws InterruptedException {
		ERT_Performance_Page.Verify_Tab_status_column();
		
	}
	@Test(priority = 4)
	public void verify_ManualAtendance_column() throws InterruptedException {
		ERT_Performance_Page.Verify_ManualAttend_for_eachERT();
	}
	@Test(priority = 5)
	public void verify_Biometric_Atendance_column() throws InterruptedException {
		ERT_Performance_Page.verify_Biometric_Attendance();
	}
	@Test(priority = 6)
	public void verify_ADT_Violation() throws InterruptedException {
		ERT_Performance_Page.verify_Adt_Violation();
	}
	@Test(priority = 7)
	public void verify_GaurdCheckList() throws InterruptedException {
		ERT_Performance_Page.verify_Gaurd_CheckList();
	}
	@Test(priority = 8)
	public void verify_BranchCheckList() throws InterruptedException {
		ERT_Performance_Page.verify_branchCheckList();
	}
	@Test(priority = 9)
	public void verify_BeatDeviation() throws InterruptedException {
		ERT_Performance_Page.verify_BeatDeviation();
	}
	@Test(priority = 10)
	public void verify_SchedulDeviation() throws InterruptedException {
		ERT_Performance_Page.verify_ScheduleDeviation();
	}
	@Test(priority = 11)
	public void verify_IncdenPerformance() throws InterruptedException {
		ERT_Performance_Page.verify_IncidentPerformance();
	}
	@Test(priority = 12)
	public void verify_CheckInCheckoutDeviation() throws InterruptedException {
		ERT_Performance_Page.verify_CheckIn_Checkout_deviation();
	}
	
}
