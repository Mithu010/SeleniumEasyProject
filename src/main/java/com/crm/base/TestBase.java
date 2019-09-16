package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.crm.util.TestUtil;
import com.crm.util.WebEventListener;


public class TestBase {

	
	// basic initialization like browser etc
   
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	
	public TestBase()
	{
		// read the property file
	//	BasicConfigurator.configure();
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\inmanagall\\eclipse-workspace\\FreeCRMtest\\src\\main\\java\\com\\crm\\config\\config1.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		    }
		
		
	}
	
	public static void initialization(){
	String browser_name= prop.getProperty("browser");// reading browser type from properties file
	
	if(browser_name.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Mithun\\Driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
	}
	else if (browser_name.equals("firefox"))
	{

		System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver\\geckodriver.exe");
		
		driver=new FirefoxDriver();
		
	}
	
	e_driver= new EventFiringWebDriver(driver);
	
	eventListener= new WebEventListener();
	
	e_driver.register(eventListener);
	
	driver= e_driver;
	
	driver.manage().window().maximize();
	
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	

  }
	
}
