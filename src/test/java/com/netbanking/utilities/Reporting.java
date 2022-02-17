package com.netbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public WebDriver driver;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports reports;
	public ExtentTest test;

//Listener class
	
	public void onStart(ITestContext testcontext)
	{
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String repname="Test-Report."+timestamp+".html";		
		try {
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repname);
		htmlreporter.loadXMLConfig(System.getProperty("C:\\Users\\Sethu\\eclipse-workspace\\NetBankingAutomationTest\\extent-config.xml"));
		}
		catch(Exception e)
		{
			System.out.println("Filenot found");
		}
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("Functional Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		reports.setSystemInfo("Hostname","LocalHost");
		reports.setSystemInfo("os","Windows8");
		reports.setSystemInfo("Tester Name","Ulagammal");
		reports.setSystemInfo("Browser","Chrome");
		
		 
			
	}
	
	
	public void onFinish(ITestContext testcontext)
	{
		
		reports.flush();
	}
	
	
	
	
	
	public void onTestFailure(ITestResult result) 
	{
			test=reports.createTest(result.getName());
			test.log(Status.FAIL,"TEST CASE FAILED IS" + result.getName());//to add the failed test case name in the extent report
			test.log(Status.FAIL,"TEST CASE FAILED IS" + result.getThrowable());//to add exception
			
			String screenshotpath=System.getProperty("user.dir")+"Screenshots\\"+result.getName()+".png";
			
				File f=new File(screenshotpath);
				if(f.exists())
				{
					try {
						test.fail("Screenshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
						
		}
		
	public void onTestSkipped(ITestResult result)
	{
		test=reports.createTest(result.getName()); 
		test.log(Status.SKIP,"TEST CASE SKIPPED IS" + result.getName());
		
	}
		
	public void onTestSuccess(ITestResult result)
	{
		test=reports.createTest(result.getName()); 
		test.log(Status.PASS,"TEST CASE PASSED IS" + result.getName());
	}
		
			
			
	

		
		
	}
	



