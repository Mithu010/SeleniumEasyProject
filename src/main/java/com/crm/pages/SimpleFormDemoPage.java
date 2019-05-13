package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.base.TestBase;

public class SimpleFormDemoPage extends TestBase {

	
	public SimpleFormDemoPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Page factory or Object Repository
	
		@FindBy(name="username")
		
		WebElement username;
		
		@FindBy (xpath="//button[@class='btn btn-default']")
		
		WebElement showbuttonMessage;
		
		@FindBy (id="user-message")
		
		WebElement EnterMessageField;
		
        @FindBy (id="sum1")
		
		WebElement twoInputFielsA;
        
        @FindBy (id="sum2")
		
		WebElement twoInputFielsB;
		
		
		@FindBy (xpath="//button[@onclick='return total()']")
		
		WebElement getTotalButton;
		
		@FindBy (id= "displayvalue")
		
		WebElement displayTotaltalForTwoFields;
		
		
		
		//Methods related to SimpleFormDemo class
		
		public String VerifyingSingleinputfieldText()
		{
			String textname= showbuttonMessage.getText();
			
			System.out.println("Text  is : "+textname);
			
			Assert.assertEquals(textname, "Show Message");
			return toString();
		}
		
		
		
		//enter message field
		
		public SimpleFormDemoPage VerifyEnterMessageField()
		{

			EnterMessageField.sendKeys("testing text");
			
			return new SimpleFormDemoPage();
			
		} 
		
		// show button field
		public SimpleFormDemoPage VerifyShowButtonClick()
		{
			showbuttonMessage.click();
			
			return new SimpleFormDemoPage();
			
		} 
		
		
		//Multiple add field A
		
		public SimpleFormDemoPage VerifyTextFieldA()
		{
			twoInputFielsA.sendKeys("11");
			return new SimpleFormDemoPage();
			
		} 
		
		
		//Multiple add field B
		
	   public SimpleFormDemoPage VerifyTextFieldB()
		{
		   twoInputFielsB.sendKeys("22");
		   return new SimpleFormDemoPage();
					
		}
	   
	   
	   // Submit button for two input fields
	   
	   public SimpleFormDemoPage VerifySubmitButton()
		{
		   
		   getTotalButton.click();
		   return new SimpleFormDemoPage();
					
		}
		
      // Display total for two fields
	   
	   public String VerifyTwoFieldTotal()
		{
		   return displayTotaltalForTwoFields.getText();
		}
		
		
}
