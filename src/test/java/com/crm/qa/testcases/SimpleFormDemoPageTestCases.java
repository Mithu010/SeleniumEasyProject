package com.crm.qa.testcases;

import java.io.File;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.SimpleFormDemoPage;

import junit.framework.Assert;

public class SimpleFormDemoPageTestCases extends TestBase{

    HomePage homepage;
	
	SimpleFormDemoPage simpleformPage;
	
	public SimpleFormDemoPageTestCases()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();

		homepage=new HomePage();
		
		simpleformPage= new SimpleFormDemoPage();
	}
	
	
	@Test
	public void VerifySingleInputField()
	{
		homepage.DemoLink();
		
		homepage.InputFormLink();
		
		homepage.SimpleFormDemo();
		
		simpleformPage.VerifyEnterMessageField();
		
		simpleformPage.VerifyShowButtonClick();
		
	}
	
	@Test
	public void VerifyTwoInputField()
	{
		homepage.DemoLink();
		
		homepage.InputFormLink();
		
		homepage.SimpleFormDemo();
		
		simpleformPage.VerifyTextFieldA();
		
		simpleformPage.VerifyTextFieldB();
		
		simpleformPage.VerifySubmitButton();
		
		String total= simpleformPage.VerifyTwoFieldTotal();
		
		Assert.assertEquals("33", total);
		
		
	}
	
	@AfterMethod()
	public void tearDown(ITestResult result)
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
		
		// Create refernce of TakesScreenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		 
		// Call method to capture screenshot
		File source=ts.getScreenshotAs(OutputType.FILE);
		 
		// Copy files to specific location here it will save all screenshot in our project home directory and
		// result.getName() will return name of test case so that screenshot name will be same
		try {
			FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
		} catch (Exception e) {
			
			e.getMessage();
		}
		
	
		}
		
		driver.quit();
		}
}







