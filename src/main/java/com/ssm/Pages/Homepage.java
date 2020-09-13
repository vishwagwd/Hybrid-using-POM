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
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
			
	}
	
	
	public Newrentalpage newrentalsclick()
		{
		
		driver.switchTo().frame("close");
		driver.switchTo().alert().dismiss();
		rent.click();
		
		return new Newrentalpage();
	}
	
	

}
