package com.ssm.Pages;


import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ssm.Testbase.Testbase;

public class Newrentalpage extends Testbase{
	
		
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	
	@FindBy(id="chkSelectUnitTypes")
	WebElement unittypecheckbox;
	
	@FindBy(id="BtnSearch")
	WebElement search;
	
	@FindBy(xpath = "//*[contains(@id,'tblAvailUnitsInfo')]//child::tr")
	WebElement selectunit;
	
	@FindBy(id = "btnMovein")
	WebElement moveinbutton;
	
	@FindBy(id = "txtTntFirstName")
	WebElement firstname;
	
	@FindBy(id = "txtTntLastName")
	WebElement lastname;
	
	@FindBy(id = "txtTntAccessCode")
	WebElement accesscode;
	
	@FindBy(id="btnTntNext")
	WebElement nextbutton;
	
	@FindBy(xpath="//*[contains(@id,'btnNext_TI')]")
	WebElement nextbutton1;
	
	@FindBy(xpath="//*[contains(@id,'btnNext_CI')]")
	WebElement nextbutton2;
	
	@FindBy(id="chkOptions21")
	WebElement marketing1;
	
	@FindBy(id="chkOptions22")
	WebElement marketing2;
	
	
	@FindBy(id="chkOptions23")
	WebElement marketing3;
	
	@FindBy(id="chkOptions13")
	WebElement marketing4;
	
	@FindBy(id="chkOptions39604")
	WebElement marketing5;
	
	@FindBy(id="chkOptions116004")
	WebElement marketing6;
	
	@FindBy(id="chkOptions116006")
	WebElement marketing7;
	
	@FindBy(id="btnNext_MKT")
	WebElement marketingnext;
	
	@FindBy(id="chkTenantInfoSheet")
	WebElement tntinfosheetbox;
	
	@FindBy(id="chkPreviewAddendums")
	WebElement previewtntinfo;
	
	@FindBy(id="btnAddendums")
	WebElement okaybutton;
	
	@FindBy(id="btnPayment_Addendums")
	WebElement paymentbutton;
	
	@FindBy(id="usrPaymentModes_chkCash")
	WebElement checkcashmode;
	
	@FindBy(id="chkPreview")
	WebElement preview;
	
	@FindBy(id="btnFinish")
	WebElement finish;
	
	@FindBy(id="btnAltNew")
	WebElement newalternatecontactbutton;
	
	@FindBy(id="imgMoveindate")
	WebElement datepicker;
	
	@FindBy(xpath="//*[@id='outerTable']")
	WebElement table;
	
	@FindBy(xpath="//*[@id='MonSelect' and @class='CalTitle']")
	WebElement monthselect;
	
	@FindBy(id="YearSelect")
	WebElement yearselect;
	
	@FindBy(xpath="//*[@class='CellAnchor' and contains(text(),'17')]")
	WebElement dateingrid;
	
	
	public Newrentalpage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void movein(String fn, String ln, String accscode, String monthnumber, String year) throws Throwable
	
	{
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		/*driver.switchTo().frame("MainTabs");
		System.out.println("switched to container frame");
		Thread.sleep(2000);*/
		driver.switchTo().frame("Content");
		System.out.println("switched to frame 4");
		
		unittypecheckbox.click();
		search.click();
		selectunit.click();
		/*datepicker.click();
		Thread.sleep(2000);
		
		Select month = new Select(monthselect);
		month.selectByVisibleText(monthnumber);
				
		Select yearname = new Select(yearselect);
		yearname.selectByValue(year);
		
		dateingrid.click();*/
		
		
		
		
		moveinbutton.click();
		
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		accesscode.sendKeys(accscode);
		nextbutton.click();

		nextbutton1.click();  		//tenantinfo page
		
		/*newalternatecontactbutton.click();
		driver.findElement(By.id("Panel9"));
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println("switched to alert");*/
		
		
		nextbutton2.click();		//Alternate contactpage page
		
		//Marketing page.
		
		/*marketing1.click();
		marketing2.click();
		marketing3.click();
		marketing4.click();
		marketing5.click();
		marketing6.click();
		marketing7.click();
		
		marketingnext.click();*/
		
		//tenantaddendumpage
		
		tntinfosheetbox.click();
		previewtntinfo.click();
		okaybutton.click();
				
		wait.until(ExpectedConditions.elementToBeClickable(paymentbutton));
		
		paymentbutton.click();
		
		System.out.println(driver.getTitle());
		wait.until(ExpectedConditions.elementToBeClickable(checkcashmode));
		
		checkcashmode.click();
		preview.click();
		finish.click();
		
		Thread.sleep(3000);
			
		String parent = driver.getWindowHandle();
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it =handler.iterator();
		
		while(it.hasNext())
		{
			String childwindow=it.next();
			
			if(!parent.equals(childwindow))
			{
				driver.switchTo().window(childwindow);
				System.out.println("confirmation of payment receipt " + driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		
	}
	
	
	
	
	
	
	
	
	

}
