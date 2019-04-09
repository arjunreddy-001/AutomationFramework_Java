package com.arjun.automation.pageActions;

import org.openqa.selenium.WebDriver;

import com.arjun.automation.pageObjects.LoginPageObjects;

public class LoginPageActions 
{
	WebDriver driver;
	
	public LoginPageActions(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean login(String username, String passoword)
	{
		LoginPageObjects loginObj = new LoginPageObjects(driver);
		
		try
		{
			loginObj.getTxtUserName().sendKeys(username);
			loginObj.getTxtPassword().sendKeys(passoword);
			loginObj.getBtnLogin().click();
			
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
