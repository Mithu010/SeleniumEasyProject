package com.crm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class SelectDropDownList extends TestBase {
	
	
	public SelectDropDownList()
	{
		PageFactory.initElements(driver, this);
	}

	
	@FindBy (xpath="//div[text()=\"Select List Demo\"]")
	
	WebElement VefifySelectDropDownListpage;
	
	
	
	
	
	

	
	
	
}
