package com.crm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy (linkText="Demo Website!")
	@CacheLookup // it will store the element in cache memory // webdriver fire event is used to generate 	logs
	WebElement DemoPageLink;
	
	@FindBy (linkText="Input Forms1")
	
	WebElement inputFormsTab;
	
	@FindBy (linkText="Date pickers")
	
	WebElement DatePickersTab;
	
	@FindBy (linkText="Simple Form Demo")
	
	WebElement SimpleFormDemo;
	
	@FindBy (linkText="Bootstrap Date Picker")
	
	WebElement BootstrapDatePickerlink;
	
	@FindBy (linkText="Select Dropdown List")
	
	WebElement SelectDropdownListLink;
	
	
   
	// Action methods related above web elements...
	
   
   public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
   
   
   public String VerifyPage()
   {
	   return driver.getTitle();
   }
   
   
   public HomePage DemoLink()
   {
	   DemoPageLink.click();
	   
	   return new HomePage();
	   
   }
   
   public HomePage InputFormLink()
   {

	   inputFormsTab.click();
	   
	   return new HomePage();
	   
   }
   
   public SimpleFormDemoPage SimpleFormDemo()
   {

	   Actions act= new Actions(driver);
	   
	   act.moveToElement(SimpleFormDemo).click().perform();
	 
	   return new SimpleFormDemoPage();
	   
   }
   
   public HomePage verifyDatePickerMenu()
   {

	   DatePickersTab.click();
	   
	   return new HomePage();
	   
   }
   
   public BootStrapDatePickerPage VerifyBootstrapDatemenu()
   {

	   Actions act= new Actions(driver);
	   
	   act.moveToElement(BootstrapDatePickerlink).click().perform();
	 
	   return new BootStrapDatePickerPage();
	   
   }
   
   
   public SelectDropDownList verifyDropdownListmenu() {
	   
       Actions act= new Actions(driver);
	   
	   act.moveToElement(SelectDropdownListLink).click().perform();
	   
	   
	   return new SelectDropDownList();
	   
	   
	   
	  
   }
   
   
  
	

}
