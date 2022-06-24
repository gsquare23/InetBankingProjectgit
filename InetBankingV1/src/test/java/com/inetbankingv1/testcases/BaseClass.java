package com.inetbankingv1.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.inetbankingv1.extentreport.ExtentManager;
import com.inetbankingv1.utility.Log;
import com.inetbankingv1.utility.NewExcelLibrary;
import com.inetbankingv1.utility.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig rc = new ReadConfig();
	
	public String baseurl= rc.getApplicationUrl();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	NewExcelLibrary obj = new NewExcelLibrary();
	
	@BeforeSuite
	public void beforesuite() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		Log.info("This is BeforeSuite Method");
		ExtentManager.ExtentSetup();
		
	}
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)  {
		
		if(br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		if(br.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if(br.equals("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(baseurl);
	}
	
	
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	@AfterSuite
	public void aftersuite() {
	
		Log.info("This is afterSuite Method");
		ExtentManager.endReport();
	}
	
	
	public static String screenShot(WebDriver driver,String filename) {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		  File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		  String destination = "C:\\Users\\garvit.c.gupta\\eclipse-Selenium\\InetBankingV1\\ScreenShot\\"+filename+"_"+dateName+".png";
		  File finalDestination= new File(destination);
		  try {
		   FileUtils.copyFile(source, finalDestination);
		   System.out.println("Screenshot Taken");
		  } catch (Exception e) {
		   e.getMessage();
		  }
		  return destination;
		 }
	
	 
	 public static String getCurrentTime() {  
	     String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());  
	     return currentDate;  
	 } 
}
