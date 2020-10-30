package com.ssm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ssm.Testbase.Testbase;
import com.ssm.Testutil.Payment;

public class Paymentspage extends Testbase implements Payment{
	
	@FindBy(name="cmdSearch")
	WebElement tenantsearch;
	
	@FindBy(id="txtTenantName")
	WebElement textbox;
	
	@FindBy(id="usrPaymentModes_chkCash")
	WebElement cash;
	
	@FindBy(id="btnSave")
	WebElement okaybutton;
	
	@FindBy(id="cboPrePayPeriod2410")
	WebElement prepaybutton;
	
	@FindBy(id="cboColumnName")
	WebElement selectsearchcriteria;
	
	public Paymentspage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchunitforpayment(String leaseno)
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("Content");
		System.out.println("switched to frame");
		
		Select lease = new Select(selectsearchcriteria);
		lease.selectByVisibleText("Lease #");
		textbox.sendKeys(leaseno);
		tenantsearch.click();
		
	}

	@Override
	public void cash() {
				
					try{
						
						cash.click();
					
						if(cash.isSelected())
						{
							okaybutton.click();
						}
					else
					{
						Select prepay = new Select(prepaybutton);
						prepay.selectByVisibleText("1");
						cash.click();
						okaybutton.click();
					}
			}catch(Exception e)
					{
						e.printStackTrace();
					}
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void card() {
		// TODO Auto-generated method stub
		
	}
	
	

}
