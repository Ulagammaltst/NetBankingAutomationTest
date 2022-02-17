package com.netbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop=new Properties();
	
	public ReadConfig() 
	{
		try 
		{
			FileInputStream ip=new FileInputStream("C:\\Users\\Sethu\\eclipse-workspace\\NetBankingAutomationTest\\configuration\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is found");
		}
	}
	
	public String getURL()
	{
		String URL=prop.getProperty("baseURL");
		return URL;
		
	}
	
	public String getusername()
	{
		String username=prop.getProperty("username");
		return username;
		
	}
	
	public String getpasscode()
	{
		String passcode=prop.getProperty("passcode");
		return passcode;
		
	}
	
	public String getChromepath()
	{
		String chrome=prop.getProperty("chromepath");
		return chrome;
		
	}
	
	public String getFirefoxpath()
	{
		String firefox=prop.getProperty("firefoxpath");
		return firefox;
		
	}
	
	//Reading test case_003
	
	public String getname()
	{
		String name=prop.getProperty("name");
		return name;
		
	}
	
	public String getmonth()
	{
		String month=prop.getProperty("month");
		return month;
		
	}
	
	public String getdate()
	{
		String date=prop.getProperty("date");
		return date;
		
	}
	
	public String getyear()
	{
		String year=prop.getProperty("year");
		return year;
		
	}
	
	public String getaddress()
	{
		String address=prop.getProperty("address");
		return address;
		
	}
	
	public String getcity()
	{
		String city=prop.getProperty("city");
		return city;
		
	}
	
	public String getstate()
	{
		String state=prop.getProperty("state");
		return state;
		
	}
	
	public String getpin()
	{
		String pin=prop.getProperty("pin");
		return pin;
		
	}
	
	public String getphone()
	{
		String phone=prop.getProperty("mobile");
		return phone;
		
	}
	
	public String getemail()
	{
		String email=prop.getProperty("email");
		return email;
		
	}
	
	public String getpassword()
	{
		String password=prop.getProperty("password");
		return password;
		
	}
	
	
	
}
