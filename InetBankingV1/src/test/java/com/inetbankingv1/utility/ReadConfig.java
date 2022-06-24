package com.inetbankingv1.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig() {
		File src =new File("C:\\Users\\garvit.c.gupta\\eclipse-Selenium\\InetBankingV1\\Configuration\\config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	
	} catch (FileNotFoundException e) {
		System.out.println("Exception is " + e.getMessage());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public String getApplicationUrl() {
		String url = pro.getProperty("baseurl");
		return url;
		
	}
	
	public String getUsername() {
		String username = pro.getProperty("uname");
		return username;
		
	}
	
	public String getPassword() {
		String Password = pro.getProperty("pword");
		return Password;
		
	}
	
	
	
}
