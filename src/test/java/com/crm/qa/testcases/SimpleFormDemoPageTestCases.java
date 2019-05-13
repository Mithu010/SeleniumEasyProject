package com.crm.qa.testcases;

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
	public void tearDown()
	{
		driver.quit();
	}

}







