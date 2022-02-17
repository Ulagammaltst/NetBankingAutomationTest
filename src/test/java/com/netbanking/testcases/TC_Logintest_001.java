package com.netbanking.testcases;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.Loginpage;

public class TC_Logintest_001 extends Base_class {

	@Test
	public void Logintest()
	{
		Base_class bc=new Base_class();
		
		
		Loginpage lp=new Loginpage(driver);
		lp.Setusername(username);
		logger.info("Entered username");
		lp.Setpassword(password);
		//bc.getscreenshot(driver,"Screenshot-EnterdLogin");
		logger.info("Entered Passcode");
		lp.Login();
		//bc.getscreenshot(driver,"Screenshot-ClickedLogin");
		logger.info("Login done");
		
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("Guru99 Bank Manager HomePage"))
		{
		Assert.assertTrue(true);
		logger.info("Login Test passed ");
		}
		else
		{
			getscreenshot(driver,"Logintest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed ");
		}
	
	
	}
}
