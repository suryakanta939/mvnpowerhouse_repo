package com.powerhouse.pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.powerhouse.commonLib.RandomNames;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddingSite {
  static WebElement element=null;
  static WebDriver driver=null;
  ExtentTest test;
  RandomNames rn=null;
  public AddingSite(WebDriver driver,ExtentTest test){
	  rn=new RandomNames();
	  this.driver=driver;
	  this.test=test;
  }
  
  /*
   * elements for creating site
   * */
  
  public static WebElement siteTypeDomain(){
	  element=driver.findElement(By.xpath("//label[1][input[@name='site_type']]"));
	  return element;
  }

  public static WebElement siteTypeSubDomain(){
	  element=driver.findElement(By.xpath("//label[2][input[@name='site_type']]"));
	  return element;
  }

  public static WebElement domainSelection(){
	  element=driver.findElement(By.xpath("//select[@id='domain']"));
	  return element;
  }
  
  public static WebElement subDomainSiteName(){
	  element=driver.findElement(By.id("site-address"));
	  return element;
  }
  
  public static WebElement siteName(){
	  element=driver.findElement(By.id("site_name"));
	  return element;
  }
  
  public static WebElement templateSelection(){
	 element=driver.findElement(By.id("blog_template"));
	 return element;
  }
  
  public static WebElement createSiteButton(){
		 element=driver.findElement(By.id("add_network"));
		 return element;
	  }
  /*
   * check the no of domain present in the select box
   * 
   * */
  public static int noOfDomains(){
	  Select sel=new Select(domainSelection());
	  List<WebElement> opt=sel.getOptions();
	  int domains=opt.size();
	  return domains;
  }
  /*
   * this is the function to create site by using the Domain
   * 
   * */
  public void createSiteByDomain(){
	  siteTypeDomain().click();
	  test.log(LogStatus.INFO, "checked the site type domain");
	  if(noOfDomains()==1){
		  System.out.println("you dont have any domains now ,Please Create Some domain Or "
		  		+ " Choose The SubDomains To crate Site");
	  }else{
		  
		  Select sel=new Select(domainSelection());
		  List<WebElement> opt=sel.getOptions();
		  opt.get(opt.size()-1).click();
		  test.log(LogStatus.INFO, "one domain is selected");
		  
		  siteName().sendKeys("surya_site");
		  test.log(LogStatus.INFO, "added one site name");
		  
		  test.log(LogStatus.INFO, "adding the default DIV");
		  
		 createSiteButton().click();
		 test.log(LogStatus.INFO, "clciked on the create site");
	  }
	
  }
  /*
   * This function is to create site by using the sub domain
   * 
   */
  public void createSiteBySubDomain(){
	  siteTypeSubDomain().click();
	  test.log(LogStatus.INFO, "clicked on the  subDomain");
	  String siteDomainName=rn.name();
	  subDomainSiteName().sendKeys(siteDomainName);
	  test.log(LogStatus.INFO, "Added the subDomain Site Name");
	  String siteName=rn.name();
	  siteName().sendKeys(siteName);
	  test.log(LogStatus.INFO, "Adding the default theme to the site");
	  
	  createSiteButton().click();
	  test.log(LogStatus.INFO, "clicked the create site button");
	  
  }
  
}
