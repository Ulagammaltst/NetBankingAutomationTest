package com.netbanking.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.AddingNewCustomerPage;
import com.netbanking.pageobjects.Loginpage;

public class TC_AddCustomer_003 extends Base_class {

	@Test
	public void addnewcustomer() throws InterruptedException
	{
		Loginpage lp=new Loginpage(driver);
		lp.Setusername(username);
		lp.Setpassword(password);
		lp.Login();
		
		Thread.sleep(3000);
		
		AddingNewCustomerPage add=new AddingNewCustomerPage(driver);
		add.addnew();
		add.setname(name);
		logger.info("Customer Name entered");
		
		add.setgender();
		logger.info("Gender entered");
		
		add.setdob(month, date, year);
		logger.info("DOB entered");
		
		add.setaddress(address);
		logger.info("Address entered");
		
		add.setcity(city);
		logger.info("city entered");
		
		add.setstate(state);
		logger.info("State entered");
		
		add.setpinnumber(pin);
		logger.info("Pin entered");
		
		add.setphonenumber(phone);
		logger.info("Phone number entered");
		
		add.setemail(email);
		logger.info("Email entered");
		
		add.setpassword(pwd);
		logger.info("Password entered");
		
		logger.info("All the details entered");
		
		add.submit();
		logger.info("Submitted");
		
		if(isAlertPresent()==true)
			
		{
			
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			getscreenshot(driver,"addnewcustomer");
			logger.info("Customer already exists:Please enter new customer details");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Submission done");
			
		}
	
		
		Thread.sleep(3000);
		
			boolean result=driver.getPageSource().contains("Customer Registered Successfully");
			
			if(result==true)
			{
				Assert.assertTrue(true);
				logger.info("Added new customer successfully");
			}
			else
			{
				
				Assert.assertTrue(false);
				getscreenshot(driver,"addnewcustomer");
				logger.info("Failed adding new customer");
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
	
	//To create random values

	/*public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}*/
	
	/*public String randomnumber()
	{
		String generatedstring=RandomStringUtils.randomnumeric(8);
		return generatedstring;
	}*/
	
	
}
