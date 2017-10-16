package com.powerhouse.testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.powerhouse.commonLib.ExtentFactory;
import com.powerhouse.pageClasses.Active_camp;
import com.powerhouse.pageClasses.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ActiveCampaignPurchase {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String url="https://pohostaging.com";
	HomePage hp;
	Active_camp ac;
	
	@Parameters({"browser"})
	@BeforeClass(alwaysRun = true)
	public void setUp(String browser){
		File f=new File("Drivers");
		File fs=new File(f,"chromedriver.exe");
		System.out.println(fs.getAbsolutePath());
		report=ExtentFactory.getInstancce();
		test=report.startTest("active campaign purchage");
		if(browser.equals("firefox")){
			driver=new FirefoxDriver();
			
		}else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", fs.getAbsolutePath());
			driver=new ChromeDriver();
		}
		hp=new HomePage(driver, test);
		ac=new Active_camp(driver, test);
		driver.get(url);
		test.log(LogStatus.INFO, "url is entered");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
  @Test
  public void f() throws InterruptedException 
  {
	  hp.loginWithFaceBook("surya.east09@gmail.com", "suryakanta939");
	  Thread.sleep(3000);
	  ac.purchaseActiveCampaign();
  }
}
