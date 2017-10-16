package com.powerhouse.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.powerhouse.commonLib.ExplictyWait;
import com.relevantcodes.extentreports.ExtentTest;

public class LogInCheck {
    public static WebDriver driver;
     public static WebElement element;
     public static ExtentTest test;
     
     public LogInCheck(WebDriver driver,ExtentTest test){
    	 this.driver=driver;
    	 this.test=test;
     }
     
     
     /*
      * These elements are to perform the 
      * signin up with google
      * */
     
     
     public static WebElement loginGoogle(){
    	 element=driver.findElement(By.xpath("//a[@class='btn btn-default glogin-btn']"));
    	 return element;
     }
     
     public static WebElement email(){
    	  element=driver.findElement(By.xpath("//input[@type='email']"));
    	  return element;
     }
     
     public static WebElement next(){
   	  element=driver.findElement(By.xpath("//span[text()='Next']"));
   	  return element;
    }
     
     public static WebElement passWord(){
   	  element=driver.findElement(By.xpath("//input[@type='password']"));
   	  return element;
    }
     
     public void logInWithGoogle(String userName,String passWord) throws InterruptedException{
    	 loginGoogle().click();
    	 ExplictyWait.waitForTheVisiilty(driver, 10, email());
    	 email().sendKeys(userName);
    	 next().click();
    	 Thread.sleep(3000);
    	// ExplictyWait.waitForTheVisiilty(driver, 10, passWord());
    	 passWord().sendKeys(passWord);
    	 next().click();
     }
     
    /*This elements are to use
     * for the facebook login
     * */ 
     
     public static WebElement logInfacebook(){
    	 element=driver.findElement(By.xpath("//a[@class='btn btn-default facebook-btn']"));
    	 return element;
     }
     
     public static WebElement faceBookEmail(){
    	 element=driver.findElement(By.id("email"));
    	 return element;
     }
     
     public static WebElement faceBookPass(){
    	 element=driver.findElement(By.id("pass"));
    	 return element;
     }
     
     public static WebElement faceBookloginButton(){
    	 element=driver.findElement(By.id("loginbutton"));
    	 return element;
     }
     
     public static WebElement faceBookText(){
    	 element=driver.findElement(By.xpath("//span[text()='Log in to Facebook']"));
    	 return element;
     }
     
     public void loginWithFaceBook(String userName,String passWord){
    	 logInfacebook().click();
    	 ExplictyWait.waitForTheVisiilty(driver, 15, faceBookText());
    	 faceBookEmail().sendKeys(userName);
    	 faceBookPass().sendKeys(passWord);
    	 faceBookloginButton().click();
     }
     
}
