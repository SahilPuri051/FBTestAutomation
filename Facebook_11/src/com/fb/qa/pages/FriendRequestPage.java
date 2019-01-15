package com.fb.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class FriendRequestPage extends TestBase {

	@FindBy(xpath="(//button[@aria-label='Add Friend'])[1]")
	WebElement Addfriendbutton;
	
	public FriendRequestPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void sendRequest()
	{
		Actions act=new Actions(driver);
		act.moveToElement(Addfriendbutton).click().build().perform();
	}
	
}
