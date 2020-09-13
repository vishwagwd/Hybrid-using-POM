package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parametertest {
	
	WebDriver driver;
	
	@Test()
	@Parameters({"url"})
	
	public void gmaillogintest(String url)
	{
		System.setProperty("webdriver.chrome.driver", "F:\\vishwa\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.className("gb_g")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[3]/a")).click();;
		
		
		
	}
	

}
