package com.crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.base.TestBase;

public class TestUtil extends TestBase{
	
	static String Test_Data_Sheetpath="/FreeCRMtest/src/main/java/com/crm/testdata/FreeCRMTestdata.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	
	public static long PAGE_LOAD_TIMEOUT= 20;
	
	public static long Implicit_wait=10;
	
	public void swithToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file=null;
		try{
			file= new FileInputStream(Test_Data_Sheetpath);
			
		}catch(FileNotFoundException e)
				{
			e.printStackTrace();
			
		}
		try{
			book= WorkbookFactory.create(file);
		}catch(InvalidFormatException e)
		{
		e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("last row number "+sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
		for(int i=0; i< sheet.getLastRowNum(); i++){
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		
		return data;
			
	}
	
//	public static void screenshotsAtTheEndOfTest() throws IOException{
//		File scrfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		
//		String currentdir= System.getProperty("user.dir");
//		
//		FileUtils.copyFile(scrfile, new File(currentdir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//		
//	}
	
	
	@Test
	public static void clickScreenshots(WebDriver driver, String testScreenName)
	{
	
	
	try {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		
		//FileUtils.copyFile(source, new File("./Screenshots/"+testScreenName+"_"+System.currentTimeMillis()+".png"));
		
	} catch (Exception e) {
		
	}
}


}
