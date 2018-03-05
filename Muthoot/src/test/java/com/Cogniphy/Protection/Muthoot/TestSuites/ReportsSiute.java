package com.Cogniphy.Protection.Muthoot.TestSuites;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Reports.ERTDaily_Report;
import com.Cogniphy.Protection.Muthoot.Reports.ERTSummay_Report;
import com.Cogniphy.Protection.Muthoot.SLA.Incident_Room;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.HomePage;
import com.Cogniphy.Protection.Muthoot.Utility.Utility;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ReportsSiute extends BaseClass {
	private static final Logger log = Logger.getLogger(ERTSummay_Report.class.getName());
	static Integer i, j, k, sum = 0;
	static List<String> branchesVisitedByERTsFromDaily = new ArrayList<String>();
	static List<String> branchesVisitedByERTsFromSummary = new ArrayList<String>();

	static List<String> DailyrepoTimings = new ArrayList<String>();
	static List<String> summRepoTimings = new ArrayList<String>();

	static List<String> summRoomBranches = new ArrayList<String>();
	static List<String> inciRoomBranches = new ArrayList<String>();

	static List<String> summActualADTTimes = new ArrayList<String>();
	static List<String> incActualADTtimes = new ArrayList<String>();

	static List<String> aDTRecivedTimes = new ArrayList<String>();

	static List<String> odoMtrStreadings = new ArrayList<String>();
	static List<String> odoMtrEndreadings = new ArrayList<String>();
	static List<String> ertNamess = new ArrayList<String>();

	@Test
	public void ERT_SUMM_01_Verify_HomePage() throws Exception {
		HomePage.verifyHomePageMainMenuLinks();
		HomePage.verifyHomePageQuickLinks();

		branchesVisitedByERTsFromDaily.addAll(ERTDaily_Report.branchCountFromDailyReport());

		System.out.println(branchesVisitedByERTsFromDaily);
		DailyrepoTimings.addAll(ERTDaily_Report.reportAt_Time());
		System.out.println(DailyrepoTimings);
	}

	@Test
	public static void ERT_SUMM_02_Verify_the_Reports_menu_on_top_bar() {
		HomePage.getERTSmmaryPage();

	}

	@Test(description = "DateFilter, ClientFilter, SessionFilters are Available")
	public static void ERT_SUMM_03_Verify_the_ERT_summary_report_page() {

	}

	@Test
	public static void ERT_SUMM_04_Verify_DateEntry_Manually() throws InterruptedException {
		ERTSummay_Report.enterDateManually();
	}

	@Test
	public static void ERT_SUMM_05_Verify_DateFiter_For_FutureDates() throws InterruptedException {
		ERTSummay_Report.selectFutureDays();

	}

	@Test
	public static void ERT_SUMM_06_Verify_DateFiter_For_Morethan_90days() throws InterruptedException {

		ERTSummay_Report.selectDateFormorethan3Months();

	}

	@Test
	public static void ERT_SUMM_07_Verify_ClientFilter() throws InterruptedException {

		ERTSummay_Report.verifyClientFilter();

	}

	@Test
	public static void ERT_SUMM_08_Verify_SessionFilter() throws Exception {

		ERTSummay_Report.verifySessionFilter();
		ERTSummay_Report.clickOnSubmit();

	}

	@Test
	public static void ERT_SUMM_09_Verify_ReportTitle() throws Exception {
		ERTSummay_Report.verifyReportTitle();

	}

	@Test
	public static void ERT_SUMM_10_Verify_TitleRow() throws Exception {
		ERTSummay_Report.verifyColumnsInThe_SummaryTable();

	}

	@Test(groups = "Critical")
	public static void ERT_SUMM_16_Verify_ERTColumn() throws Exception {
		ERTSummay_Report.verifyAll_ERTs();

	}

	@Test(description = "Bug has to be fix")
	public static void ERT_SUMM_17_Validate_ERT_count() throws Exception {

	}

	@Test
	public static void ERT_SUMM_18_Verify_ReportAt_TimeFormat() throws Exception {
		ERTSummay_Report.checkTimeformat();

	}

	@Test
	public static void ERT_SUMM_19_Validate_the_ERT_Reported_AT_Column() throws Exception {

		summRepoTimings.addAll(ERTSummay_Report.ertReportTime());
		for (int k = 0; k < ERTSummay_Report.namesOf_KOCHI_ERTs().size(); k++) {
			for (int i = 0; i < DailyrepoTimings.size(); i++) {
				for (int j = 0; j < summRepoTimings.size(); j++) {
					if (k == i && i == j && DailyrepoTimings.get(i).equals(summRepoTimings.get(j))) {
						log.info(ERTSummay_Report.namesOf_KOCHI_ERTs().get(k) + "=" + DailyrepoTimings.get(i) + "="
								+ summRepoTimings.get(j));
					}
				}
			}
		}
	}

	@Test(description = "Bug has to be fix")
	public static void ERT_SUMM_20_Validate_ReportAt_with_GaurdCheckList_ReportTime() throws Exception {

	}

	@Test
	public static void ERT_SUMM_21_22_Validate_No_of_the_branches_visited_column() throws Exception {

		branchesVisitedByERTsFromSummary.addAll(ERTSummay_Report.branchCountFromSummaryReport());
		for (int k = 0; k < ERTSummay_Report.namesOf_KOCHI_ERTs().size(); k++) {
			for (int i = 0; i < branchesVisitedByERTsFromDaily.size(); i++) {
				for (int j = 0; j < branchesVisitedByERTsFromSummary.size(); j++) {
					if (k == i && i == j
							&& branchesVisitedByERTsFromDaily.get(i).equals(branchesVisitedByERTsFromSummary.get(j))) {
						log.info(ERTSummay_Report.namesOf_KOCHI_ERTs().get(k) + "="
								+ branchesVisitedByERTsFromDaily.get(i) + "="
								+ branchesVisitedByERTsFromSummary.get(j));
					}
				}
			}
		}
		summRoomBranches.addAll(ERTSummay_Report.summBranch_Names());
		summActualADTTimes.addAll(ERTSummay_Report.actualADTtimings());
		aDTRecivedTimes.addAll(ERTSummay_Report.aDTRecivedtimings());
	}

	@Test
	public static void ERT_SUMM_48_23_24_verify_BranchNames_Under_ADTColumn() throws Exception {
		Incident_Room.navigate_to_Incident_room();
		inciRoomBranches.addAll(Incident_Room.incident_BranchNames());
		for (int i = 0; i < summRoomBranches.size(); i++) {
			for (int j = 0; j < inciRoomBranches.size(); j++) {
				if (summRoomBranches.get(i).equals(inciRoomBranches.get(j))) {
					log.info("Incident Branches are :" + summRoomBranches.get(i) + "=" + inciRoomBranches.get(j));
				} else if (!summRoomBranches.get(i).equals(inciRoomBranches.get(j))) {
					log.info("Not Matched Branches from summ: " + summRoomBranches.get(i));
					log.info("Not Matched Branches from Ince: " + inciRoomBranches.get(j));
				}

			}
		}

	}

	@Test
	public static void ERT_SUMM_49_25_26_Validate_Actual_Time_of_ADT_alarm_column() throws Exception {
		incActualADTtimes.addAll(Incident_Room.incident_ActualDATtimes());
		for (int i = 0; i < summActualADTTimes.size(); i++) {
			for (int j = 0; j < incActualADTtimes.size(); j++) {
				if (summActualADTTimes.get(i).equals(incActualADTtimes.get(j))) {
					log.info("ADT Timings are :" + summActualADTTimes.get(i) + "=" + incActualADTtimes.get(j));
				} else if (!summActualADTTimes.get(i).equals(incActualADTtimes.get(j))) {
					log.info("ADT TIMES ARE NOT MATCHED");
				}

			}
		}
	}

	@Test
	public static void ERT_SUMM_27_Validate_ADTRecived_Time() throws Exception {
		for (int i = 0; i < aDTRecivedTimes.size(); i++) {
			Utility utility = new Utility();
			boolean text = utility.validateTimeFormat(aDTRecivedTimes.get(i));
			log.info("Timeformat of ADT Recived :" + aDTRecivedTimes.get(i) + "=" + text);

		}
	}

	@Test
	public static void ERT_SUMM_31_Verify_timeOf_Arrival_At_destination() throws Exception {
		ERTSummay_Report.verifyTimeOfArrival();
	}

	@Test
	public static void ERT_SUMM_32_Verify_Total_responding_Time() throws Exception {
		ERTSummay_Report.verifyTotalRespondingTime();
	}

	@Test
	public static void ERT_SUMM_33_34_Verify_KM_coveredIn_ADT() throws Exception {
		ERTSummay_Report.verifyKMCovered();
	}

	@Test
	public static void ERT_SUMM_35_Validate_Total_KM_run_by_ERT() throws Exception {
		ERTSummay_Report.validateKMsRunByVehicles();
	}

	@Test
	public static void ERT_SUMM_37_38_Validate_the_ERT_Relieving_Time_column() throws Exception {
		ERTSummay_Report.verifyReportAt_and_RelieveTiming();
	}

	@Test
	public static void ERT_SUMM_39_Verify_the_Irregularities_column() throws Exception {
		ERTSummay_Report.verifyIrregularities();

	}

	@Test
	public static void ERT_SUMM_40_Verify_Action_taken_by_ERT_and_RCR_Column() throws Exception {
		ERTSummay_Report.checkTheAction();
	}

	@Test
	public static void ERT_SUMM_41_42_Verify_Action_taken_by_ERT_and_RCR_Column() throws Exception {
		ERTSummay_Report.verifyRemarks();
	}

	@Test
	public static void ERT_SUMM_43_44_45_Validate_odometer_Values() throws Exception {
		odoMtrStreadings.addAll(ERTSummay_Report.odometr_StartValue());
		odoMtrEndreadings.addAll(ERTSummay_Report.odometr_EndValue());
		ertNamess.addAll(ERTSummay_Report.eRTNames());
		for (i = 0; i < ertNamess.size(); i++) {
			for (j = 0; j < odoMtrStreadings.size(); j++) {
				for (k = 0; k < odoMtrEndreadings.size(); k++) {
					if (i.equals(j) && j.equals(k)
							&& Integer.parseInt(odoMtrStreadings.get(i)) < Integer.parseInt(odoMtrEndreadings.get(j))) {
						log.info(ertNamess.get(i) + " = " + odoMtrStreadings.get(j) + " < " + odoMtrEndreadings.get(k));
					} else if (Integer.parseInt(odoMtrStreadings.get(i)) > Integer.parseInt(odoMtrEndreadings.get(j))) {
						log.info(
								ertNamess.get(i) + " = " + odoMtrStreadings.get(j) + " <> " + odoMtrEndreadings.get(k));
					}

				}

			}
		}
	}

	@Test
	public static void ERT_SUMM_46_Validate_total_Count() throws Exception {

		for (int i = 0; i < branchesVisitedByERTsFromSummary.size(); i++) {
			if (branchesVisitedByERTsFromSummary.get(i).equals("")) {
				branchesVisitedByERTsFromSummary.add("0");
			}
			sum = sum + Integer.parseInt(branchesVisitedByERTsFromSummary.get(i));
		}
		log.info("Total No.of branches Visited By ALl ERTS :" + sum);
	}

	@AfterTest
	public void afterTest() throws ATUTestRecorderException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}
}
