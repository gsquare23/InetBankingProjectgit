package com.inetbankingv1.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbankingv1.pageobjects.LoginPage;
import com.inetbankingv1.utility.Log;


public class TC_LoginTest_002 extends BaseClass {
	

	@Test(dataProvider="Credentials1")
	public void loginDDT(String user, String pass){
		LoginPage lp = new LoginPage(driver);
		lp.setusername(user);
		Log.info("user name provided");
		lp.enterpassword(pass);
		Log.info("pass word provided");
		lp.clickandsubmit();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Log.warn("LoginFailed");
		}
		else {
			Assert.assertTrue(true);
			Log.info("Login successfull");
			lp.logout();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	
	
	@DataProvider(name ="Credentials1")
	public Object[][] excelData() {
		
		//total rows count
		int rows = obj.getRowCount("Test");
		//total Column count 
		int col = obj.getColumnCount("Test");
		  int actRows=rows-1;
		Object [][] data = new Object[actRows][col];
		
		for(int i=0;i<actRows;i++) {
			for(int j=0;j<col;j++) {
				data[i][j] = obj.getCellData("Test", j, i+2);
				
			}
		}
		
		return data;
		}

}
