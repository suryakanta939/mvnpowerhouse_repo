package com.powerhouse.commonLib;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	static ExtentReports extent;
	public static ExtentReports getInstancce(){
		File f=new File("Report");
		  File fs=new File(f,"");
		  System.out.println(fs.getAbsolutePath());
		// extent=new ExtentReports("E:\\SELENIUM_PROGRAM\\gitpowerhouse\\Report\\powerhouse.html",false);
		  extent=new ExtentReports(fs.getAbsolutePath()+"\\powerhouse.html",false);
		 return extent;
	}
}
