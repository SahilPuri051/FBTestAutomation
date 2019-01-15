package com.fb.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.utilities.getscreenshot;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	Logger logger;
	
	public LoginPageTest()
	{
		super();
		logger= Logger.getLogger("LoginPageTest");
		PropertyConfigurator.configure("C:\\Users\\SAHIL\\git\\FBTestAutomation\\Facebook_11\\com.fb.qa.resources\\log4j.properties");
	}
	
	@BeforeMethod
	public void init()
	{
		initialize();
		loginpage=new LoginPage();
	}
	
	@Test (priority=1)
	public void loginPageUrlValidation()
	{
		 String urll=loginpage.validateCurrentUrl();
		 Assert.assertEquals(urll,"https://www.facebook.com/");
	}
	
	

	@Test(priority=2)
	public void login()
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		logger.info(result.getMethod().getMethodName()+" "+"Over"+result.getEndMillis());
		getscreenshot.shot1(result);
		driver.quit();
	}
}
