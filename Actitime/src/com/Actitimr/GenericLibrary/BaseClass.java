package com.Actitimr.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.LoginPage;

public class BaseClass {
	FileLibrary f = new FileLibrary();
			
	public static	WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("databaseconnected",true);
	}
	@BeforeClass
	public void launchBrowser() throws IOException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.actitime.com");
		String Link = f.readDataFromPropertyFile("url");
		driver.get(Link);
		Reporter.log("Browser launch successfully",true);
		
	}
	@BeforeMethod
	public void Logintoactitime() throws IOException {
//		driver.findElement(By.id("username")).sendKeys("admin");
//		driver.findElement(By.name("pwd")).sendKeys("manager");
//		driver.findElement(By.xpath("//div[.='Logging in ...']"));
		LoginPage lp=new LoginPage(driver);
		String un = f.readDataFromPropertyFile("username");
		lp.getUntbx().sendKeys(un);
		String pw = f.readDataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		
		Reporter.log("logged in successfully",true);
	}
	@AfterMethod
	public void logoutfromActitime() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out SUCCESSFULLY",true);
	}
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("browser closed successfully",true);
		
	}
	@AfterSuite
	public void closedataBaseConnections() {
		Reporter.log("database disconnected",true);
	}

}
