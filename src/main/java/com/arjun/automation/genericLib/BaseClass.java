package com.arjun.automation.genericLib;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public WebDriver driver;

	@BeforeClass
	@Parameters({ "browser", "OS", "url" })
	public void setup(String browser, String OS, String url)
	{
		driver = new Driver(driver).getDriver(browser, OS);
		driver.get(url);
		driver.navigate().refresh();
	}

	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
}