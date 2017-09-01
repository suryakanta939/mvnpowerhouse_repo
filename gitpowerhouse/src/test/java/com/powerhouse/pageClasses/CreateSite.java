package com.powerhouse.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class CreateSite {
  static WebElement element=null;
  static WebDriver driver=null;
  ExtentTest test;
  public CreateSite(WebDriver driver,ExtentTest test){
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
   * this is the function to create site by using the Domain
   * 
   * */
  public void createSiteByDomain(){
	  
  }
  
  
}
