package com.fb.qa.testcases;

import java.io.IOException;

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
	
	public LoginPageTest()
	{
		super();
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
		getscreenshot.shot1(result);
		driver.quit();
	}
}
