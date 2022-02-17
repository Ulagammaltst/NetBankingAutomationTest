package com.netbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.netbanking.utilities.ReadConfig;

public class Base_class {

	//Define all the environmental varibles which will be used for the whole project
	
	//Create object for Read Config class
	ReadConfig readconfig=new ReadConfig();
	
	public String applicationURL=readconfig.getURL();
	public String username=readconfig.getusername();
	public String password=readconfig.getpasscode();
	
	public String name=readconfig.getname();
	public String month=readconfig.getmonth();
	public String date=readconfig.getdate();
	public String year=readconfig.getyear();
	public String address=readconfig.getaddress();
	public String city=readconfig.getcity();
	public String state=readconfig.getstate();
	public String pin=readconfig.getpin();
	public String phone=readconfig.getphone();
	public String email=readconfig.getemail();
	public String pwd=readconfig.getpassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")   //This fetches the browser type from xml
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("NetBankingAutomationTest");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver",readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		driver.get(applicationURL);
		logger.info("URL is opened");
		
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void getscreenshot(WebDriver driver,String name)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		 File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     try {
			FileUtils.copyFile(f, new File("C:\\Users\\Sethu\\eclipse-workspace\\NetBankingAutomationTest\\Screenshots\\"+name+"."+timestamp+".png"));
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception found");
		}
	}
	
	
}
