package com.arjun.automation.genericLib;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.arjun.automation.utilities.ReadConfig;

public class Driver 
{
	WebDriver driver;
	ReadConfig readConfig = new ReadConfig();
	
	public Driver(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	/** Browser Driver initialization
	 * 
	 * @author Arjun Reddy
	 * @param browser
	 * @return driver
	 */
	
	public WebDriver getDriver(String browser)
	{
		String OS = System.getProperty("os.name").toLowerCase();
		
		/*
		 * Determining the Operating System
		 * on which browser driver need to be initialized
		 */
		
		if(OS.contains("windows") || SystemUtils.IS_OS_WINDOWS)
		{
			OS = "windows";
		}
		else if(OS.contains("mac") || SystemUtils.IS_OS_MAC)
		{
			OS = "mac";
		}
		else if(OS.contains("linux") || SystemUtils.IS_OS_LINUX)
		{
			OS = "linux";
		}
		else
		{
			Assert.assertTrue(false, "Unhandled OS detected for initializing " + browser +" browser, OS Name : " + OS);
		}
		
		
		/*
		 * Initializing appropriate browser driver based on Operating System
		 */
		
		switch(browser)
		{
			case "chrome" :
					
				switch(OS)
				{
					case "windows" :
						
						System.setProperty("webdriver.chrome.driver", readConfig.getWindowsChromeDriver() );
						break;
						
					case "mac" :
						
						System.setProperty("webdriver.chrome.driver", readConfig.getMacChromeDriver() );
						break;
						
					case "linux" :
						
						System.setProperty("webdriver.chrome.driver", readConfig.getLinuxChromeDriver() );
						break;
						
					default :
						
						Assert.assertTrue(false, browser + " browser not available for " + OS + " Operating System (or) Browser initialization unhandled");
				}
				
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
				
				switch(OS)
				{
					case "windows" :
						
						System.setProperty("webdriver.edge.driver", readConfig.getEdgeDriver());
						break;
						
					default :
						
						Assert.assertTrue(false, browser + " browser not available for " + OS + " Operating System (or) Browser initialization unhandled");
				}
				
				driver = new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				break;
				
			case "ie" :
				
				switch(OS)
				{
					case "windows" :
						
						System.setProperty("webdriver.ie.driver", readConfig.getIEDriver());
						break;
						
					default :
						
						Assert.assertTrue(false, browser + " browser not available for " + OS + " Operating System (or) Browser initialization unhandled");
				}
				
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				break;
 
			case "firefox" :
				
				switch(OS)
				{
					case "windows" :
						
						System.setProperty("webdriver.gecko.driver", readConfig.getWindowsFirefoxDriver());
						break;
						
					case "mac" :
						
						System.setProperty("webdriver.gecko.driver", readConfig.getMacFirefoxDriver() );
						break;
						
					case "linux" :
						
						System.setProperty("webdriver.gecko.driver", readConfig.getLinuxFirefoxDriver() );
						break;
						
					default :
						
						Assert.assertTrue(false, browser + " browser not available for " + OS + " Operating System (or) Browser initialization unhandled");
				}
				
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				break;
				
			default :
				
				Assert.assertTrue(false, "Cannot create instance of " + browser + " driver for Operating System " + OS );
		}
		return driver;
	}
}