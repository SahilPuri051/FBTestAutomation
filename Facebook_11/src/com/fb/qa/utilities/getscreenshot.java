package com.fb.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.fb.qa.base.TestBase;
import com.google.common.io.Files;

public class getscreenshot extends TestBase {
	
	public static void shot1(ITestResult result) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshots/"+result.getMethod().getMethodName()+System.currentTimeMillis()+".png"));
	}
	
public static void shot2(String name) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshots/"+name+System.currentTimeMillis()+".png"));
	}

}
