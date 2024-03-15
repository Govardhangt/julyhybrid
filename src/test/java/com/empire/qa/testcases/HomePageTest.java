package com.empire.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.empire.qa.base.BaseTest;
import com.empire.qa.pages.AddInventoryPage;
import com.empire.qa.pages.HomePage;
import com.empire.qa.pages.LoginPage;

public class HomePageTest extends BaseTest {
 
	LoginPage loginpage;
	HomePage homepage;
	AddInventoryPage addinventorypage;
	
	public HomePageTest() throws Throwable {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		addinventorypage = new AddInventoryPage();
		homepage = loginpage.VerifyEhomeLoginPage();
	}
	
	@Test
	public void VerifyEhomePageTitleTest() {
		String title = homepage.VerifyEhomePageTitle();
		Assert.assertEquals(title, "Empire Home Admin Panelgova");
	}
	
	@Test
	public void VerifyHomepageDashboardTest() throws Throwable {
		addinventorypage = homepage.VerifyHomepageDashboard();
	}
	
	@AfterMethod
	public void teardown() {
//		driver.quit();
	}

}
