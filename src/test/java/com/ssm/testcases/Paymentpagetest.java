package com.ssm.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ssm.Pages.Homepage;
import com.ssm.Pages.Loginpage;
import com.ssm.Pages.Paymentspage;
import com.ssm.Testbase.Testbase;

public class Paymentpagetest extends Testbase{
	
	public Loginpage loginpage;
	public Homepage homepage;
	public Paymentspage paymentspage;
	
	public Paymentpagetest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()	
	{
		initialization();
		loginpage = new Loginpage();
		loginpage.login();
		
		homepage = new Homepage();
		homepage.paymentpageclick();
		
		paymentspage = new Paymentspage();
	}
	
	@Test
	public void cashpaymenttest()
	{
		paymentspage.searchunitforpayment("2410");
		paymentspage.cash();
	}
}
