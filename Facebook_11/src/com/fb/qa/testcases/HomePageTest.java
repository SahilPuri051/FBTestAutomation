package com.fb.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.FriendRequestPage;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.utilities.getscreenshot;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	FriendRequestPage friendrequestpage;
	Logger logger;
	
	public HomePageTest()
	{
		super();
		logger= Logger.getLogger("HomePageTest");
		PropertyConfigurator.configure("C:\\Users\\SAHIL\\git\\FBTestAutomation\\Facebook_11\\com.fb.qa.resources\\log4j.properties");
	}
	
	@BeforeMethod
	public void init()
	{
		initialize();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=3 , retryAnalyzer=com.fb.qa.utilities.Listeners.class)
	public void postFeed()
	{
		homepage.postfeed(prop.getProperty("Post_content"));
	}
	
	
	@Test(priority=4, retryAnalyzer=com.fb.qa.utilities.Listeners.class)
	public void checkPost()
	{
		homepage.checkpost(prop.getProperty("Post_content"));
	}
	
	@Test(priority=5)
	public void searchbar()
	{
		friendrequestpage=homepage.searchfriend(prop.getProperty("Friend_Name"));
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException
	{
		logger.info(result.getMethod().getMethodName()+" "+"Over"+result.getEndMillis());
		Thread.sleep(2000);
		getscreenshot.shot1(result);
		driver.quit();
	}
}
