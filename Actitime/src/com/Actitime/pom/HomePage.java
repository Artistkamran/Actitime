package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Declaration
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement tasktab;
	@FindBy(xpath="//div[.='Reports']")
	private WebElement Reporttab;
	@FindBy(xpath="//div[.='Users']")
	private WebElement Usertab;
	
	@FindBy (id="logoutLink")
	private WebElement logoutlink;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//utilization

	public WebElement getTasktab() {
		return tasktab;
	}

	public WebElement getReporttab() {
		return Reporttab;
	}

	public WebElement getUsertab() {
		return Usertab;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	
	
}
