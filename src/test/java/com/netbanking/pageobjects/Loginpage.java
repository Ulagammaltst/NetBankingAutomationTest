package com.netbanking.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	
	//1.Initiate the driver
	
	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//2.Locate all the required webelements available in the web page
	
		@FindBy(name="uid")
		WebElement userid;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(name="btnLogin")
		WebElement loginbutton;
		
		@FindBy(name="btnReset")
		WebElement resetbutton;
		
		@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
		WebElement logoutbutton;
		
	/*WebElement userid=ldriver.findElement(By.name("uid"));
	WebElement password=ldriver.findElement(By.name("password"));
	WebElement loginbutton=ldriver.findElement(By.name("btnLogin"));
	WebElement resetbutton=ldriver.findElement(By.name("btnReset"));*/
	
	//3.Create actions or methods for each web element located
	
	public void Setusername(String user)
	{
		userid.sendKeys(user);
	}
	
	public void Setpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void Login()
	{
		loginbutton.click();
	}
	
	public void Reset()
	{
		resetbutton.click();
	}
	
	public void Logout()
	{
		logoutbutton.click();
	}
	
}
