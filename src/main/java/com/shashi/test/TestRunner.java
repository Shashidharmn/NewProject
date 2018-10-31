package com.shashi.test;

import java.io.File;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shashi.data.ReadData;
import com.shashi.implementation.LoginPageImpl;

public class TestRunner {
	public WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeTest
	
	public void beforeTest()
	{
		
		report = new ExtentReports("C:\\Users\\Shashi\\Desktop\\Report.html");
		report.loadConfig(new File("C:\\Users\\Shashi\\Desktop\\New folder\\Framework\\Config.xml"));
	test = report.startTest("ExtentDemo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shashi\\Desktop\\Jars\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://facebook.com");
	}
	
	
	@Test(dataProviderClass = com.shashi.data.ReadData.class, dataProvider = "data")
	public void browser(Object ...data) throws InterruptedException
	{
		LoginPageImpl login =new LoginPageImpl();
		
		login.LoginPage(driver, data);
		
		
		
		
				
	}
	
	
	@AfterTest
	public void afterTest()
	{
		report.endTest(test);
		report.flush();
		driver.close();
	}

}
