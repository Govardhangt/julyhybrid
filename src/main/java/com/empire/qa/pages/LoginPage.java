package com.empire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.empire.qa.base.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(name="emailid")
	WebElement uname;
	
	@FindBy(id="pword")
	WebElement pwd;
	
	@FindBy(xpath = "//img[@src='/WebApp/assets/dist/img/logo.png']")
	WebElement ehomeimg;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginbtn;
	
	public LoginPage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyLoginpageTitle() {
		return driver.getTitle();
	}

	public boolean VerifyEhomeLoginImage() {
		return ehomeimg.isDisplayed();
	}
	
	public HomePage VerifyEhomeLoginPage() throws Throwable {
		uname.sendKeys(prop.getProperty("username"));
		pwd.sendKeys(prop.getProperty("password"));
		loginbtn.click();
		return new HomePage();
	}
}
