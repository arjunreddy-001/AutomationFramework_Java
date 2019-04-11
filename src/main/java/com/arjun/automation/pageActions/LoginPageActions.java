package com.arjun.automation.pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.arjun.automation.pageObjects.LoginPageObjects;

public class LoginPageActions 
{
	WebDriver driver;
	Logger logger;
	
	public LoginPageActions(WebDriver driver, Logger logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	public boolean login(String username, String passoword)
	{
		LoginPageObjects loginObj = new LoginPageObjects(driver);
		
		try
		{
			loginObj.getTxtUserName().sendKeys(username);
			loginObj.getTxtPassword().sendKeys(passoword);
			loginObj.getBtnLogin().click();
			
			logger.info("Entered username and password, clicked on Login button");
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
