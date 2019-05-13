package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.BootStrapDatePickerPage;
import com.crm.pages.HomePage;
import com.crm.pages.SimpleFormDemoPage;
import com.crm.util.TestUtil;

public class BootStrapDatePickerPageTestCases extends TestBase{

	HomePage homepage;
	
	SimpleFormDemoPage simpleformPage;
	
	BootStrapDatePickerPage bootstrapsdatepicker;
	
	TestUtil testuti;
	
	public BootStrapDatePickerPageTestCases()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		homepage=new HomePage();
		
		simpleformPage= new SimpleFormDemoPage();
		
		bootstrapsdatepicker= new BootStrapDatePickerPage();	
		
		testuti= new TestUtil();
	}
	
	
	@Test
	public void VerifyBootstrapPage()
	{
        homepage.DemoLink();
		
		homepage.verifyDatePickerMenu();
		
		homepage.VerifyBootstrapDatemenu();
		
		String actual= bootstrapsdatepicker.VerifyBootDatePage();
		
		System.out.println("Page name is : "+actual);
		
		Assert.assertEquals(actual, "Bootstrap Date Pickers Example");
		
	}
	
	@Test
	public void VerifyCurrentDate()
	{
        homepage.DemoLink();
		
		homepage.verifyDatePickerMenu();
		
		homepage.VerifyBootstrapDatemenu();
		
		bootstrapsdatepicker.verifyCurrentDate();
		
	}
	
	@Test
	public void VerifyBootstrapFromAndTo()
	{
        homepage.DemoLink();
		
		homepage.verifyDatePickerMenu();
		
		homepage.VerifyBootstrapDatemenu();
		
		bootstrapsdatepicker.verifyCurrentFromDate();
		
		bootstrapsdatepicker.verifyCurrentToDate();
		
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}

	
	
	
}
