package com.powerhouse.pageClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.powerhouse.commonLib.ExplictyWait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UpgradeGold  {

	 static WebElement element=null;
	 static WebDriver driver=null;
	 static	ExtentTest test;
	 PowersiteSubscription ps;
	 AddingSite as;
	public UpgradeGold(WebDriver driver,ExtentTest test){
		ps=new PowersiteSubscription(driver, test);
		 as=new AddingSite(driver,test);
		this.driver=driver;
		this.test=test; 
		
	}
	public static WebElement bronzeFreeTrial(){
		element=driver.findElement(By.xpath("//a[text()='PowerSite: Bronze (FREE TRIAL)']"));
		return element;
	}
	
	public static void clickOnBronzefreetrial(){
		String text=bronzeFreeTrial().getText();
		System.out.println(text);
		bronzeFreeTrial().click();
	}
	 
	public static void clickOnAddToCart(){
		driver.findElement(By.xpath("//button[contains(text(),'Add To Cart')]")).click();
	}
	/*
	 * this function is to click on the gold addto cart
	 * 
	 * */
	public void clickOnGoldCart() throws InterruptedException{
		ps.mousehoverOnMarketPlace();
		test.log(LogStatus.INFO, "mouse hove on market place");
		
		 Thread.sleep(500);
		 ps.upgradeSubscription().click();
		 test.log(LogStatus.INFO, "clicked on the upgradesubscription");
		 
		 ps.goldAddToCart().click();
		 test.log(LogStatus.INFO, "clicked on the add to cart of bronze");
		 Thread.sleep(1500);
		 
		 ExplictyWait.waitForTheVisiilty(driver, 10, ps.goldMessage());
		 System.out.println(ps.goldMessage().getText());
		 
	}
	/*
	 * selecting the sites
	 * */
	public static WebElement selectSite(){
		element=driver.findElement(By.xpath("//select[@id='woo_field_site']"));
		return element;
	}
	
	public static WebElement clcikTocreateSiteMessage(){
		element=driver.findElement(By.xpath("//li[contains(text(),'apply this subscription or if you have not created ')]"));
		return element;
	}
	
	public static WebElement clcikTocreateSite(){
		element=driver.findElement(By.xpath("//a[text()='click here']"));
		return element;
	}
	public static int noOfSitePresent(){
		Select sel=new Select(selectSite());
		List<WebElement> options=sel.getOptions();
		int noOfSite=options.size();
		return noOfSite;
	}
	
	/*
	 * this function is to add the site to the upgrade function
	 * */
	
	public static void choosingSiteToAdd(){
		Select sel=new Select(selectSite());
		List<WebElement> options=sel.getOptions();
		//selecting the lastsite name
		options.get(options.size()-1).click();
	}
	public void selectingSite() throws InterruptedException{
		if(noOfSitePresent()==1 && clcikTocreateSiteMessage().isDisplayed()){
			clcikTocreateSite().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "chekcing the no of site present");
			as.createSiteBySubDomain();
			test.log(LogStatus.INFO, "creating site by using domain");
			Thread.sleep(2000);
			driver.navigate().to("https://pohostaging.com/product/powersite-upgrade-gold/");
			choosingSiteToAdd();
		}else{
			choosingSiteToAdd();
			test.log(LogStatus.INFO, "choosed the site to the site");
		}
	}
	
	/*
	 * this function is to upgrade the gold
	 * */
	
	public void upgradegold() throws InterruptedException{
		clickOnGoldCart();
		test.log(LogStatus.INFO, "clicked on the gold add to cart");
		selectingSite();
		test.log(LogStatus.INFO, "selected the site");
	}
}
