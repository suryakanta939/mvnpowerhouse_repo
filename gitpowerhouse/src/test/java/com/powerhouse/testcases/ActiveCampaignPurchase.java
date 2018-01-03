package com.powerhouse.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.powerhouse.commonLib.ExplictyWait;
import com.powerhouse.commonLib.ExtentFactory;
import com.powerhouse.pageClasses.Active_camp;
import com.powerhouse.pageClasses.HomePage;
import com.powerhouse.pageClasses.PowersiteSubscription;
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
	PowersiteSubscription ps;
	
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
		ac=new Active_camp(driver, test);
		ps=new PowersiteSubscription(driver, test);
		driver.get(url);
		test.log(LogStatus.INFO, "url is entered");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
  @Test
  public void f() throws InterruptedException 
  {
	 hp.loginWithFaceBook("surya.east09@gmail.com", "suryakanta939");
	 // hp.logInWithGoogle("ashwini@abacies.com", "32353");
	  Thread.sleep(3000);
	  ac.adminDashboard().click();
	  test.log(LogStatus.INFO,"cleciked on the dashboard");
	  if(driver.findElements(By.xpath("//p[contains(text(),'you are not allowed')]")).size()==1){
		   driver.navigate().back();
		   Thread.sleep(2000);
		   ExplictyWait.waitForTheVisiilty(driver, 10, ps.marketplace());
		   ps.purchaseBronze();
		   if(ps.checkStatus()==true){
			   ac.purchaseActiveCampaign();
			Assert.assertEquals(ps.checkStatus(),"true", "the status of the purchage is "+ ps.checkStatus());
				   ac.checkActiveCampaignWidget();
			   }
		   
	  }else{
		  driver.navigate().back();
		   Thread.sleep(2000);
		  ac.purchaseActiveCampaign();
		  Assert.assertEquals(ps.checkStatus(),"true", "the status of the purchage is "+ ps.checkStatus());
			  ac.checkActiveCampaignWidget();
		  
		 
	  }
	  
	  
	  
  }
}
