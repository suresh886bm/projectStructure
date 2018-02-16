package com.Cogniphy.Protection.Muthoot.TestSuites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.LogIn;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Administration_Suite extends BaseClass{
	
	@BeforeClass
	public void beforClass() throws ATUTestRecorderException {
		LogIn.chrome_LogIn();
		
	}
  @Test
  public void f() {
  }
}
