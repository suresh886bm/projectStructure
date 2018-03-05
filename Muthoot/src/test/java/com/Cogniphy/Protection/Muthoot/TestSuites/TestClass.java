package com.Cogniphy.Protection.Muthoot.TestSuites;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Reports.ERTSummay_Report;

public class TestClass {
	static int sum = 0;
  @Test
  public void TC_001() {
	 
	  List<Integer> list = new ArrayList<Integer>();
	  
	  list.add(3);
	  list.add(5);
	  System.out.println(list);
	  for (int i = 0; i < list.size(); i++) {
		sum = sum + list.get(i);
	}
	  System.out.println(sum);
  }
}
