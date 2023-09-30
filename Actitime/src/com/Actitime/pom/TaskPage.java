package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	@FindBy (xpath = "//div[.='Add New']")
	private WebElement addnewcust;
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newcust;
	
	@FindBy (xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement entercustomername;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerdescription;
	
	@FindBy (xpath = "//div[.='Create Customer']")
	private WebElement createcust;
	
	@FindBy (xpath = "//div[@class='greyButton cancelBtn']")
	private WebElement cancelbtn;

	//initialization
	public TaskPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getAddnewcust() {
		return addnewcust;
	}

	public WebElement getNewcust() {
		return newcust;
	}

	public WebElement getEntercustomername() {
		return entercustomername;
	}

	public WebElement getCustomerdescription() {
		return customerdescription;
	}

	public WebElement getCreatecust() {
		return createcust;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	
}

