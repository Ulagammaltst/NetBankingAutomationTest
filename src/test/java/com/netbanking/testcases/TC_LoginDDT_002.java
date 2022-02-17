package com.netbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.Loginpage;
import com.netbanking.utilities.ExcelUtils;



public class TC_LoginDDT_002 extends Base_class{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		Loginpage lp=new Loginpage(driver);
		lp.Setusername(user);
		logger.info("Username provided");
		lp.Setpassword(pwd);
		logger.info("Password provided");
		lp.Login();
		
		if(isAlertPresent()==true)
		
		{
			
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			getscreenshot(driver,"loginDDT");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.Logout();
			logger.info("Login passed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
		{
		String path="C:\\Users\\Sethu\\eclipse-workspace\\NetBankingAutomationTest\\src\\test\\java\\com\\netbanking\\testdata\\workBook1.xlsx";
		ExcelUtils xlutils=new ExcelUtils();				//creat object for the utilities file
		int colcount;
		int rowcount;
			
		rowcount = ExcelUtils.getrowcount(path,"Sheet1");						//get the row count
		
		colcount = ExcelUtils.getcellcount(path,"Sheet1",1);					//get the col count
		
		String loginData[][]=new String[rowcount][colcount];			//Create an array to get the data
		
		for(int i=1;i<=rowcount;i++)										//start from 1,because we dont want the title
		{
			for(int j=0;j<colcount;j++)										//start from 0,because col index is 0,1,2
			{
				loginData[i-1][j]=ExcelUtils.getcelldata(path,"Sheet1",i,j);		//in array 0 index should be included
			}
		}
		return loginData;
		
		}
}
