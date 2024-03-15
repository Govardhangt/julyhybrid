package com.empire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.empire.qa.base.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(xpath = "//i[@class='fa fa-houzz']")
	WebElement inventory;
	
	@FindBy(xpath = "//a[text()='Add Inventory']")
	WebElement addinventory;
	
	
	public HomePage() throws Throwable {
		super();
	PageFactory.initElements(driver, this);
	}
 
	public String VerifyEhomePageTitle() {
		return driver.getTitle();
	}
	
	public AddInventoryPage VerifyHomepageDashboard() throws Throwable {
		Thread.sleep(3000);
		inventory.click();
		Thread.sleep(3000);
		addinventory.click();
		return new AddInventoryPage();
	}
	
	
}
