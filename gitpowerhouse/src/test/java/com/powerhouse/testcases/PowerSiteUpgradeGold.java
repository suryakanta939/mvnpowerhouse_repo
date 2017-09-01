package com.powerhouse.testcases;

import org.testng.annotations.Test;

import com.powerhouse.commonLib.ExtentFactory;
import com.powerhouse.pageClasses.HomePage;
import com.powerhouse.pageClasses.RegistrationWithActivation;
import com.powerhouse.pageClasses.UpgradeGold;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class PowerSiteUpgradeGold {
	WebDriver driver;
	ExtentReports  report;
	ExtentTest test;
	String baseUrl="https://pohostaging.com/";
	HomePage hp;
	UpgradeGold ug;
	@BeforeClass
	  public void beforeClass() {
		report=ExtentFactory.getInstancce();
		  test=report.startTest("PowerSiteUpgradeGold");
		  driver=new FirefoxDriver();
		  test.log(LogStatus.INFO, "browser opened");
		 driver.get(baseUrl);
		  test.log(LogStatus.INFO, "url is entered");
		  hp=new HomePage(driver, test);
		  ug=new UpgradeGold(driver, test);
		  driver.manage().window().maximize();
	  }
	
//  @BeforeMethod
//  public void beforeMethod() {
//  }
  
  @Test
  public void f() throws InterruptedException {
	  hp.loginToPowerHouse("arya1", "reset123");
	  ug.upgradegold();
  }
  
  
//  @AfterMethod
//  public void afterMethod() {
//  }

  @AfterClass
  public void afterClass() {
  }

}
