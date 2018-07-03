package com.powerhouse.commonLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandel {
	
 
	 public static void handelWindowByTitle(WebDriver driver,String desiredTitle){
			String ParentId=driver.getWindowHandle();
			Set<String> Ids=driver.getWindowHandles();
			for(String id:Ids){
				if(!id.equals(ParentId)){
					driver.switchTo().window(id);
					String actualTitle=driver.getTitle();
					if(actualTitle.equals(desiredTitle)){
						driver.switchTo().window(id);
					}
				}
			}
		}
		/**
		 * This function is to handle the window by its no
		 * here the parent window will be the 1st window and then
		 * first click as second window and so on
		 * 
		 * */
		
		public static void handelWindowByNo(WebDriver driver,int desireWindowNo){
			Set<String> Ids=driver.getWindowHandles();
			    Iterator<String> itr=Ids.iterator();
			    for(int i=1;i<=Ids.size();i++){
			    	String id=itr.next();
			    	if(i==desireWindowNo){
			    		driver.switchTo().window(id);
			    	}
			    }
		}

	
}
