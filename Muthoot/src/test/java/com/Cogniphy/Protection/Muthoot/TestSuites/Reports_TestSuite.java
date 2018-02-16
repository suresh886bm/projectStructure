package com.Cogniphy.Protection.Muthoot.TestSuites;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Reports.ERTDaily_Report;
import com.Cogniphy.Protection.Muthoot.Reports.ERTSummay_Report;
import com.Cogniphy.Protection.Muthoot.Reports.RCR_Reports;
import com.Cogniphy.Protection.Muthoot.SLA.Incident_Room;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.LogIn;
import com.Cogniphy.Protection.Muthoot.Utility.Utility;

public class Reports_TestSuite extends BaseClass {
	private static final Logger log = Logger.getLogger(Reports_TestSuite.class.getName());
	static Integer i, j, k;
	static String noFromDaily = new String();
	static String noFromSumm = new String();
	static List<String> DailyrepoTimes = new ArrayList<String>();
	static List<String> summRepoTimes = new ArrayList<String>();
	static List<String> inciRoomBranches = new ArrayList<String>();
	static List<String> summRoomBranches = new ArrayList<String>();
	static List<String> summActualADTTimes = new ArrayList<String>();
	static List<String> aDTRecivedTimes = new ArrayList<String>();
	static List<String> incActualADTtimes = new ArrayList<String>();
	static List<String> odoMtrStreadings = new ArrayList<String>();
	static List<String> odoMtrEndreadings = new ArrayList<String>();
	static List<String> ertNamess = new ArrayList<String>();

	@Test(priority =1)
	public void Login() throws Exception {

		LogIn.chrome_LogIn();

		
		/*ERTDaily_Report.navigate_To_Reports();
		ERTDaily_Report.fetch_Daily_report();
		noFromDaily = ERTDaily_Report.noOf_Branches_visitedBy("KL/KCH/01");
		DailyrepoTimes.addAll(ERTDaily_Report.reportAt_Time());

		ERTSummay_Report.navigate_to_ERTSummary_Report();
		ERTSummay_Report.fetchSummuryRepot();
		noFromSumm = ERTSummay_Report.noOf_Branches_vistedBy("KL/KCH/01");
		summRepoTimes.addAll(ERTSummay_Report.fetch_ertReport_Time());
		summRoomBranches.addAll(ERTSummay_Report.summBranch_Names());
		summActualADTTimes.addAll(ERTSummay_Report.actualADTtimings());
		aDTRecivedTimes.addAll(ERTSummay_Report.aDTRecivedtimings());
		odoMtrStreadings.addAll(ERTSummay_Report.odometr_StartValue());
		odoMtrEndreadings.addAll(ERTSummay_Report.odometr_EndValue());
		ertNamess.addAll(ERTSummay_Report.eRTNames());
		
	    Incident_Room.navigate_to_Incident_room();
		inciRoomBranches.addAll(Incident_Room.incident_BranchNames());
		incActualADTtimes.addAll(Incident_Room.incident_ActualDATtimes());
		*/

	}

	@Test(priority =2, enabled = false)
	public void Validate_ERTReported_At_Time_with_Daily_Report() throws Exception {

		for (int i = 0; i < DailyrepoTimes.size(); i++) {
			for (int j = 0; j < summRepoTimes.size(); j++) {

				if (DailyrepoTimes.get(i).equals(summRepoTimes.get(j))) {
					log.info("ReportAt times are :" + DailyrepoTimes.get(i) + "=" + summRepoTimes.get(j));
				}

			}
		}

	}

	@Test(priority =3, enabled = false)
	public void Validate_No_of_Branches_Visted() throws Exception {

		if (noFromDaily.equals(noFromSumm)) {
			log.info("noOf Branches from Daily:" + noFromDaily + "=" + noFromSumm);
		}
	}

	@Test(priority =4, enabled = false)
	public void IncidentRoom_BranchNames_Validation() throws Exception {
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

	@Test(priority =5, enabled = false)
	public void ADT_AlarmTime_Vrfction_BN_Summ_ND_IncRoom() {
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

	@Test(priority =6, enabled = false)
	public void ADT_RecievedTime_Verification() {
		for (int i = 0; i < aDTRecivedTimes.size(); i++) {
			Utility utility = new Utility();
			boolean text = utility.validate(aDTRecivedTimes.get(i));
			log.info("Timeformat of ADT Recived :" + aDTRecivedTimes.get(i) + "=" + text);
		}

	}

	@Test(priority =7, enabled = false)
	public void odoMeter_Reading_Valiadtion() {
		for (i = 0; i < ertNamess.size(); i++) {
			for (j = 0; j < odoMtrStreadings.size(); j++) {
				for (k = 0; k < odoMtrEndreadings.size(); k++) {
					if (i.equals(j) && j.equals(k)
							&& Integer.parseInt(odoMtrStreadings.get(i)) < Integer.parseInt(odoMtrEndreadings.get(j))) {
						log.info(ertNamess.get(i) + " = " + odoMtrStreadings.get(j) + " < " + odoMtrEndreadings.get(k));
					}

				}

			}
		}

	}
	@Test(priority =8)
	public void attendanceValidationForeachERT() throws Exception {
		ERTDaily_Report.navigate_To_Reports();
		RCR_Reports.navigateToRcR_Report();
		RCR_Reports.openGaurdAttendanceReport();
		Utility.selecteDateFor_GaurdAttendance();
	}
}
