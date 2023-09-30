package com.Actitime.Testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;
import com.Actitimr.GenericLibrary.BaseClass;
import com.Actitimr.GenericLibrary.Listenerimplementation;



@Listeners(Listenerimplementation.class)

public class CreateCustomer extends BaseClass{
	
	@Test
	public void createcustomer() throws IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasktab().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewcust().click();
		tp.getNewcust().click();
		FileLibrary f=new FileLibrary();
		String name = f.readDataFromExcel("Sheet1", 1, 1);
		tp.getEntercustomername().sendKeys(name);
		String desp = f.readDataFromExcel("Sheet1", 1, 2);
		tp.getCustomerdescription().sendKeys(desp);
		tp.getCreatecust().click();
		
		String expectedresult = name;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+name+"'])[1]")).getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(expectedresult, actualresult);
		s.assertAll();
		

}
}