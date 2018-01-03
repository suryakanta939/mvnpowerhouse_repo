package com.powerhouse.testcases;

import org.testng.annotations.Test;

import com.powerhouse.commonLib.ExtentFactory;
import com.powerhouse.pageClasses.Active_camp;
import com.powerhouse.pageClasses.HomePage;
import com.powerhouse.pageClasses.RegistrationWithActivation;
import com.powerhouse.pageClasses.UpgradeGold;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class PowerSiteUpgradeGold {
	WebDriver driver;
	ExtentReports  report;
	ExtentTest test;
	String baseUrl="https://pohostaging.com/";
	HomePage hp;
	UpgradeGold ug;
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
			System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		hp=new HomePage(driver, test);
		  ug=new UpgradeGold(driver, test);
		 driver.get(baseUrl);
		  test.log(LogStatus.INFO, "url is entered");
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	
  
  @Test
  public void f() throws InterruptedException {
	  hp.logInWithGoogle("suryakanta@abacies.com", "9066549823");
	  Thread.sleep(2000);
	  ug.upgradegold();
  }
  

  @AfterClass
  public void afterClass() {
  }

}
