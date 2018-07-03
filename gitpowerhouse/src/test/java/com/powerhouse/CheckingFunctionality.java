package com.powerhouse;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class CheckingFunctionality {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException 
  {
  FirefoxProfile profile = new FirefoxProfile();
	  System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
	
	 driver.get("https://pohostaging.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//a[contains(@href,'%3A%2F%2Fwww.googleapis.com%')]")).click();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		 driver.findElement(By.xpath("//div[@id='identifierLink']//div[2]")).click();
	 driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("suryakanta@abacies.com");
	 driver.findElement(By.xpath("//span[text()='Next']")).click();
	Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("8867117363");
	 driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//a[text()='Marketplace']"))).perform();
	Thread.sleep(500);
	driver.findElement(By.xpath("//a[text()='Upgrade Subscription']")).click();
	
	WebElement link=driver.findElement(By.xpath("//h2[contains(text(),'PowerSite: Bronze (FREE TRIAL)')]"));
	
	act.contextClick(link).sendKeys("t").perform();
	
	act.sendKeys(Keys.chord(Keys.CONTROL,"t")).perform();
	
	driver.get("https://www.google.co.in");
	Thread.sleep(2000);
 //  driver .quit();	
	
	

	  
  }
}
