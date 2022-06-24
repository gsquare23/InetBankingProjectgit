package com.inetbankingv1.extentreport;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbankingv1.testcases.BaseClass;

public class ExtentManager {
	public static WebDriver driver;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public static void ExtentSetup() {
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")
				+ "\\test-output\\ExtentReports\\MyReports_" + BaseClass.getCurrentTime() + ".html");
		// htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent.config.xml");
		
		  htmlReporter.config().setDocumentTitle("Inet Banking Project");
		  htmlReporter.config().setReportName("Banking Test Report");
		  htmlReporter.config().setTheme(Theme.DARK);
		 

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "My host");
		extent.setSystemInfo("Project Name", "InetBanking");
		extent.setSystemInfo("Tester", "Garvit");
		extent.setSystemInfo("OS", "win10");
		extent.setSystemInfo("Browser", "Chrome");

	}
	
	public static void endReport() {
		extent.flush();
	}
}
