package com.powerhouse.testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.powerhouse.commonLib.ExplictyWait;
import com.powerhouse.commonLib.ExtentFactory;
import com.powerhouse.commonLib.InvokeBrowser;
import com.powerhouse.pageClasses.HomePage;
import com.powerhouse.pageClasses.LogInCheck;
import com.powerhouse.pageClasses.UpgradeGold;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginWithDifferentOption {
	static WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	HomePage hp;
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
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
			driver=new ChromeDriver();
		
			
		}
		hp=new HomePage(driver, test);
	 driver.get("https://app.pohostaging.com/");
	 driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
//	@BeforeMethod
//	public void executeBeforeMethod(){
//		
//	}
  @Test(enabled=false)
  public void google() throws InterruptedException {
	 hp.logInWithGoogle("suryakanta@abacies.com", "jfjdjero");
	 ExplictyWait.waitForTheVisiilty(driver, 15, hp.logOut());
	
  }
  @Test
  public void faceBook(){
	  hp.loginWithFaceBook("surya.east09@gmail.com", "krlenels");
	  ExplictyWait.waitForTheVisiilty(driver, 15, hp.logOut());
  }
  @AfterMethod
  public void executeAfterMethod(){
	  hp.logOutFromPowerHouse();
	  driver.navigate().to("https://pohostaging.com/login/");
  }
  
}
