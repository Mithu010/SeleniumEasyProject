package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class BootStrapDatePickerPage extends TestBase {

	
	public BootStrapDatePickerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// elements related to Bootstraps date picker page
	
	@FindBy (xpath="//div[@class='col-md-6 text-left']")
	
	WebElement verifyBootStrapPage;
	
	@FindBy (xpath="//input[@class='form-control']")
	
	WebElement selectDateExample;
	
    @FindBy (xpath="//td[@class='today day']")
   
    WebElement currentDate;
   
    @FindBy (xpath="//div[@id='datepicker']//td[@class='form-control']")
   
    WebElement DateRangeFromeDate;
    
    @FindBy (xpath="//span[@class='input-group-addon']//td[@class='form-control']")
    
    WebElement DateRangeToDate;
	
	//methods related to bootstrap date picker pages
	
	public String VerifyBootDatePage() {
		
		return verifyBootStrapPage.getText();
	}
	
	public BootStrapDatePickerPage verifyCurrentDate()
	{
		selectDateExample.sendKeys("10/05/2019");
		
		//currentDate.click();
		
		return new BootStrapDatePickerPage();	
	
	}
	
	public BootStrapDatePickerPage verifyCurrentFromDate()
	{
		DateRangeFromeDate.sendKeys("01/05/2019");
		
		//currentDate.click();
		
		return new BootStrapDatePickerPage();	
	
	}
	
	public BootStrapDatePickerPage verifyCurrentToDate()
	{
		DateRangeFromeDate.sendKeys("15/05/2019");
		
		//currentDate.click();
		
		return new BootStrapDatePickerPage();	
	
	}
	
	
	
	
}
