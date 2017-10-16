package com.powerhouse.pageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.powerhouse.commonLib.ExplictyWait;
import com.powerhouse.commonLib.SelectFunctions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Active_camp {
	
	public static WebDriver driver;
	public static WebElement element;
	public static ExtentTest test;
	PowersiteSubscription ps;
	public Active_camp(WebDriver driver,ExtentTest test){
		ps=new PowersiteSubscription(driver, test);
		this.driver=driver;
		this.test=test;
	}
	/************************************************************************************/
	
	/*these are the elements to get the subscription*/
	
	public static WebElement activeCampaignSubscription(){
		 element=driver.findElement(By.xpath("//li[text()='ActiveCampaign Subscriptions']"));
		 return element;
	}
	
   public static WebElement readMore(){
	   element=driver.findElement(By.xpath("//a[text()='Read more']"));
	   return element;
   }
   
   public static WebElement message(){
	   element=driver.findElement(By.xpath("//div[contains(text(),'You have a subscription to this product')]"));
	   return element;
   }
   
   public static WebElement planType(){
	   element=driver.findElement(By.id("pa_plan-type"));
	   return element;
   }
   
   public static WebElement contacts(){
	   element=driver.findElement(By.id("pa_contacts"));
	   return element;
   }
   
   public static WebElement activeCampaignAddToCart(){
	   element=driver.findElement(By.xpath("// button[text()='Add To Cart']"));
	   return element;
   }
   
   public void clcikOnActiveCampaignAddTocart(){
	   activeCampaignAddToCart().click();
   }
   
   /*
    * click on the active campaign and select the plan
    * 
    * */
   
   public void clickOnActiveCampaignSubScription(){
	   activeCampaignSubscription().click();
   }
   
   public void clickOnReadMore(){
	   readMore().click();
   }
   
   public void readTheMessage(){
	  String textMessage=message().getText();
	  System.out.println(textMessage);
   }
   
  public void showThePlan(){
	  SelectFunctions.showAlltheElements(planType());
  }
  
  public void selectThePlan(){
	  SelectFunctions.selectElementByValue(planType(), "25000-contact-plans");
  }
  
  
   
  public void showContacts(){
	  SelectFunctions.showAlltheElements(contacts());
  }
  
  public void selectTheContacts(){
	  SelectFunctions.selectElementByText(contacts(), "$338.00 - monthly - 25000 Contacts");
  }
  
 
  public void purchaseActiveCampaign() throws InterruptedException{
	  ps.mousehoverOnMarketPlace();
	  test.log(LogStatus.INFO, "hovered on the marketplace");
	  Thread.sleep(500);
	  ps.upgradeSubscription().click();
	  test.log(LogStatus.INFO, "clicked on the upgrade subscription");
	  
	  activeCampaignSubscription().click();
	  test.log(LogStatus.INFO, "clicked on the activaecampaign tab ");
	  clickOnReadMore();
	  test.log(LogStatus.INFO, "clciked on the readmore");
	  
	  ExplictyWait.waitForTheVisiilty(driver, 15, message());
	  
	  readTheMessage();
	  test.log(LogStatus.INFO, "reading the message");
	  showThePlan();
	  test.log(LogStatus.INFO, "showing all the plans");
	  showContacts();
	  test.log(LogStatus.INFO, "showing all the contacts");
	  
	  selectThePlan();
	  test.log(LogStatus.INFO, "plan is selected");
	  
	  selectTheContacts();
	  test.log(LogStatus.INFO, "contact is selected");
	  
	  clcikOnActiveCampaignAddTocart();
	  test.log(LogStatus.INFO, "clicked on the addto cart of active campaign");
	  
	  ExplictyWait.waitForTheVisiilty(driver, 10,driver.findElement(By.xpath("//a[text()='View cart']")));
		 driver.findElement(By.xpath("//a[text()='View cart']")).click();
		 
		 Thread.sleep(1500);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ps.proceedToCheckOut());
		 
		 ps.proceedToCheckOut().click();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 CopyOfcheckOut ch=new CopyOfcheckOut(driver, test);
		 ch.billingDetails();
		 
	  
  }
  
  
  
  
  

}
