package com.ssm.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ssm.Pages.Homepage;
import com.ssm.Pages.Loginpage;
import com.ssm.Testbase.Testbase;
import com.ssm.Testutil.Testutil;

public class Printpopuppagetest extends Testbase
{
	Loginpage loginpage;
	Homepage homepage;
	String sheetname ="";
	
	public Printpopuppagetest() {
		
		super();
	}
	
	@BeforeMethod
	
	public void setup() {
		
		initialization();
		loginpage = new Loginpage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@DataProvider
	
	public Object[][] getmobildata()
	{
		Object data[][]=Testutil.getdata(sheetname);
		return data;
	}
	
	@Test(dataProvider="getmobildata")
	public void logionpagetest(String proj, String job, String task, String time, String diary)
	
	
	{
		
	}

}
