package com.fb.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.RegisterPage;
import com.fb.qa.utilities.getscreenshot;

public class RegisterPageTest extends TestBase{
	
	LoginPage loginpage;
	RegisterPage registerpage;
	
	@BeforeMethod
	public void init()
	{
		initialize();
		registerpage=new RegisterPage();
	}
	
	
	

	@Test(priority=1)
	public void register_() throws IOException
	{
		String fn=prop.getProperty("firstname");
		String ln=prop.getProperty("lastname");
		String em=prop.getProperty("email");
		String em2=prop.getProperty("email2");
		String month1=prop.getProperty("monthsel");
		String year1=prop.getProperty("yearsel");
		String day1=prop.getProperty("daysel");
		String pa=prop.getProperty("password");
		loginpage=registerpage.register(fn, ln, pa, em, em2,year1, month1, day1);
		getscreenshot.shot2("Info_Filled_OnRegisterPage");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		getscreenshot.shot1(result);
		//driver.quit();

	}

}
