package com.powerhouse.commonLib;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeBrowser {
	
	public static WebDriver driver;
	
   public InvokeBrowser(WebDriver driver){
	   this.driver=driver;
   }
   
   public  static WebDriver runBrowser(String browserName){
	   if(browserName.equalsIgnoreCase("firefox")){
		   driver=new FirefoxDriver();
		   return driver;
	   }
	
	  else if(browserName.equalsIgnoreCase("chrome")){
		   File f=new File("Drivers");
		   File fs=new File(f,"chromedriver.exe");
		   System.out.println(fs.getAbsolutePath());
		   System.setProperty("webdriver.chrome.driver", fs.getAbsolutePath());
		   driver=new ChromeDriver();
		   return driver;
	   }
	   return driver;
   }
}
