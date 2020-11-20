package com.vtiger.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListnerImplementation implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getName()+"Execution Fininsh");
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getName()+"Execution Start");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		System.out.println(arg0.getName()+"Execution Test Failed But Within SuccessPercentage");
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		Date d= new Date();// java.util
		String currentDateTime = d.toString().replace(":", "_");
		System.out.println("CUrrent date is :-"+currentDateTime);
		String testCaseName = arg0.getName();
//		EventFiringWebDriver efwd = new EventFiringWebDriver(_01_finalVersionOfBaseClass.driver);   //driver to sattic 
//	File sourcefile =	efwd.getScreenshotAs(OutputType.FILE);
//	try {
//		FileUtils.copyFile(sourcefile, new File("/com.gaurav.framework/screenshot"+testCaseName+currentDateTime+".png"));
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		EventFiringWebDriver efw = new EventFiringWebDriver(_01_finalVersionOfBaseClass.driver);
		File souceFile =	efw.getScreenshotAs(OutputType.FILE);
		
		// copy and paste coomon io needed
		
		try {
			FileUtils.copyFile(souceFile, new File("./screenshot/"+testCaseName+currentDateTime+".png"));
		} catch (IOException e) {
			
			
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test case skipped"+arg0.getName());
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test case Satrt"+arg0.getName());
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test case Successfu "+arg0.getName());
		
	}

}
