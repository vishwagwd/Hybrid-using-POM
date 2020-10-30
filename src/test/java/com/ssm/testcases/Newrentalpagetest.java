package com.ssm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ssm.Pages.Homepage;
import com.ssm.Pages.Loginpage;
import com.ssm.Pages.Newrentalpage;
import com.ssm.Testbase.Testbase;

public class Newrentalpagetest extends Testbase {
	
	Loginpage logpage;
	Homepage homepage;
	Newrentalpage newrentalpage;
	
	public Newrentalpagetest()
	{
		super();
	}
	
	@BeforeMethod
	
	public void setup()
	{
		initialization();
		
		logpage=new Loginpage();
		logpage.login();
		homepage=new Homepage();
		newrentalpage= new Newrentalpage();
	}
	
	@Test
	public void moveintest() throws Throwable
	{
		homepage.newrentalsclick();
		newrentalpage.movein(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("accesscode"), "NOV", "2020" );
	}
	
	@AfterMethod
	
	public void teardown()
	{
		
	}
	

}
