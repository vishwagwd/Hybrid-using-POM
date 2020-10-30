package com.ssm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ssm.Pages.Homepage;
import com.ssm.Pages.Loginpage;
import com.ssm.Testbase.Testbase;

public class Homepagetest extends Testbase
{
	
	Loginpage loginpage;
	Homepage homepage;
	
	public Homepagetest()
	{
		super();
	}
		
	@BeforeMethod
	
	public void setup()
	
	{
		initialization();
		
		loginpage = new Loginpage();
		//loginpage.selectfacility(prop.getProperty("facility"));
		loginpage.login();
		homepage = new Homepage();
		
	}
	
	
	@Test
	
	public void newrentalspageclicktest()
	{
		homepage.newrentalsclick();
	}
	
	
	
	
	@AfterMethod
	
	public void teardown()
	{
		
	}
}
