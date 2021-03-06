package com.powerhouse.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.powerhouse.commonLib.ExtentFactory;
import com.powerhouse.commonLib.ScreenShot;
import com.powerhouse.pageClasses.HomePage;
import com.powerhouse.pageClasses.PowersiteSubscription;
import com.powerhouse.pageClasses.UpgradeGold;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PurchasePowersiteSubscription {
//	public static final String USERNAME = "davidding2";
//	  public static final String AUTOMATE_KEY = "jT7ix3GsnYAnApd1RdNy";
//public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	WebDriver driver; 
	String BaseUrl="https://pohostaging.com/";
	ExtentReports report;
	ExtentTest test;
	HomePage hp;
	PowersiteSubscription ps;
	@Parameters({"browser"})
	@BeforeClass(alwaysRun = true)
	  public void beforeClass(String browser) throws InterruptedException, MalformedURLException
	  {
//		 DesiredCapabilities caps = DesiredCapabilities.chrome();
//		    caps.setCapability("browser_version", "60");
//		    caps.setCapability("os", "Windows");
//		    caps.setCapability("os_version", "10");
//		    caps.setCapability("browserstack.debug", "true");
//		caps.setCapability("build", "version1");
//		caps.setCapability("project", "PurchasePowersiteSubscription");
//		driver = new RemoteWebDriver(new URL(URL), caps);
		// System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM WEBDRIVER SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		/*
		 * setting the extent reports
		 * */
		File f=new File("Drivers");
		File fs=new File(f,"chromedriver.exe");
		System.out.println(fs.getAbsolutePath());
		report=ExtentFactory.getInstancce();
		test=report.startTest("active campaign purchage");
		if(browser.equals("firefox")){
			driver=new FirefoxDriver();
			hp=new HomePage(driver, test);
			ps=new PowersiteSubscription(driver, test);
		}else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
			driver=new ChromeDriver();
			hp=new HomePage(driver, test);
			ps=new PowersiteSubscription(driver, test);
		}
		test.log(LogStatus.INFO, "browser is opened");
		
		driver.get(BaseUrl);
		test.log(LogStatus.INFO, "entered the powerhouse URL");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser is maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 /*click on the registration */
	  }
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	 hp.logInWithGoogle("suryakanta@abacies.com", "9066549823");
	  Thread.sleep(2000);
	  test.log(LogStatus.INFO, "loggged in to the powerhouse");
  }
  
  @Test
  public void purchsepowersite() throws InterruptedException {
	  
	  ps.purchaseBronze();
	  Thread.sleep(1000);
  }
  
  
  @AfterMethod
  public void tearDown(ITestResult result) throws IOException{
	  if(result.getStatus()==result.FAILURE){
		  ScreenShot.takeScreenShot(driver, result.getName());
		  test.log(LogStatus.INFO, "screen shot is taken");
	  }else{
		  System.out.println("test case got pass");
	  }
  }

  

  @AfterClass
  public void afterClass() {
	// driver.quit();
	 test.assignAuthor("Suryakanta Sahoo");
	 report.endTest(test);
	 report.flush();
  }

}
