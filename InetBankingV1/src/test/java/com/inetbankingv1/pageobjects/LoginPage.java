package com.inetbankingv1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtusername1;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a")
	@CacheLookup
	WebElement btnlogout;
	
	
	public void setusername(String username) {
		txtusername1.sendKeys(username);
	}
	
	public void enterpassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void clickandsubmit() {
		btnlogin.click();
	}
	
	public void logout() {
		btnlogout.click();
	}
}
