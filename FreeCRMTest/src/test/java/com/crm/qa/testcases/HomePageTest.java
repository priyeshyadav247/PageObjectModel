package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	// TestUtil testUtil; --- frame is avaible
	
	public HomePageTest() {
		super();
	}
	// test cases should be seperated -- independent with each other
	// bedore each test cases -- launch the browser and login
	//@test -- execute test case
	// after each test case-- close the browser
	
	@BeforeMethod
	public void setup() {
		initilization();
		// testUtil=new TestUtil();  --- if frame is available
		loginPage=new LoginPage();// accese all the fuction of loginpage class bcoz its not static
		contactsPage= new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));// bcoz we have to login 1st
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home page title not matched"); //in assertion 3rd path is for comments if match is not found
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		//	testUtil.switchToframe();	-- if frame is avaible no need to write if not availble
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
