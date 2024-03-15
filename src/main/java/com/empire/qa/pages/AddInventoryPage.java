package com.empire.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.empire.qa.base.BaseTest;
import com.empire.qa.utils.UtilsTest;

import bsh.UtilTargetError;

public class AddInventoryPage extends BaseTest {

	@FindBy(xpath="//select[@id='catDD']")
	WebElement categorydrp;
	
	@FindBy(name="SubCategoryId")
	WebElement subcategorydrp;
	
	@FindBy(name="ModelNumber")
	WebElement modelnum;
	
	@FindBy(name="Title")
	WebElement itemt;
	
	@FindBy(xpath="//textarea[@name='ItemDescription']")
	WebElement itemdesc;
	
	@FindBy(xpath="//input[@name='Height']")
	WebElement height;
	
	@FindBy(xpath="//input[@name='Width']")
	WebElement width;
	
	@FindBy(xpath="//input[@name='Breadth']")
	WebElement breadth;
	
	@FindBy(xpath="//input[@name='ColorName']")
	WebElement colorname;
	
	@FindBy(id="RecievedDate")
	WebElement recieveddate;
	
	@FindBy(xpath="//input[@name='ActualPrice']")
	WebElement actualprice;
	
	@FindBy(id="factor")
	WebElement mrpfactor;
	
	@FindBy(xpath="//input[@name='Qty']")
	WebElement qty;
	
	@FindBy(xpath="//input[@name='ProductMainImageUploaded']")
	WebElement primaryimgupload;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement savebtn;
	
	public AddInventoryPage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyAddInventorypageTitle() {
		return driver.getTitle();
	}
	
	public AllInventoryPage VerifyAddInventoryPage(String modelnumber, String itemtitle, String itemdescription, String height, String width, String breadth, String colorname, String actualprice, String qty) throws Throwable {
		UtilsTest.DropdownMethod(categorydrp, "bedroom");
		UtilsTest.DropdownMethod(subcategorydrp, "bed");
		modelnum.sendKeys(modelnumber);
		itemt.sendKeys(itemtitle);
		itemdesc.sendKeys(itemdescription);
		this.height.sendKeys(height);
		this.width.sendKeys(width);
		this.breadth.sendKeys(breadth);
		this.colorname.sendKeys(colorname);
		recieveddate.sendKeys("24-11-2023");
		this.actualprice.sendKeys(actualprice);
		UtilsTest.DropdownMethod(mrpfactor, "4.50");
		this.qty.clear();
		this.qty.sendKeys(qty);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", primaryimgupload);
		UtilsTest.UploadFiles();
		savebtn.click();
		return new AllInventoryPage();
	}

}
