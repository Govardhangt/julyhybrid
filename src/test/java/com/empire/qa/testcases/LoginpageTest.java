package com.empire.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.empire.qa.base.BaseTest;
import com.empire.qa.pages.HomePage;
import com.empire.qa.pages.LoginPage;

public class LoginpageTest extends BaseTest {

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginpageTest() throws Throwable {
		super();
	}

	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	
	@Test
	public void VerifyLoginpageTitleTest() {
		String title = loginpage.VerifyLoginpageTitle();
		Assert.assertEquals(title, "Empire Home Admin Panelgopi");
	}
	@Test
	public void VerifyEhomeLoginImageTest() {
		boolean img = loginpage.VerifyEhomeLoginImage();
		Assert.assertTrue(img);
	}
	@Test
	public void VerifyEhomeLoginPageTest() throws Throwable {
		homepage = loginpage.VerifyEhomeLoginPage();
	}
	
	@AfterMethod
	
	public void teardown() {
//		driver.quit();
	}
	
}
