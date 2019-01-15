package com.fb.qa.utilities;

import org.testng.IRetryAnalyzer; 
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.fb.qa.base.TestBase;

public class Listeners extends TestBase implements ITestListener,IRetryAnalyzer {
	static int count=0;
	static int max=2;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<max)
		{
			count++;
			return true;
		}
		return false;
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Pass ******");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Fail ******");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
