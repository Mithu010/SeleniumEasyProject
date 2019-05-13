package com.crm.qa.testcases;

import org.testng.Assert;
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
	
	
	@Test
	public void VerifyDemoPage()
	{
		String demopage= homepage.VerifyPage();
		
		System.out.println("Page name is: "+demopage);
		
		Assert.assertEquals(demopage, "Learn Selenium with Best Practices and Examples | Selenium Easy");
	}
	
	
	@Test(enabled = true)
	public void VerifyDemoLink()
	{
		
		homepage.DemoLink();
		
		String homePageName= homepage.VerifyPage();
		
		System.out.println("Page name is: "+homePageName);
		
		Assert.assertEquals(homePageName, "Selenium Easy - Best Demo website to practice Selenium Webdriver Online");
	}
	
	
	@Test
	public void InputFormLink()
	{
		
		homepage.DemoLink();
		
		homepage.InputFormLink();		

	}
	

	
	@Test
	public void SimpleFormDemo()
	{
		
		homepage.DemoLink();
		
		homepage.InputFormLink();	
		
		simpleformPage= homepage.SimpleFormDemo();
		
		simpleformPage.VerifyingSingleinputfieldText();
		
		TestUtil.clickScreenshots(driver, "Simpleformdemo");
			
	}
	
	@Test
	public void VerifyBootstrapDatePickerLink()
	{
		
		homepage.DemoLink();
		
		homepage.verifyDatePickerMenu();
		
		homepage.VerifyBootstrapDatemenu();
		
			
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}

}
