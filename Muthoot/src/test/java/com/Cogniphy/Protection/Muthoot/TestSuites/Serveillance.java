package com.Cogniphy.Protection.Muthoot.TestSuites;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Utility.LogIn;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Serveillance {
	@BeforeClass
	public void beforeClass() throws Exception {
		LogIn.chrome_LogIn();
		
	}
  @Test
  public void f() {
  }
}
