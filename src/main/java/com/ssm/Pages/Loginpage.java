package com.ssm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ssm.Testbase.Testbase;

public class Loginpage extends Testbase

{
	
		
	@FindBy(name = "txtUserId")
	WebElement username;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(id = "btnOk")
	WebElement submit;
	
	/*@FindBy(name = "CboFacilities")
	WebElement fac;*/
	
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateloginpage()
	{
		return driver.getTitle();
	}
	
	
	/*public void selectfacility(String facility)
	{
		Select facy = new Select(fac);
		facy.selectByVisibleText(facility);;
	}*/
	
	public Homepage login()
	{
		String usercredential = getcredentials().get(1);
		String [] splittedcredentials = usercredential.split(":");
		
		username.sendKeys(splittedcredentials[0]);
		password.sendKeys(splittedcredentials[1]);
		
		submit.click();
		
		return new Homepage();
	}
}
