package com.ssm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ssm.Testbase.Testbase;


public class Homepage extends Testbase
{
	@FindBy(id="PanelModal")
	WebElement close;
	
	@FindBy(id="TabControl1_t2_")
	WebElement rent;
	
	@FindBy(id="TabControl1_t4_")
	WebElement payment;
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
			
	}
	
	
	public Newrentalpage newrentalsclick()
		{
		
		driver.switchTo().frame("MainTabs");
		System.out.println("Switched to frame");
		rent.click();
		
		return new Newrentalpage();
	}
	
	
	public Paymentspage paymentpageclick()
	{
		driver.switchTo().frame("MainTabs");
		System.out.println("Switched to frame");
		payment.click();
		
		return new Paymentspage();
	}
	

}
