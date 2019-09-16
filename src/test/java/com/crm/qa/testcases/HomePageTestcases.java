package com.crm.qa.testcases;

import java.io.File;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.SimpleFormDemoPage;
import com.crm.util.TestUtil;

public class HomePageTestcases extends TestBase{	
	
	HomePage homepage;
	
	SimpleFormDemoPage simpleformPage;
	
	TestUtil testuti;
	
	public HomePageTestcases()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		homepage=new HomePage();
		
		testuti= new TestUtil();
	}
	
	
	@Test(enabled=false)
	public void VerifyDemoPage()
	{
		String demopage= homepage.VerifyPage();
		
		System.out.println("Page name is: "+demopage);
		
		Assert.assertEquals(demopage, "Learn Selenium with Best Practices and Examples | Selenium Easy");
	}
	
	
	@Test(enabled=false)
	public void VerifyDemoLink()
	{
		
		homepage.DemoLink();
		
		String homePageName= homepage.VerifyPage();
		
		System.out.println("Page name is: "+homePageName);
		
		Assert.assertEquals(homePageName, "Selenium Easy - Best Demo website to practice Selenium Webdriver Online");
	}
	
	
	@Test(enabled=false)
	public void InputFormLink()
	{
		
		homepage.DemoLink();
		
		homepage.InputFormLink();		

	}
	

	
	@Test(enabled=false)
	public void SimpleFormDemo()
	{
		
		homepage.DemoLink();
		
		homepage.InputFormLink();	
		
		simpleformPage= homepage.SimpleFormDemo();
		
		simpleformPage.VerifyingSingleinputfieldText();
		
		TestUtil.clickScreenshots(driver, "Simpleformdemo");
			
	}
	
	@Test(enabled=false)
	public void VerifyBootstrapDatePickerLink()
	{
		
		homepage.DemoLink();
		
		homepage.verifyDatePickerMenu();
		
		homepage.VerifyBootstrapDatemenu();
		
			
	}
	
	@Test
	public void VerifySelectDropdownListLink()
	{
        homepage.DemoLink();
		
		homepage.InputFormLink();	
		
		
		homepage.verifyDropdownListmenu();
		
		//Thread.sleep(50000);
		
		
		TestUtil.clickScreenshots(driver, "VerifySelectDropdownListLink");
		
		
	}
	
	
	@AfterMethod()
	public void tearDown(ITestResult result)
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
		
		// Create reference of TakesScreenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		 
		// Call method to capture screenshot
		File source=ts.getScreenshotAs(OutputType.FILE);
		 
		// Copy files to specific location here it will save all screenshot in our project home directory and
		// result.getName() will return name of test case so that screenshot name will be same
		try {
			FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+"_"+System.currentTimeMillis()+".png"));
		} catch (Exception e) {
			
			e.getMessage();
		}
		
	
		}
		
		driver.quit();
		}

}
