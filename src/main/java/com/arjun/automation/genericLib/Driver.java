package com.arjun.automation.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver 
{
	WebDriver driver;
	
	public Driver()
	{
		super();
		//Default Constructor
	}
	
	public WebDriver getDriver(String browser)
	{
		switch(browser)
		{
			case "chrome" :
				
				//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				
				break;
		}
		return driver;
	}
}
