package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fb.qa.base.TestBase;

import com.fb.qa.base.TestBase;

public class LoginPage extends TestBase {


		
		//Page Factory
		
			@FindBy(id="email")
			WebElement username;
			
			@FindBy(id="pass")
			WebElement password;
			
			@FindBy(xpath="//input[@value='Log In']")
			WebElement loginbutton;
			
			
			
			public LoginPage()
			{
				PageFactory.initElements(driver, this);
			}
			
			public String validateCurrentUrl()
			{
				return driver.getCurrentUrl();	
			}
			
			public HomePage login(String us,String pa)
			{
				username.sendKeys(us);
				password.sendKeys(pa);
				loginbutton.click();
				
				return new HomePage();
			}
		
}
