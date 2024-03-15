package com.empire.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.empire.qa.base.BaseTest;
import com.empire.qa.pages.AddInventoryPage;
import com.empire.qa.pages.AllInventoryPage;
import com.empire.qa.pages.HomePage;
import com.empire.qa.pages.LoginPage;
import com.empire.qa.utils.UtilsTest;



public class AddInventoryTest extends BaseTest {
	LoginPage loginpage;
	HomePage homepage;
	AddInventoryPage addinventorypage;
	AllInventoryPage allinventorypage;
	static String shname = "Sheet1";
	
	public AddInventoryTest() throws Throwable {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		addinventorypage = new AddInventoryPage();
		allinventorypage = new AllInventoryPage();
		homepage = loginpage.VerifyEhomeLoginPage();
		addinventorypage = homepage.VerifyHomepageDashboard();
		
	}
	
	@Test
	public void VerifyAddInventorypageTitleTest() {
		String title = addinventorypage.VerifyAddInventorypageTitle();
		Assert.assertEquals(title, "Empire Home Admin Panel");
	}
	
	@DataProvider
	public Object[][] ExcelData() throws Throwable {
		Object[][] data = UtilsTest.getExcelData(shname);
		return data;
	}
	
	@Test(dataProvider = "ExcelData")
	public void VerifyAddInventoryPageTest(String modelnumber, String itemtitle, String itemdescription, String height, String width, String breadth, String colorname, String actualprice, String qty) throws Throwable {
		allinventorypage = addinventorypage.VerifyAddInventoryPage(modelnumber, itemtitle, itemdescription, height, width, breadth, colorname, actualprice, qty);
	}
	
	@AfterMethod
	public void teardown() {
//		driver.quit();
	}

}
