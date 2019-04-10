package com.arjun.automation.genericLib;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public WebDriver driver;

	@BeforeClass
	@Parameters({ "browser", "OS", "url", "title" })
	public void setup(String browser, String OS, String url, String title)
	{
		driver = new Driver(driver).getDriver(browser, OS);
		
		int maxAttempts = 3;
		int AttemptNum = 0;
		do
		{
			driver.get(url);
			AttemptNum++;
			
			if(driver.getTitle().contains(title))
			{
				break;
			}
			
			if(AttemptNum == maxAttempts)
			{
				Assert.assertEquals(title, driver.getTitle(), "Failed to load URL: " + url + ", WebPage title not matched");
			}
		}
		while((!driver.getTitle().contains(title)));
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}