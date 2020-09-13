package com.ssm.Testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ssm.Testutil.Testutil;

public class Testbase {
	
	
	public static WebDriver driver;
	 public static Properties prop;
	 
	 
	
	public Testbase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream( "F:\\vishwa\\SSM\\src\\main\\java\\com\\ssm\\Properties\\Config.Properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "F:\\vishwa\\chromedriver.exe");
			driver = new ChromeDriver();
		
		}else if(browsername.equals("FF")) {
			
			System.setProperty("webdriver.gecko.driver", "F:\\vishwa\\chromedriver.exe");
			driver = new FirefoxDriver();
			
		}
						
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public void failed()
	{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrfile, new File(currentdir+"/screenshots/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
