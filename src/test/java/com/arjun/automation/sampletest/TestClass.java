package com.arjun.automation.sampletest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.arjun.automation.genericLib.BaseClass;
import com.arjun.automation.pageActions.LoginPageActions;

public class TestClass extends BaseClass
{
	@Test
	public void LoginToApplication()
	{
		LoginPageActions loginAct = new LoginPageActions(driver, logger);
		
		Assert.assertTrue(loginAct.login("mngr26593", "abc@123"), "Login to Application failed");
	}
	
	@Test (dependsOnMethods = "LoginToApplication")
	public void Test2()
	{
		Assert.assertTrue(true, "Passed");
	}
	
	@Test (dependsOnMethods = "Test2")
	public void Test3()
	{
		Assert.assertTrue(false, "Passed");
	}
}
