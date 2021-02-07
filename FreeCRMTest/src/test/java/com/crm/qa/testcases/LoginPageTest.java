package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super(); // we want initilize properties also of testbase class cll testbase class constructor
	}
	@BeforeMethod
	public void setup() {
		initilization();
		loginPage=new LoginPage();// accese all the fuction of loginpage class bcoz its not static
	}
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title =loginPage.validateLoginPageTile();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
