package com.fb.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fb.qa.base.TestBase;

public class HomePage extends TestBase {
	JavascriptExecutor je;
	WebDriverWait wait;
	
	// Page Factory
	
	@FindBy(xpath="//button[@data-testid='react-composer-post-button']")
	WebElement Sharebutton;
	
	@FindBy(xpath="//div[text()='News Feed']")
	WebElement Newsbutton;
	
	@FindBy(xpath="//a[@title='Profile']")
	WebElement myprofile;
	
	@FindBy(xpath="//span[text()='Create post']")
	WebElement createpost;
	
	@FindBy(xpath="(//div[@contenteditable='true'])[1]//div[@data-contents='true']")
	WebElement textarea;
	
	@FindBy(xpath="//button[@data-testid='react-composer-post-button']")
	WebElement sharebutton;
	
	@FindBy(xpath="(//div[@class='_5_jv _58jw'])[1]/p")
	WebElement latestpost;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchbar;
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
		je=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver,5);
	}
	
	public void postfeed(String msg)
	{
		
		//PageFactory.initElements(driver,this);
		wait.until(ExpectedConditions.visibilityOf(createpost));
		createpost.click();
		
		wait.until(ExpectedConditions.visibilityOf(textarea));
		Actions act=new Actions(driver);
		act.moveToElement(textarea).click().sendKeys(msg).build().perform();
		sharebutton.click();
	}
	
	
	public void checkpost(String msg)
	{
		myprofile.click();
		wait.until(ExpectedConditions.visibilityOf(latestpost));
		String postget=latestpost.getText();
		Assert.assertEquals(postget,msg);
	}
	
	public FriendRequestPage searchfriend(String friendname)
	{
		Actions act=new Actions(driver);
		act.moveToElement(searchbar).sendKeys(friendname).sendKeys(Keys.ENTER).build().perform();
		return new FriendRequestPage();
	}
}
