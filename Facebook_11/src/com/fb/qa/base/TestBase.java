package com.fb.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase()
	{	
		try
		{
			FileInputStream file=new FileInputStream("C:\\Users\\SAHIL\\eclipse-workspace\\Facebook_11\\src\\com\\fb\\qa\\config\\config.properties");
			prop=new Properties();
			prop.load(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
		public void initialize()
		{
			String browser=prop.getProperty("browser");
			
			if(browser.contains("chrome"))
			{
				Map<String,Object> prefs=new HashMap<String,Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options=new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				driver=new ChromeDriver(options);
			
			}
			else if(browser.contains("firefox"))
			{
				driver=new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
		}
		
	}
