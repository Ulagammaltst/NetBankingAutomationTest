package com.netbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingNewCustomerPage {

WebDriver ldriver;
	
	public AddingNewCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")	//click link
	WebElement addcustomer;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@name='rad1']")
	WebElement gender;
	
	@FindBy(xpath="//input[@name='dob']")
	WebElement dob;
	
	@FindBy(xpath="//*[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pinnumber;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='sub']")    //clicklink
	WebElement submitbutton;
	
	@FindBy(xpath="//input[@name='res']")    //clicklink
	WebElement resetbutton;
	
	
	//Action methods
	
	public void addnew()
	{
		addcustomer.click();
		/*ldriver.switchTo().alert().dismiss();
		ldriver.switchTo().defaultContent();*/
	}
	
	public void setname(String cname)
	{
		name.sendKeys(cname);
	}
	
	public void setgender()
	{
		gender.click();
	}
	
	public void setdob(String mm,String dd,String yyyy)
	{
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
		
	}
	
	public void setaddress(String caddress)
	{
		address.sendKeys(caddress);
	}
	
	public void setcity(String ccity)
	{
		city.sendKeys(ccity);
	}
	
	public void setstate(String cstate)
	{
		state.sendKeys(cstate);
	}
	
	public void setpinnumber(String cpin)
	{
		pinnumber.sendKeys(String.valueOf(cpin));
	}
	
	public void setphonenumber(String cphone)
	{
		phonenumber.sendKeys(cphone);
	}
	
	public void setemail(String cemail)
	{
		email.sendKeys(cemail);
	}
	
	public void setpassword(String cpwd)
	{
		password.sendKeys(cpwd);
	}
	
	public void submit()
	{
		submitbutton.click();
	}
	
	public void reset()
	{
		resetbutton.click();
	}
}
