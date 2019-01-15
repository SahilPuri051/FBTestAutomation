package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class RegisterPage extends TestBase {
	

	//Page Factory
	
		@FindBy(name="firstname")
		WebElement firstname;
		
		@FindBy(name="lastname")
		WebElement lastname;
		
		@FindBy(name="reg_email__")
		WebElement emailid;
		
		@FindBy(name="reg_passwd__")
		WebElement pass;
		
		@FindBy(id="u_0_a")
		WebElement sex;
		
		@FindBy(xpath="//button[@name='websubmit']")
		WebElement Signupbutton;
		
		@FindBy(id="day")
		WebElement day;
		
		@FindBy(id="month")
		WebElement month;
		
		@FindBy(id="year")
		WebElement year;
		
		@FindBy(name="reg_email_confirmation__")
		WebElement email2;
		
		public RegisterPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		Select sel;
		
		public LoginPage register(String fn,String ln,String pa,String em,String em2,String year1,String month1, String day1)
		{
			firstname.sendKeys(fn);
			lastname.sendKeys(ln);
			emailid.sendKeys(em);
			email2.sendKeys(em2);
			sex.click();
			pass.sendKeys(pa);
			sel=new Select(day);
			sel.selectByVisibleText(day1);
			
			sel=new Select(month);
			sel.selectByVisibleText(month1);
			
			sel=new Select(year);
			sel.selectByVisibleText(year1);
			
			Signupbutton.click();
			
			return new LoginPage();
		}
	

}
