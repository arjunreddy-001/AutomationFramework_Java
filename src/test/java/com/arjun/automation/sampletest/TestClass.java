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
		LoginPageActions loginAct = new LoginPageActions(driver);
		
		Assert.assertTrue(loginAct.login("mngr26593", "abc@123"), "Login to Application failed");
	}
}
