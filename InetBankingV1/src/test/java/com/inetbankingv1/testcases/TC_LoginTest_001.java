package com.inetbankingv1.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbankingv1.pageobjects.LoginPage;
import com.inetbankingv1.utility.Log;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void logintest() {
		Log.startTestCase("SeleNIUM FRAMEWORK STARTED");
		Log.info("Entering URL");
		driver.get(baseurl);
		LoginPage lp = new  LoginPage(driver);
		Log.info("Entering username");
		lp.setusername(username);
		Log.info("Entering password");
		lp.enterpassword(password);
		Log.info("Clickoing on Login button");
		lp.clickandsubmit();
		Log.info("Title MAtching started");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Log.info("Title MAtched");
		}
		else 
		{
			screenShot(driver,"logintest");
			Assert.assertTrue(false);
			Log.info("Title MAtched");
		}
		Log.startTestCase("SeleNIUM FRAMEWORK ENDED");
	}
	
	
	@Test
	public void testcase2() {
		System.out.println("suhgsdgdsgjgsdjsdg");
	}

}
