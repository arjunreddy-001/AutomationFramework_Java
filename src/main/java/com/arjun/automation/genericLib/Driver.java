package com.arjun.automation.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class Driver 
{
	WebDriver driver;
	
	public Driver(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public WebDriver getDriver(String browser, String OS)
	{
		String basePath = System.getProperty("user.dir");
		
		switch(browser)
		{
			case "chrome" :
				
				System.setProperty("webdriver.chrome.driver", basePath + "\\browser-drivers\\windows\\chrome\\chromedriver.exe");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
//				options.addArguments("headless");
//				options.addArguments("window-size=1200x600");
				options.addArguments("test-type");
				options.addArguments("--disable-extenstions");
				options.addArguments("--disable-notifications");
				options.addArguments("disable-infobars");
				
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				break;
				
			case "edge" :
				
				System.setProperty("webdriver.edge.driver", basePath + "\\browser-drivers\\windows\\edge\\MicrosoftWebDriver.exe");
				
				driver = new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				break;
				
			case "ie" :
				
				System.setProperty("webdriver.ie.driver", basePath + "\\browser-drivers\\windows\\ie\\IEDriverServer.exe");
				
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				break;
				
			case "firefox" :
				
				System.setProperty("webdriver.gecko.driver", basePath + "\\browser-drivers\\windows\\firefox\\geckodriver.exe");
				
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				break;
				
			default :
				
				Assert.assertTrue(false, "Cannot create instance of " + browser + " driver for Operating System " + OS );
		}
		return driver;
	}
}
