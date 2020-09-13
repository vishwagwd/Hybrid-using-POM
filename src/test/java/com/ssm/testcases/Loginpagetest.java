package com.ssm.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.ssm.Pages.Homepage;
import com.ssm.Pages.Loginpage;
import com.ssm.Testbase.Testbase;
import com.ssm.Testutil.CustomListener;


@Listeners(CustomListener.class)
public class Loginpagetest extends Testbase
{
	
	SoftAssert softassert = new SoftAssert();
	Loginpage loginpage;
	Homepage  homepage;
	
	public Loginpagetest()
	{
		super();
	}
	
	@BeforeMethod
	
	public void setup()
	{
		initialization();
		
		loginpage = new Loginpage();
	}
	
	
	
	@Test(priority=1, invocationCount=1)
	
	public void validateloginpagetest()
	{
		String title = loginpage.validateloginpage();
		Assert.assertEquals(title, "Log In2");
		
	}
	
	
	@Test(priority=2)
	
	public void loginpagetest()
	{
		loginpage.selectfacility(prop.getProperty("facility"));
		loginpage.login(prop.getProperty("un"), prop.getProperty("pwd"));
		
				
	}
	
	
	
	@AfterMethod
	
	public void teardown()
	{
		
	}
}
